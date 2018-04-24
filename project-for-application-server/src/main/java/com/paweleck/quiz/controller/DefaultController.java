package com.paweleck.quiz.controller;

import com.paweleck.quiz.entity.Question;
import com.paweleck.quiz.entity.Response;
import com.paweleck.quiz.entity.User;
import com.paweleck.quiz.repository.QuestDao;
import com.paweleck.quiz.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
public class DefaultController {
//    private static int numberOfQuestion = 0;

    @Autowired
    private UserDao userDao;
    @Autowired
    private QuestDao questDao;
    @Autowired
    private HttpSession httpSession;
//
//    private Boolean isQuizStart = false;
//
//    private Boolean isEndQuiz = false;
//
//    private Integer progressBar = 0;
//
//    private Integer result = 0;
//
//    private Boolean isSend = false;
//
//    public Integer getProgressBar() {
//        return progressBar;
//    }
//
//    public void setProgressBar(Integer progressBar) {
//        this.progressBar = progressBar;
//    }

    @RequestMapping("/")
    public ModelAndView homePage() {

//        Question question = new Question();
//        question.setQuestion("UNIX, rodzina systemow operacyjnych napedzajaca wiekszosc wspolczesnych komputerow, serwerow i smartfonow zostala zapoczatkowana przez");
//        Response response = new Response();
//        response.setFirstResponse("Steve'a Jobsa i Steve'a Wozniaka");
//        response.setSecondResponse("Dennisa Ritchie i Kena Thompsona");
//        response.setThirdResponse("Linusa Thorvaldsa");
//        response.setFourthResponse("Billa Gatesa i Paula Allena");
//        response.setCorrectResponse("Dennisa Ritchie i Kena Thompsona");
//        question.setResponse(response);
//        questDao.createQuest(question);


        return new ModelAndView("/home");
    }

    @RequestMapping("/signUp")
    public ModelAndView signUpPage() {
        return new ModelAndView("/signUp");
    }

    @RequestMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("/login");
    }

//    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
//    public ModelAndView createUser(@RequestParam String signUpLogin, @RequestParam String loginPass, @RequestParam String loginEmail) {
//        User user = new User();
//        user.setName(signUpLogin);
//        user.setPassword(loginPass);
//        user.setEmail(loginEmail);
//        user.setJoinDate(new Date());
//        userDao.createUser(user);
//
//        return new ModelAndView("/home")
//                .addObject("login", signUpLogin)
//                .addObject("password", loginPass)
//                .addObject("email", loginEmail);
//    }
//
//    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
//    public ModelAndView loginUser(@RequestParam String loginName, @RequestParam String loginPass, final HttpServletRequest request) {
//        ModelAndView modelAndView = null;
//        httpSession = request.getSession();
//        httpSession.setAttribute("sesLoginName", loginName);
//        httpSession.setAttribute("sesLoginPassword", loginPass);
//
//        User user = userDao.findOneByLoginAndPassword(loginName, loginPass);
//
//        if (user != null) {
//            modelAndView = new ModelAndView("/home");
//            modelAndView.addObject("sesLoginName", httpSession.getAttribute("sesLoginName"));
//            modelAndView.addObject("sessionHttp", httpSession);
//
//        } else {
//            modelAndView = new ModelAndView("/login")
//                    .addObject("errorLogin", "Invalid login or password");
//        }
//
//        return modelAndView;
//    }

//    @RequestMapping("/logout")
//    public ModelAndView logout(final HttpServletRequest request) {
//        if (httpSession != null) {
//            httpSession = request.getSession(false);
//            httpSession.invalidate();
//            httpSession = null;
//        }
//        return new ModelAndView("/home");
//    }

