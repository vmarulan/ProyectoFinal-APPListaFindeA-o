package com.udea.Oct3.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String email;
    @Column
    private String image;
    @Column(unique = true)
    private String authOId;
    @Column
    private String rol; // Nuevo atributo para el rol

    public User() {
    }

    public User(String email, String image, String authOId, String rol) {
        this.email = email;
        this.image = image;
        this.authOId = authOId;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthOId() {
        return authOId;
    }

    public void setAuthOId(String authOId) {
        this.authOId = authOId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
