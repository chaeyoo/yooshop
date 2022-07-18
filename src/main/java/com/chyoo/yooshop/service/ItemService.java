package com.chyoo.yooshop.service;

import com.chyoo.yooshop.entity.Item;
import com.chyoo.yooshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ItemService {


    private final ItemRepository itemRepository ;

    public List<Item> getAllItems() {
        List<Item> itemList = itemRepository.findAll();
        return itemList;
    }

    public Optional<Item> getItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item;

    }
}
