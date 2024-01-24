package com.stduy.membermange.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class springboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content" , nullable = false)
    private String content;
}
