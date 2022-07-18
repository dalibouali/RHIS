package com.example.rhisdemo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String type_profile;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private List<Affectation> affectationList;
}