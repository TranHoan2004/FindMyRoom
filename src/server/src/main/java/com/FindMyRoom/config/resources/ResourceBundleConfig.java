package com.FindMyRoom.config.resources;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.logging.Logger;

@Configuration
public class ResourceBundleConfig {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("lang.Messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(0); // Tắt cache để reload nhanh
        messageSource.setFallbackToSystemLocale(false);
        logger.info(messageSource.toString());
        return messageSource;
    }
}
