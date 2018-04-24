package com.paweleck.quiz.controller;

import com.paweleck.quiz.entity.User;
import com.paweleck.quiz.repository.UserDao;
import com.paweleck.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class UserController {
//    @Autowired
//    private UserDao userDao;
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ModelAndView createUser(@RequestParam String signUpLogin, @RequestParam String loginPass, @RequestParam String loginEmail) {
        User user = new User();
        user.setName(signUpLogin);
        user.setPassword(loginPass);
        user.setEmail(loginEmail);
        user.setJoinDate(new Date());
        userService.createUser(user);

        return new ModelAndView("/home")
                .addObject("login", signUpLogin)
                .addObject("password", loginPass)
                .addObject("email", loginEmail);
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView loginUser(@RequestParam String loginName, @RequestParam String loginPass, final HttpServletRequest request) {
        ModelAndView modelAndView = null;
        httpSession = request.getSession();
        httpSession.setAttribute("sesLoginName", loginName);
        httpSession.setAttribute("sesLoginPassword", loginPass);


        User user = userService.findOneByLoginAndPassword(loginName, loginPass);
        httpSession.setAttribute("user", user);
        if (user != null) {
            modelAndView = new ModelAndView("/home");
            modelAndView.addObject("sesLoginName", httpSession.getAttribute("sesLoginName"));
            modelAndView.addObject("sessionHttp", httpSession);

        } else {
            modelAndView = new ModelAndView("/login")
                    .addObject("errorLogin", "Invalid login or password");
        }

        return modelAndView;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(final HttpServletRequest request) {
        if (httpSession != null) {
            httpSession = request.getSession(false);
            httpSession.invalidate();
            httpSession = null;
        }
        return new ModelAndView("/home");
    }
}
