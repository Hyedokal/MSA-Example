package com.example.itemservice.dto;

import com.example.itemservice.domain.Item;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString
public class ResponseBuyItemDto {
    private String productId;
    private String productName;
    Long stock;
    Long pricePerItem;
    public String userId;
    public String orderId;

//    public Item toEntity(){
//
//    }
    public ResponseBuyItemDto(Item item){
        this.productId = item.getProductId();
        this.productName = item.getProductName();
        this.stock = item.getStock();
        this.pricePerItem = item.getPricePerItem();
    }
}
