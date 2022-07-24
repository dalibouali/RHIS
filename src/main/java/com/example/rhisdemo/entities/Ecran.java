package com.example.rhisdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ecran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "ecran",cascade = CascadeType.ALL)
    private List<Droit> DroitList=new ArrayList<Droit>();
}
