package com.FindMyRoom.service.impl;

import com.FindMyRoom.repository.SliderRepository;
import com.FindMyRoom.service.SliderService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class SliderServiceImpl implements SliderService {
    private final SliderRepository repo;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public SliderServiceImpl(SliderRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<String> getAllSliders() throws Exception {
        logger.info("getAllSliders");
        List<byte[]> list = repo.getAllImages();
        if (list.isEmpty()) {
            throw new Exception("No sliders");
        }
        List<String> sliders = new ArrayList<>();
        list.forEach(b -> {
            String filePath = new String(b, StandardCharsets.UTF_8);
            logger.info(filePath);
            sliders.add(filePath);
        });
        return sliders;
    }
}
