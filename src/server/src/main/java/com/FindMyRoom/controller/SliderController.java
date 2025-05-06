package com.FindMyRoom.controller;

import com.FindMyRoom.dto.response.ApiResponse;
import com.FindMyRoom.service.SliderService;
import com.FindMyRoom.service.impl.SliderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/slider")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SliderController {
    SliderService ss;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public SliderController(SliderServiceImpl ss) {
        this.ss = ss;
    }

    @GetMapping("/list")
    public ResponseEntity<?> renderSlider(HttpServletRequest request) {
        logger.info(request.getHeader("X-Requested-By"));
        if (isForbiddenContent(request, "Slider")) {
            throw new AccessDeniedException("Access denied");
        }
        try {
            List<String> images = ss.getAllSliders();
            ApiResponse<List<String>> response = new ApiResponse<>(
                    HttpStatus.OK.value(),
                    null,
                    images);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            throw e;
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(
                HttpStatus.NOT_FOUND.value(),
                "There is no slider",
                null
        ));
    }

    private boolean isForbiddenContent(@NotNull HttpServletRequest request, String key) {
        String requestedBy = request.getHeader("X-Requested-By");
        return requestedBy == null || !requestedBy.equals(key);
    }
}
