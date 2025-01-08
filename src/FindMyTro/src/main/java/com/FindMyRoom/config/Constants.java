package com.FindMyRoom.config;

public interface Constants {
    interface MailProperties {
        String HOST_NAME = "smtp.gmail.com";
        int PORT = 465;
//        String APP_EMAIL = "myemail";
//        String APP_PASSWORD = "mypassword";
        String APP_EMAIL = "tranxuanhoan4@gmail.com";
        String APP_PASSWORD = "gmol nvte nlri ziru";
        // get app password from 2 step vertification of Google
    }

    interface QRProperties {
        String BANK_CODE = "";
        String ACCOUNT_NUMBER = "";
        String ACCOUNT_NAME = "";
    }
}
