package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
ProductManager manager = new ProductManager(new ProductRepository());
ProductRepository repo = new ProductRepository();

@BeforeEach
private void setUP(){
    Product item1 = new Book(1,"Game of Thrones",50,"G.R.R Marting",999,2012);
    Product item2 = new Smartphone(2,"Galaxy 20+",100,"Samsung");
    manager.addTo(item1);
    manager.addTo(item2);
}

    @Test
    void serachById() {
    Product item2 = new Smartphone(2,"Galaxy 20+",100,"Samsung");

    Product[] expected = new Product[]{item2};
    Product[] actualItem = manager.serachById("Galaxy 20+");


        Assertions.assertArrayEquals(expected,actualItem);

    }
}