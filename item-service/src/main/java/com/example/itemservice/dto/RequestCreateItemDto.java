package com.example.itemservice.dto;

import com.example.itemservice.domain.Item;
import lombok.Data;

import java.util.UUID;

@Data
public class RequestCreateItemDto {
    private String productId;
    private String productName;
    private Long stock;
    private Long pricePerItem;

    public Item toEntity(){
        return Item.builder()
                .productId(UUID.randomUUID().toString())
                .productName(this.productName)
                .stock(this.stock)
                .pricePerItem(this.pricePerItem)
                .build();
    }
}
