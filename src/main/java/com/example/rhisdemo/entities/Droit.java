package com.example.rhisdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Droit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
   // @JsonIgnore
    private Role roleD;

    @ManyToOne(fetch = FetchType.EAGER)
  //  @JsonIgnore
    private  Ecran ecran ;

    private Integer cum;

}
