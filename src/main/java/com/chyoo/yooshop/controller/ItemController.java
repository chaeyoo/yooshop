package com.chyoo.yooshop.controller;

import com.chyoo.yooshop.entity.Item;
import com.chyoo.yooshop.repository.ItemRepository;
import com.chyoo.yooshop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> itemList = itemService.getAllItems();
        return ResponseEntity.status(HttpStatus.OK).body(itemList);
    }
}
