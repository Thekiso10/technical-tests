package com.mca.infrastructure.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VIDEOGAME")
public class VideoGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "videoGame", cascade = CascadeType.ALL)
    private List<Promotion> promotions;

    @OneToOne(mappedBy = "videoGame", cascade = CascadeType.ALL)
    private Stock stock;
}
