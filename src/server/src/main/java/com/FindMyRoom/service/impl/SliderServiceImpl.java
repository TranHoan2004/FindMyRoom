package com.FindMyRoom.service.impl;

import com.FindMyRoom.repository.SliderRepository;
import com.FindMyRoom.service.SliderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SliderServiceImpl implements SliderService {
    SliderRepository repo;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public SliderServiceImpl(SliderRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<String> getAllSliders() {
        logger.info("getAllSliders");
        List<byte[]> list = repo.getAllImages();
        if (list.isEmpty()) {
            throw new EntityNotFoundException("No sliders");
        }
        List<String> sliders = new ArrayList<>();
        list.forEach(b -> {
            String filePath = new String(b, StandardCharsets.UTF_8);
            sliders.add(filePath);
        });
        return sliders;
    }
}
