package com.chyoo.yooshop.repository;

import com.chyoo.yooshop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor {

    List<Item> findByItemNm(String itemNm);

    List<Item> findByItemNmOrItemDtl(String itemNm, String itemDtl);

    List<Item> findByPriceLessThan(Integer price);

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    @Query("select i from Item i where i.itemDtl like %:itemDtl% order by i.price desc")
    List<Item> findByItemDtl(@Param("itemDtl") String itemDtl);

    @Query(value = "select * from item i where i.item_dtl like %:itemDtl% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDtlByNative(@Param("itemDtl") String itemDtl);
}
