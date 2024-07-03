package com.recomotor.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employer")
public class Employer implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Column(name = "num_employer", nullable = false, unique = true)
    private Integer numEmployer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favour_model_id")
    @JsonBackReference
    private Model favourModel;
}
