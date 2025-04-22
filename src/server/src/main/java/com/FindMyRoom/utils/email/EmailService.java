package com.FindMyRoom.utils.email;

import com.FindMyRoom.config.Constants;

public interface EmailService extends Constants.MailProperties {
    void sendEmail(String to, String subject, String body);
}
