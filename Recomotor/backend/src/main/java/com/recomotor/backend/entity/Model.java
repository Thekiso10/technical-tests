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
@Table(name = "model")
public class Model implements Serializable{

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Brand brand;

    private String name;

    @Column(name = "img_url")
    private String imgUrl;
}
