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

    public void setupForgotPage(@NotNull Model model, Locale locale) {
        model.addAttribute("forgot_pasword", messageSource.getMessage("forgot_pasword", null, locale));
        model.addAttribute("your_password", messageSource.getMessage("your_password", null, locale));
    }

    public void setupAccessDeniedPage(@NotNull Model model, Locale locale) {
        model.addAttribute("access_denied_title", messageSource.getMessage("access_denied_title", null, locale));
        model.addAttribute("h1_title", messageSource.getMessage("h1_title", null, locale));
        model.addAttribute("h3_title", messageSource.getMessage("h3_title", null, locale));
        model.addAttribute("p_title", messageSource.getMessage("p_title", null, locale));
        model.addAttribute("a_title", messageSource.getMessage("a_title", null, locale));
    }

    public void setup404ErrorPage(@NotNull Model model, Locale locale) {
        model.addAttribute("error_404_title", messageSource.getMessage("404_error_title", null, locale));
        model.addAttribute("error_404_h1", messageSource.getMessage("404_error_h1", null, locale));
        model.addAttribute("error_404_h2", messageSource.getMessage("404_error_h2", null, locale));
        model.addAttribute("error_404_p", messageSource.getMessage("404_error_p", null, locale));
        model.addAttribute("error_404_a", messageSource.getMessage("404_error_a", null, locale));
    }

    public void setupSettingPage(@NotNull Model model, Locale locale) {
        model.addAttribute("setting_page", messageSource.getMessage("setting_page", null, locale));
        model.addAttribute("display_language", messageSource.getMessage("display_language", null, locale));
        model.addAttribute("select_language", messageSource.getMessage("select_language", null, locale));
        model.addAttribute("display_mode", messageSource.getMessage("display_mode", null, locale));
        model.addAttribute("dark_mode", messageSource.getMessage("dark_mode", null, locale));
        model.addAttribute("associate_bank_account", messageSource.getMessage("associate_bank_account", null, locale));
        model.addAttribute("associate_bank_account_content", messageSource.getMessage("associate_bank_account_content", null, locale));
        model.addAttribute("association_manage", messageSource.getMessage("association_manage", null, locale));
        model.addAttribute("activity_log", messageSource.getMessage("activity_log", null, locale));
        model.addAttribute("activity_log_content", messageSource.getMessage("activity_log_content", null, locale));
        model.addAttribute("view_log", messageSource.getMessage("view_log", null, locale));
        model.addAttribute("community_policy", messageSource.getMessage("community_policy", null, locale));
        model.addAttribute("community_policy_content", messageSource.getMessage("community_policy_content", null, locale));
        model.addAttribute("view_detail", messageSource.getMessage("view_detail", null, locale));
        model.addAttribute("delete_account", messageSource.getMessage("delete_account", null, locale));
        model.addAttribute("delete_account_content", messageSource.getMessage("delete_account_content", null, locale));
//        model.addAttribute("", messageSource.getMessage("", null, locale));
    }
    // </editor-fold>

    // <editor-fold> desc="Notification"
    public void setupNotificationPopup(@NotNull Model model, Locale locale) {
        model.addAttribute("notification_title", messageSource.getMessage("notification_title", null, locale));
    }
    // </editor-fold>
}
