package com.cloud.cloudstorage.controller;


import com.cloud.cloudstorage.model.User;
import com.cloud.cloudstorage.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/signup")
public class SignupController {
    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String signupView(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping()
    public String signupUser(@ModelAttribute User user, Model model) {
        String signupError = null;
        if (!userService.isUsernameAvailable(user.getUsername())) {
            signupError = "そのユーザー名はすでに存在します。";
            model.addAttribute("user", user);
        } else if (user.getPassword().length() < 6) {
            signupError = "パスワードは6文字以上です。";
            model.addAttribute("user", user);
        }

        if (signupError == null) {
            int rowsAdded = userService.createUser(user);
            if (rowsAdded < 0) {
                signupError = "エラーが発生しました。再入力してください。";
            }
        }

        if (signupError == null) {
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", signupError);
        }

        return "signup";
    }
}
