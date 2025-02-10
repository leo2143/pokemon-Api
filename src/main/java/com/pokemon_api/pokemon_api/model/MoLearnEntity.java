package com.pokemon_api.pokemon_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mo_learn")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class MoLearnEntity extends FormLearnEntity {

    private String mo;

    @PrePersist
    public void prePersist() {
        setFormLearn("MO");
    }
}
