package com.example.rhisdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Affectation {
    @Id
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;



}
