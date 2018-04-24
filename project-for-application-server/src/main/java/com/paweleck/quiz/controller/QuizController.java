package com.paweleck.quiz.controller;

import com.paweleck.quiz.entity.Question;
import com.paweleck.quiz.entity.Result;
import com.paweleck.quiz.entity.User;
import com.paweleck.quiz.repository.QuestDao;
import com.paweleck.quiz.service.QuestService;
import com.paweleck.quiz.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class QuizController {
    private static int numberOfQuestion = 0;

    @Autowired
    private HttpSession httpSession;
//    @Autowired
//    private QuestDao questDao;

    @Autowired
    private QuestService questService;
    @Autowired
    private ResultService resultService;

    private Boolean isQuizStart = false;
    private Integer score = 0;
    private Integer progressBar = 0;
    private Boolean isEndQuiz = false;


    @RequestMapping("/startQuiz")
    public ModelAndView startQuiz(final HttpServletRequest request) {
        isQuizStart = true;


        if (isEndQuiz) {
//            isQuizStart = false;
            score = 0;
            progressBar = 0;
            isEndQuiz = false;
            numberOfQuestion = 0;
        }
        List<Question> questions = questService.getAllQuestions();
        return new ModelAndView("/home")
                .addObject("sesLoginName", httpSession.getAttribute("sesLoginName"))
                .addObject("sessionHttp", httpSession)
                .addObject("isQuizStart", isQuizStart)
                .addObject("question", questions.get(numberOfQuestion).getQuestion())
                .addObject("firstResponse", questions.get(numberOfQuestion).getResponse().getFirstResponse())
                .addObject("secondResponse", questions.get(numberOfQuestion).getResponse().getSecondResponse())
                .addObject("thirdResponse", questions.get(numberOfQuestion).getResponse().getThirdResponse())
                .addObject("fourthResponse", questions.get(numberOfQuestion).getResponse().getFourthResponse())
                .addObject("progress", progressBar);
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET, params = "sendResponse")
    public ModelAndView sendResponse(@RequestParam String response, final HttpServletRequest request) {

        List<Question> questions = questService.getAllQuestions();
        setProgressBar(getProgressBar() + 10);
        checkResponse(response, questions.get(numberOfQuestion), request);

        numberOfQuestion++;

        System.out.println("Correct responses: " + score);
        if (numberOfQuestion > questService.getAllQuestions().size() - 1) {
            isEndQuiz = true;

            return new ModelAndView("/home")
                    .addObject("sesLoginName", httpSession.getAttribute("sesLoginName"))
                    .addObject("sessionHttp", httpSession)
                    .addObject("isQuizStart", isQuizStart)
                    .addObject("endQuiz", isEndQuiz)
                    .addObject("progress", progressBar)
                    .addObject("report", true);
        }

        return new ModelAndView("/home")
                .addObject("sesLoginName", httpSession.getAttribute("sesLoginName"))
                .addObject("sessionHttp", httpSession)
                .addObject("isQuizStart", isQuizStart)
                .addObject("question", questions.get(numberOfQuestion).getQuestion())
                .addObject("firstResponse", questions.get(numberOfQuestion).getResponse().getFirstResponse())
                .addObject("secondResponse", questions.get(numberOfQuestion).getResponse().getSecondResponse())
                .addObject("thirdResponse", questions.get(numberOfQuestion).getResponse().getThirdResponse())
                .addObject("fourthResponse", questions.get(numberOfQuestion).getResponse().getFourthResponse())
                .addObject("endQuiz", isEndQuiz)
                .addObject("progress", progressBar)
                .addObject("result", score);
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET, params = "results")
    public ModelAndView result() {



        return new ModelAndView("/home")
                .addObject("sesLoginName", httpSession.getAttribute("sesLoginName"))
                .addObject("sessionHttp", httpSession)
                .addObject("isQuizStart", isQuizStart)
//                .addObject("question", questions.get(numberOfQuestion).getQuestion())
//                .addObject("firstResponse", questions.get(numberOfQuestion).getResponse().getFirstResponse())
//                .addObject("secondResponse", questions.get(numberOfQuestion).getResponse().getSecondResponse())
//                .addObject("thirdResponse", questions.get(numberOfQuestion).getResponse().getThirdResponse())
//                .addObject("fourthResponse", questions.get(numberOfQuestion).getResponse().getFourthResponse())
                .addObject("endQuiz", isEndQuiz)
                .addObject("progress", progressBar)
                .addObject("result", score)
                .addObject("isResponseSend", true);
    }

    private void checkResponse(String responseId, Question question, final HttpServletRequest request) {
        String response = null;
        switch (responseId) {
            case "1":
                response = question.getResponse().getFirstResponse();
                break;
            case "2":
                response = question.getResponse().getSecondResponse();
                break;
            case "3":
                response = question.getResponse().getThirdResponse();
                break;
            case "4":
                response = question.getResponse().getFourthResponse();
                break;
            default:
                break;
        }
        HttpSession httpSession = request.getSession();
        Result result = new Result();
        result.setQuestion(question);
        result.setUser((User) httpSession.getAttribute("user"));
        result.setUserResponse(response);
        resultService.addResult(result);
        System.out.println("Question " + question.getId() + response + " vs " + question.getResponse().getCorrectResponse());
        if (response.equals(question.getResponse().getCorrectResponse())) {
            score++;
        }
    }

    private Integer getProgressBar() {
        return progressBar;
    }

    private void setProgressBar(Integer progressBar) {
        this.progressBar = progressBar;
    }
}
