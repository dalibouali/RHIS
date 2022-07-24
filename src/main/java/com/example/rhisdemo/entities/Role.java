package com.example.rhisdemo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id ;

    @Column(length  =20)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private List<Affectation> affectationList=new ArrayList<Affectation>();

    @JsonIgnore
    @OneToMany(mappedBy = "roleD",cascade = CascadeType.ALL)
    private List<Droit> droitListR=new ArrayList<Droit>();
}