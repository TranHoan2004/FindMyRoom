package com.FindMyRoom.config;

public interface Constants {
    interface MailProperties {
        String HOST_NAME = "smtp.gmail.com";
        int PORT = 465;
        String APP_EMAIL = "hoana5k44nknd@gmail.com";
        String APP_PASSWORD = "gmol nvte nlri ziru";
        // get app password from 2 steps verification of Google
    }

    interface QRProperties {
        String BANK_CODE = "";
        String ACCOUNT_NUMBER = "";
        String ACCOUNT_NAME = "";
    }

    interface Role {
        String ROLE_ADMIN = "ADMIN";
        String ROLE_USER = "USER";
        String ROLE_BUSINESSMAN = "BUSINESSMAN";
        String ROLE_EMPLOYEE = "EMPLOYEE";
    }
}
