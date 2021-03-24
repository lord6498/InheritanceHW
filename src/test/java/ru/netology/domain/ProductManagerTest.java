package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
ProductManager manager = new ProductManager(new ProductRepository());
ProductRepository repo = new ProductRepository();

    Product item1 = new Book(1,"Game of Thrones",50,"G.R.R Marting",999,2012);
    Product item2 = new Smartphone(2,"Galaxy 20+",100,"Samsung");
    Product item3 = new Smartphone(3,"Galaxy 20+",100,"Samsung (China)");
    Product item4 = new Book(1,"Witcher",50,"Poland",999,2012);

@BeforeEach
private void setUP(){
    manager.addTo(item1);
    manager.addTo(item2);
    manager.addTo(item3);
    manager.addTo(item4);
}

    @Test
    void smartphoneSearchByName() {


    Product[] expected = new Product[]{item2,item3,null,null};
    Product[] actualItem = manager.serachById("Galaxy 20+");


        Assertions.assertArrayEquals(expected,actualItem);

    }

    @Test
    void smartphoneSearchByLabelName() {

        Product[] expected = new Product[]{item2,null,null,null};
        Product[] actualItem = manager.serachById("Samsung");


        Assertions.assertArrayEquals(expected,actualItem);

    }

    @Test
    void bookSearchByName() {

        Product[] expected = new Product[]{item4,null,null,null};
        Product[] actualItem = manager.serachById("Witcher");


        Assertions.assertArrayEquals(expected,actualItem);

    }

    @Test
    void bookSearchByAuthor() {

        Product[] expected = new Product[]{item1,null,null,null};
        Product[] actualItem = manager.serachById("G.R.R Marting");


        Assertions.assertArrayEquals(expected,actualItem);

    }
}