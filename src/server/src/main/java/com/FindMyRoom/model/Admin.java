package com.FindMyRoom.model;

import com.FindMyRoom.model.utils.AdminID;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Admin")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admin {
    @EmbeddedId
    AdminID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("adminID")
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    Users user;

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Employee> employees;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "admin")
    Set<Services> services;
}