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
        model.addAttribute("google_title", messageSource.getMessage("google_title", null, locale));
        model.addAttribute("facebook_title", messageSource.getMessage("facebook_title", null, locale));
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

    // <editor-fold> desc="User"
    public void setupDeleteAccountPage(@NotNull Model model, Locale locale) {
        model.addAttribute("delete_title", messageSource.getMessage("delete_title", null, locale));
        model.addAttribute("confirm_before_delete", messageSource.getMessage("confirm_before_delete", null, locale));
        model.addAttribute("alert_before_delete", messageSource.getMessage("alert_before_delete", null, locale));
        model.addAttribute("delete_label", messageSource.getMessage("delete_label", null, locale));
    }

    public void setupProfilePage(@NotNull Model model, Locale locale) {
        model.addAttribute("system_noti", messageSource.getMessage("system_noti", null, locale));
        model.addAttribute("sale_title", messageSource.getMessage("sale_title", null, locale));
        model.addAttribute("from_houseowner", messageSource.getMessage("from_houseowner", null, locale));
        model.addAttribute("new_message_from_houseowner", messageSource.getMessage("new_message_from_houseowner", null, locale));
        model.addAttribute("see_response", messageSource.getMessage("see_response", null, locale));
        model.addAttribute("unread_title", messageSource.getMessage("unread_title", null, locale));
        model.addAttribute("user_information", messageSource.getMessage("user_information", null, locale));
        model.addAttribute("image_select", messageSource.getMessage("image_select", null, locale));
        model.addAttribute("fullname_title", messageSource.getMessage("fullname_title", null, locale));
        model.addAttribute("dob", messageSource.getMessage("dob", null, locale));
        model.addAttribute("gender_title", messageSource.getMessage("gender_title", null, locale));
        model.addAttribute("male_title", messageSource.getMessage("male_title", null, locale));
        model.addAttribute("female_title", messageSource.getMessage("female_title", null, locale));
        model.addAttribute("other_gender", messageSource.getMessage("other_gender", null, locale));
        model.addAttribute("province_city", messageSource.getMessage("province_city", null, locale));
        model.addAttribute("district", messageSource.getMessage("district", null, locale));
        model.addAttribute("house_number", messageSource.getMessage("house_number", null, locale));
        model.addAttribute("street_name", messageSource.getMessage("street_name", null, locale));
        model.addAttribute("edit_btn", messageSource.getMessage("edit_btn", null, locale));
        model.addAttribute("save_btn", messageSource.getMessage("save_btn", null, locale));
        model.addAttribute("reset_password", messageSource.getMessage("reset_password", null, locale));
        model.addAttribute("current_password", messageSource.getMessage("current_password", null, locale));
        model.addAttribute("enter_current_password", messageSource.getMessage("enter_current_password", null, locale));
        model.addAttribute("please_enter_current_password", messageSource.getMessage("please_enter_current_password", null, locale));
        model.addAttribute("new_password", messageSource.getMessage("new_password", null, locale));
        model.addAttribute("enter_new_password", messageSource.getMessage("enter_new_password", null, locale));
        model.addAttribute("new_password_condition", messageSource.getMessage("new_password_condition", null, locale));
        model.addAttribute("enter_new_password_again", messageSource.getMessage("enter_new_password_again", null, locale));
        model.addAttribute("notification_setting", messageSource.getMessage("notification_setting", null, locale));
        model.addAttribute("sale_noti", messageSource.getMessage("sale_noti", null, locale));
        model.addAttribute("receive_new_sale_noti", messageSource.getMessage("receive_new_sale_noti", null, locale));
        model.addAttribute("display_on_web", messageSource.getMessage("display_on_web", null, locale));
        model.addAttribute("send_by_email", messageSource.getMessage("send_by_email", null, locale));
        model.addAttribute("receive_all_noti", messageSource.getMessage("receive_all_noti", null, locale));
        model.addAttribute("noti_houseowner", messageSource.getMessage("noti_houseowner", null, locale));
        model.addAttribute("receive_noti_houseowner", messageSource.getMessage("receive_noti_houseowner", null, locale));
        model.addAttribute("my_post", messageSource.getMessage("my_post", null, locale));
        model.addAttribute("contact_history", messageSource.getMessage("contact_history", null, locale));
        model.addAttribute("filter_by_action", messageSource.getMessage("filter_by_action", null, locale));
        model.addAttribute("all_title", messageSource.getMessage("all_title", null, locale));
        model.addAttribute("seen_title", messageSource.getMessage("seen_title", null, locale));
        model.addAttribute("saved_title", messageSource.getMessage("saved_title", null, locale));
        model.addAttribute("contacted", messageSource.getMessage("contacted", null, locale));
        model.addAttribute("post_title", messageSource.getMessage("post_title", null, locale));
        model.addAttribute("action_title", messageSource.getMessage("action_title", null, locale));
        model.addAttribute("time_title", messageSource.getMessage("time_title", null, locale));
        model.addAttribute("clear_history", messageSource.getMessage("clear_history", null, locale));
        model.addAttribute("save_noti_setting", messageSource.getMessage("save_noti_setting", null, locale));
        model.addAttribute("alert_before_delete_history", messageSource.getMessage("alert_before_delete_history", null, locale));
        model.addAttribute("read_only", messageSource.getMessage("read_only", null, locale));
        model.addAttribute("alert_18_older", messageSource.getMessage("alert_18_older", null, locale));
        model.addAttribute("alert_phone_number", messageSource.getMessage("alert_phone_number", null, locale));
        model.addAttribute("alert_address", messageSource.getMessage("alert_address", null, locale));
        model.addAttribute("error_title", messageSource.getMessage("error_title", null, locale));
        model.addAttribute("update_successfully", messageSource.getMessage("update_successfully", null, locale));
        model.addAttribute("password_not_accepted1", messageSource.getMessage("password_not_accepted1", null, locale));
        model.addAttribute("password_not_accepted2", messageSource.getMessage("password_not_accepted2", null, locale));
        model.addAttribute("password_accepted", messageSource.getMessage("password_accepted", null, locale));
        model.addAttribute("update_password_successfully", messageSource.getMessage("update_password_successfully", null, locale));
//        model.addAttribute("", messageSource.getMessage("", null, locale));
    }
    // </editor-fold>

    // <editor-fold> desc="Notification"
    public void setupNotificationPopup(@NotNull Model model, Locale locale) {
        model.addAttribute("notification_title", messageSource.getMessage("notification_title", null, locale));
    }
    // </editor-fold>
}