//    @RequestMapping("/startQuiz")
//    public ModelAndView startQuiz(final HttpServletRequest request) {
//        isQuizStart = true;
//        List<Question> questions = questDao.getAllQuestions();
//        return new ModelAndView("/home")
//                .addObject("sesLoginName", httpSession.getAttribute("sesLoginName"))
//                .addObject("sessionHttp", httpSession)
//                .addObject("isQuizStart", isQuizStart)
//                .addObject("question", questions.get(numberOfQuestion).getQuestion())
//                .addObject("firstResponse", questions.get(numberOfQuestion).getResponse().getFirstResponse())
//                .addObject("secondResponse", questions.get(numberOfQuestion).getResponse().getSecondResponse())
//                .addObject("thirdResponse", questions.get(numberOfQuestion).getResponse().getThirdResponse())
//                .addObject("fourthResponse", questions.get(numberOfQuestion).getResponse().getFourthResponse())
//                .addObject("progress", progressBar);
//    }

//    @RequestMapping(value = "/result", method = RequestMethod.GET, params = "sendResponse")
//    public ModelAndView sendResponse(@RequestParam String response) {
//
//        List<Question> questions = questDao.getAllQuestions();
//        setProgressBar(getProgressBar() + 10);
//        checkResponse(response, questions.get(numberOfQuestion));
//        numberOfQuestion++;
//
//        System.out.println("Correct responses: " + result);
//        if (numberOfQuestion > questDao.getAllQuestions().size() - 1) {
//            isEndQuiz = true;
//
//            return new ModelAndView("/home")
//                    .addObject("sesLoginName", httpSession.getAttribute("sesLoginName"))
//                    .addObject("sessionHttp", httpSession)
//                    .addObject("isQuizStart", isQuizStart)
//                    .addObject("endQuiz", isEndQuiz)
//                    .addObject("progress", progressBar)
//                    .addObject("report", true);
//        }
//
//        return new ModelAndView("/home")
//                .addObject("sesLoginName", httpSession.getAttribute("sesLoginName"))
//                .addObject("sessionHttp", httpSession)
//                .addObject("isQuizStart", isQuizStart)
//                .addObject("question", questions.get(numberOfQuestion).getQuestion())
//                .addObject("firstResponse", questions.get(numberOfQuestion).getResponse().getFirstResponse())
//                .addObject("secondResponse", questions.get(numberOfQuestion).getResponse().getSecondResponse())
//                .addObject("thirdResponse", questions.get(numberOfQuestion).getResponse().getThirdResponse())
//                .addObject("fourthResponse", questions.get(numberOfQuestion).getResponse().getFourthResponse())
//                .addObject("endQuiz", isEndQuiz)
//                .addObject("progress", progressBar)
//                .addObject("result", result);
//    }
//
//    @RequestMapping(value = "/result", method = RequestMethod.GET, params = "results")
//    public ModelAndView result() {
//        return new ModelAndView("/home")
//                .addObject("sesLoginName", httpSession.getAttribute("sesLoginName"))
//                .addObject("sessionHttp", httpSession)
//                .addObject("isQuizStart", isQuizStart)
////                .addObject("question", questions.get(numberOfQuestion).getQuestion())
////                .addObject("firstResponse", questions.get(numberOfQuestion).getResponse().getFirstResponse())
////                .addObject("secondResponse", questions.get(numberOfQuestion).getResponse().getSecondResponse())
////                .addObject("thirdResponse", questions.get(numberOfQuestion).getResponse().getThirdResponse())
////                .addObject("fourthResponse", questions.get(numberOfQuestion).getResponse().getFourthResponse())
//                .addObject("endQuiz", isEndQuiz)
//                .addObject("progress", progressBar)
//                .addObject("result", result)
//                .addObject("isResponseSend",true);
//    }
//
//    private void checkResponse(String responseId, Question question){
//        String response = null;
//        switch (responseId){
//            case "1":
//                response = question.getResponse().getFirstResponse();
//                break;
//            case "2":
//                response = question.getResponse().getSecondResponse();
//                break;
//            case "3":
//                response = question.getResponse().getThirdResponse();
//                break;
//            case "4":
//                response = question.getResponse().getFourthResponse();
//                break;
//            default:
//                break;
//        }
//        System.out.println("Question " + question.getId() + response + " vs " + question.getResponse().getCorrectResponse());
//        if(response.equals(question.getResponse().getCorrectResponse())){
//            result++;
//        }
//    }


}
