package com.example.itemservice.controller;

import com.example.itemservice.domain.Item;
import com.example.itemservice.dto.RequestCreateItemDto;
import com.example.itemservice.dto.ResponseBuyItemDto;
import com.example.itemservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("item-service")
@RequiredArgsConstructor
public class ItemController {
    @Autowired
    private final ItemService itemService;

    @RequestMapping("health-check")
    public String healthCheck(){
        return "server is available!";
    }

    @PostMapping("create-item")
    public ResponseEntity<?> createItem(@RequestBody RequestCreateItemDto dto){
        itemService.createItem(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("item/{uuid}")
    public ResponseEntity<?> findItem(@PathVariable String uuid){
        ResponseBuyItemDto dto = new ResponseBuyItemDto(itemService.findItem(uuid));
        return ResponseEntity.ok(dto.toString());
    }
    @GetMapping("item/findAll")
    public ResponseEntity<?> findAllItems(){

        return ResponseEntity.ok(itemService.findAll());
    }
}
