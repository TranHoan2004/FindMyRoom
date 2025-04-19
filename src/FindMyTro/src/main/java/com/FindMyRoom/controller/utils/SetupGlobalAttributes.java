package com.FindMyRoom.controller.utils;

import org.jetbrains.annotations.NotNull;
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

    public void setupHomePage(@NotNull Model model, Locale locale) {
        model.addAttribute("home_page_title", messageSource.getMessage("home_page_title", null, locale));
        model.addAttribute("create_a_post", messageSource.getMessage("create_a_post", null, locale));
        model.addAttribute("what_you_want_to_post", messageSource.getMessage("what_you_want_to_post", null, locale));
        model.addAttribute("special_news", messageSource.getMessage("special_news", null, locale));
        model.addAttribute("filter_title", messageSource.getMessage("filter_title", null, locale));
    }

    public void setupFooter(@NotNull Model model, Locale locale) {
        model.addAttribute("contact_title", messageSource.getMessage("contact_title", null, locale));
    }

    public void setupLogout(@NotNull Model model, Locale locale) {
        model.addAttribute("logout_title", messageSource.getMessage("logout_title", null, locale));
        model.addAttribute("logout_alert", messageSource.getMessage("logout_alert", null, locale));
        model.addAttribute("cancel_btn", messageSource.getMessage("cancel_btn", null, locale));
    }

    public void setupSearchPage(@NotNull Model model, Locale locale) {
        model.addAttribute("search_title", messageSource.getMessage("search_title", null, locale));
        model.addAttribute("search_placeholder", messageSource.getMessage("search_placeholder", null, locale));
    }

    public void setupStory(@NotNull Model model, Locale locale) {
        model.addAttribute("news_events", messageSource.getMessage("news_events", null, locale));
    }

    public void setupSlider(@NotNull Model model, Locale locale) {
        model.addAttribute("previous_label", messageSource.getMessage("previous_label", null, locale));
        model.addAttribute("next_label", messageSource.getMessage("next_label", null, locale));
    }

    public void setupHeader(@NotNull Model model, Locale locale) {
        model.addAttribute("web_name", messageSource.getMessage("web_name", null, locale));
        model.addAttribute("about_title", messageSource.getMessage("about_title", null, locale));
        model.addAttribute("services_title", messageSource.getMessage("services_title", null, locale));
        model.addAttribute("profile_title", messageSource.getMessage("profile_title", null, locale));
        model.addAttribute("setting_title", messageSource.getMessage("setting_title", null, locale));
    }

    public void setupRegisterPage(@NotNull Model model, Locale locale) {
        model.addAttribute("register_title", messageSource.getMessage("register_title", null, locale));
        model.addAttribute("create_new_account", messageSource.getMessage("create_new_account", null, locale));
        model.addAttribute("email_title", messageSource.getMessage("email_title", null, locale));
        model.addAttribute("question_have_an_account", messageSource.getMessage("question_have_an_account", null, locale));
        model.addAttribute("verify_email", messageSource.getMessage("verify_email", null, locale));
        model.addAttribute("verify_code", messageSource.getMessage("verify_code", null, locale));
        model.addAttribute("your_info", messageSource.getMessage("your_info", null, locale));
        model.addAttribute("phone_number", messageSource.getMessage("phone_number", null, locale));
        model.addAttribute("rewrite_password", messageSource.getMessage("rewrite_password", null, locale));
        model.addAttribute("send_verify_code", messageSource.getMessage("send_verify_code", null, locale));
        model.addAttribute("check_btn", messageSource.getMessage("check_btn", null, locale));
        model.addAttribute("create_account_btn", messageSource.getMessage("create_account_btn", null, locale));
    }
    // </editor-fold>

    // <editor-fold> desc="Notification"
    public void setupNotificationPopup(@NotNull Model model, Locale locale) {
        model.addAttribute("notification_title", messageSource.getMessage("notification_title", null, locale));
    }
    // </editor-fold>
}
