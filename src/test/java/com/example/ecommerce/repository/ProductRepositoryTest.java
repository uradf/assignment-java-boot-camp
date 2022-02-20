package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.CartService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


@DataJpaTest
public class ProductRepositoryTest {

    final int SIZE = 5;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    CartService cartService;

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
        int tankPrice = 1000000;

        // Act
        Page<Product> result = productRepository.findByName(name, paging);

        // Assert
        String itemName = result.toList().get(0).getName();
        int itemPrice = result.toList().get(0).getPrice();
        assertEquals(itemName, name);
        assertEquals(itemPrice, tankPrice);

    }

    @Test
    @DisplayName("User ทำการหยิบสินค้าชิ้นนี้ใส่ตะกร้า แต่ระบบบังคับให้เข้าสู่ระบบ")
    public void test05() {
        // Arrange
        String token = "";
        int itemid = 14;
        String RESULT = "ERROR";
        cartService = new CartService();

        // Act
        String result = cartService.addItemToCart(token, itemid);

        // Assert
        assertEquals(RESULT, result);
    }

    @Test
    @DisplayName("(User ทำการเข้าระบบ)")
    public void test06() {
        // Arrange
        String userid = "prayut";
        String password = "8b8e9715d12e4ca12c4c3eb4865aaf6a";
        String VALID_TOKEN = "VALID_TOKEN_STRING";
        String RESULT = userid + "." + VALID_TOKEN;

        // Act
        Optional<User> user = userRepository.findByUseridAndPassword(userid, password);

        String result = user.get().getUserId() + "." + VALID_TOKEN;
        // Assert
        assertEquals(RESULT, result);
    }

    @Test
    @DisplayName("User ทำการหยิบสินค้าชิ้นนี้ใส่ตะกร้า")
    public void test07() {
        // Arrange
        String userid = "prayut";
        String VALID_TOKEN = "VALID_TOKEN_STRING";
        String token = userid + "." + VALID_TOKEN;
        int itemid = 14;
        String RESULT = "COMPLETED";
        cartService = new CartService();
        cartService.setCartRepository(this.cartRepository);

        // Act
        String result = cartService.addItemToCart(token, itemid);
        // Assert
        assertEquals(RESULT, result);
    }



}
