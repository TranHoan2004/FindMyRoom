package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.SessionController;
import com.FindMyRoom.controller.utils.SetupGlobalAttributes;
import com.FindMyRoom.dto.UserDTO;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class GlobalAttributesController {
    private final SetupGlobalAttributes attr;
    private final SessionController sc;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public GlobalAttributesController(SetupGlobalAttributes attr, SessionController session) {
        this.attr = attr;
        this.sc = session;
    }

    private void throwSessionData(HttpSession session) {
        try {
            UserDTO user = sc.getEntityFromSession(session);
            session.setAttribute("account", user);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @ModelAttribute
    public void addAttributes(Model model, Locale locale, HttpSession session) {
        logger.info("Setup global attributes");
        throwSessionData(session);
        Map<String, Consumer<Model>> map = createAttributes(model, locale);
        for (Map.Entry<String, Consumer<Model>> key : map.entrySet()) {
            key.getValue().accept(model);
        }
    }

    @NotNull
    private Map<String, Consumer<Model>> createAttributes(Model model, Locale locale) {
        Map<String, Consumer<Model>> map = new HashMap<>();
        map.put("loginPage", m -> attr.setupLoginPage(model, locale));

        return map;
    }
}
