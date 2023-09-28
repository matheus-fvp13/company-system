package edu.mfvp.company.domain.model;

import edu.mfvp.company.domain.enumerations.UF;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "tb_address")
public class Address extends edu.mfvp.company.domain.model.Entity {

    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private UF uf;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String borhood;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String number;

    private String complement;

    @Override
    public String toString() {
        StringBuilder fullAddress = new  StringBuilder();
        fullAddress.append(street)
                .append(", n° " )
                .append(number)
                .append(", ")
                .append(complement)
                .append(" - ")
                .append(borhood)
                .append(". ")
                .append(uf.getDescricao())
                .append(" - ")
                .append(city)
                .append(". CEP: ")
                .append(zipCode);
        return fullAddress.toString();
    }
}
