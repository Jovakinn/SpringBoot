package com.example.springbootrest.cinema.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Movie {
    private String movieId;
    private Integer rating;
}
