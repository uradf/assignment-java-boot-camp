package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@DataJpaTest
public class ProductRepositoryTest {

    final int SIZE = 5;

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("User กดเรียกดูสินค้า โดยระบบจะแสดงสินค้าหน้าละ 5 ชิ้น")
    public void test01() {

        // Arrange
        Pageable paging = PageRequest.of(0, SIZE);

        // Act
        Page<Product> result = productRepository.findAll(paging);

        // Assert
        long count = result.get().count();
        assert(count > 0);
    }

    @Test
    @DisplayName("User กดดูสินค้าหน้าที่ 2")
    public void test02() {

        // Arrange
        Pageable paging = PageRequest.of(1, SIZE);

        // Act
        Page<Product> result = productRepository.findAll(paging);

        // Assert
        long count = result.get().count();
        assert(count > 0);
    }

    @Test
    @DisplayName("User ไม่เจอสินค้าที่ต้องการ เลยทำการค้นหาสินค้าจากชื่อ โดยใส่คำว่า Tank")
    public void test03() {

        // Arrange
        Pageable paging = PageRequest.of(0, SIZE);
        String name = "Tank";

        // Act
        Page<Product> result = productRepository.findByName(name, paging);

        // Assert
        long count = result.get().count();
        assert(count > 0);
    }

    @Test
    @DisplayName("System แสดงสินค้าที่ชื่อว่า Tank (ชื่อ และ ราคา)")
    public void test04() {

        // Arrange
        Pageable paging = PageRequest.of(0, SIZE);
        String name = "Tank";
        int tankPrice = 30000000;

        // Act
        Page<Product> result = productRepository.findByName(name, paging);

        // Assert
        String itemName = result.toList().get(0).getName();
        int itemPrice = result.toList().get(0).getPrice();
        assertEquals(itemName, name);
        assertEquals(itemPrice, tankPrice);

    }
}
