package com.FindMyRoom.model.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AdminID implements Serializable {
    @Column(name = "admin_id")
    private long adminID;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AdminID adminID1 = (AdminID) o;
        return adminID == adminID1.adminID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(adminID);
    }
}
