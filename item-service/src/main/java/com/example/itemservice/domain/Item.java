package com.example.itemservice.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="items")
@Getter @NoArgsConstructor @Builder
@AllArgsConstructor @ToString
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;
    private String productName;
    private Long stock;
    private Long pricePerItem;
}
