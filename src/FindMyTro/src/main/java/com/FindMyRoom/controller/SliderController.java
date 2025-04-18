package com.FindMyRoom.controller;

import com.FindMyRoom.service.SliderService;
import com.FindMyRoom.service.impl.SliderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/slider")
public class SliderController {
    private final SliderService ss;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public SliderController(SliderServiceImpl ss) {
        this.ss = ss;
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> renderSlider() {
        try {
            List<String> images = ss.getAllSliders();
            return ResponseEntity.ok(images);
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }
}
