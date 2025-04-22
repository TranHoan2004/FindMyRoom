package com.FindMyRoom.model;

import com.FindMyRoom.model.utils.AdminID;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Admin")
public class Admin {
    @EmbeddedId
    private AdminID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("adminID")
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Users user;

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Employee> employees;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "admin")
    private Set<Services> services;
}
