package com.example.thymeleaf.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Entity
@NoArgsConstructor
@Table(name = "address")
@EqualsAndHashCode(of = {"id"})
public class Address {

    @Id
    @Getter
    private String id;

    @Getter
    @Column(name = "zip_code")
    private String zipCode;

    @Getter
    private String street;
    @Getter
    private String number;
    @Getter
    private String complement;
    @Getter
    private String district;
    @Getter
    private String city;
    @Getter
    private String state;

    @Getter
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Getter
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "fk_student")
    private Student student;

    public Address(Address other) {
        id = other.id;
        zipCode = other.zipCode;
        street = other.street;
        number = other.number;
        complement = other.complement;
        district = other.district;
        city = other.city;
        state = other.state;
        createdAt = other.createdAt;
        updatedAt = other.updatedAt;
    }

    public Student getStudent() {
        return new Student(student);
    }

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}