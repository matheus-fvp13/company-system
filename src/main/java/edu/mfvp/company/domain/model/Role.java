package edu.mfvp.company.domain.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@jakarta.persistence.Entity(name = "tb_role")
public class Role extends Entity {

    @Column(nullable = false, length = 40, unique = true)
    private String name;

}
