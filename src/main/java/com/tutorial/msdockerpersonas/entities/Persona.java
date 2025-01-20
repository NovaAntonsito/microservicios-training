package com.tutorial.msdockerpersonas.entities;

import com.tutorial.msdockerpersonas.entities.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "personas")
@Data
@NoArgsConstructor
public class Persona extends BaseEntity {

    private String nombre;
    private Long edad;
    private String direccion;
    private String telefono;


}
