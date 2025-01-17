package com.tutorial.msdockerpersonas.entities;

import com.tutorial.msdockerpersonas.entities.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "personas")
@Data
@NoArgsConstructor
public class Persona extends BaseEntity {

    private String nombre;
    private Long edad;


}
