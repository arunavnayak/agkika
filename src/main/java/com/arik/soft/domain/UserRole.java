package com.arik.soft.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column
    @Enumerated(EnumType.STRING)
    @NotEmpty
    private Roles role;

    public Long getUserRoleId() {
        return userRoleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
