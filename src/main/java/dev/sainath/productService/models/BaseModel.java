package dev.sainath.productService.models;


import jakarta.persistence.*;

import java.util.UUID;


@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


}
