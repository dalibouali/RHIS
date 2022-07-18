package com.example.rhisdemo.Dto;

import com.example.rhisdemo.entities.Affectation;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class UserRequest {

    private String firstName;

    private String lastName;

    private String username;

    private List<Affectation> affectationList;

}
