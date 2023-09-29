package edu.mfvp.company.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "tb_client")
@Setter
@Getter
public class Client extends Person {

    @OneToMany(mappedBy = "client")
    private List<Project> projects;

}
