package com.FindMyRoom.controller.utils;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Locale;

@Component
public class SetupGlobalAttributes {
    private final MessageSource messageSource;

    public SetupGlobalAttributes(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // <editor-fold> desc="Common"
    public void setupLoginPage(@NotNull Model model, Locale locale) {
        model.addAttribute("login_title", messageSource.getMessage("login_title", null, locale));
        model.addAttribute("login_here_title", messageSource.getMessage("login_here_title", null, locale));
        model.addAttribute("username_title", messageSource.getMessage("username_title", null, locale));
        model.addAttribute("password_title", messageSource.getMessage("password_title", null, locale));
        model.addAttribute("remember_me_title", messageSource.getMessage("remember_me_title", null, locale));
        model.addAttribute("sign_in_with_other_method", messageSource.getMessage("sign_in_with_other_method", null, locale));
        model.addAttribute("forgot_pass", messageSource.getMessage("forgot_pass", null, locale));
        model.addAttribute("or_title", messageSource.getMessage("or_title", null, locale));
        model.addAttribute("create_account", messageSource.getMessage("create_account", null, locale));
    }

    // </editor-fold>
}
