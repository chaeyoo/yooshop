package com.chyoo.yooshop.service;

import com.chyoo.yooshop.constant.ItemSellStatus;
import com.chyoo.yooshop.entity.Item;
import com.chyoo.yooshop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void getAllItemsTest() {

        //given
        this.createItemList();

        //when
        List<Item> findItems = itemService.getAllItems();

        //then
        assertNotNull(findItems);
        assertEquals(10, findItems.size());


    }

    @Test
    public void getItem() {
        //given
        this.createItemList();

        //when
        Optional<Item> findItem = itemService.getItem(5L);

        //then
        assertNotNull(findItem);
        assertEquals(findItem.get().getItemNm(), "테스트 상품5");
    }
    public void createItemList() {
        for (int i=1; i<=10; i++) {
            Item item = new Item();
            item.setItemNm("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDtl("테스트 상품 상세 설명" + i);
            item.setItemSellStat(ItemSellStatus.SELL);
            item.setStockNum(100);
            item.setCreatedAt(LocalDateTime.now());
            item.setUpdatedAt(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
        }
    }
}