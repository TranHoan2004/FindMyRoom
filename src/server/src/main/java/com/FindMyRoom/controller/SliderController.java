package com.FindMyRoom.controller;

import com.FindMyRoom.service.SliderService;
import com.FindMyRoom.service.impl.SliderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/slider")
public class SliderController {
    private final SliderService ss;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public SliderController(SliderServiceImpl ss) {
        this.ss = ss;
    }

    @GetMapping("/list")
    public ResponseEntity<?> renderSlider(HttpServletRequest request) {
        logger.info(request.getHeader("X-Requested-By"));
        if (isForbiddenContent(request, "Slider")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied");
        }

        try {
            List<String> images = ss.getAllSliders();
            return ResponseEntity.ok(images);
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    private boolean isForbiddenContent(@NotNull HttpServletRequest request, String key) {
        String requestedBy = request.getHeader("X-Requested-By");
        return requestedBy == null || !requestedBy.equals(key);
    }
}
