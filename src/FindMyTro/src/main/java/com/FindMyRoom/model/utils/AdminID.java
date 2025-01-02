package com.FindMyRoom.model.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AdminID {
    @Column(name = "admin_id")
    private long adminID;
}
