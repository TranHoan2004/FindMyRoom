package com.FindMyRoom.config;

public interface Constants {
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

    interface Regex {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String PHONE_REGEX = "^[0-9]{10}$";
        String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]$";
    }
}
