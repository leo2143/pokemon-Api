package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "type_form_learn")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeFormLearnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_form_learn_id")
    private Long id;

    @Column(name = "type_learn")
    private String typeLearn;

    @OneToMany(mappedBy = "typeLearnForm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FormLearnEntity> formLearn;

}
