package com.example.paintings.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "artists")
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String style;

    @Column(length=100)
    private String nationality;

    @Column
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;


}
