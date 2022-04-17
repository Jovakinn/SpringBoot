package com.example.springbootrest.cinema.model;

import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CatalogItem {
    private String name;
    private String description;
    private Integer rating;
}
