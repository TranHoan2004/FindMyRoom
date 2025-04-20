package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.SetupGlobalAttributes;
import org.jetbrains.annotations.NotNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Logger;

@ControllerAdvice
public class GlobalAttributesController {
    private final SetupGlobalAttributes attr;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public GlobalAttributesController(SetupGlobalAttributes attr) {
        this.attr = attr;
    }

    @ModelAttribute
    public void addAttributes(Model model, Locale locale) {
        Map<String, Consumer<Model>> map = createAttributes(model, locale);
        for (Map.Entry<String, Consumer<Model>> key : map.entrySet()) {
//            logger.info(key.getKey());
            key.getValue().accept(model);
        }
    }

    @NotNull
    private Map<String, Consumer<Model>> createAttributes(Model model, Locale locale) {
        Map<String, Consumer<Model>> map = new HashMap<>();
        // common
        map.put("loginPage", m -> attr.setupLoginPage(model, locale));
        map.put("homepage", m -> attr.setupHomePage(model, locale));
        map.put("footer", m -> attr.setupFooter(model, locale));
        map.put("logout", m -> attr.setupLogout(model, locale));
        map.put("searchPage", m -> attr.setupSearchPage(model, locale));
        map.put("story", m -> attr.setupStory(model, locale));
        map.put("slider", m -> attr.setupSlider(model, locale));
        map.put("header", m -> attr.setupHeader(model, locale));
        map.put("register", m -> attr.setupRegisterPage(model, locale));
        map.put("forgot", m -> attr.setupForgotPage(model, locale));
        map.put("accessDenied", m -> attr.setupAccessDeniedPage(model, locale));
        map.put("page404", m -> attr.setup404ErrorPage(model, locale));

        // notification
        map.put("notification", m -> attr.setupNotificationPopup(model, locale));

        return map;
    }
}
