package com.example.application_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personne")
public class Personne {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "name")
    private String name;
    @Column(name = "job")
    private String job;
    @Column(name = "image_url")
    private String imageUrl;

    public Personne() {
    }

    public Personne(Long id, String name, String job, String imageUrl) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}