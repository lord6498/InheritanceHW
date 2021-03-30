
package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import java.util.ArrayList;

public class ProductManager {

    ProductRepository repository = new ProductRepository();

    public ProductManager(ProductRepository repository) { // Конструктор репозитория
        this.repository = repository;
    }

    public Product[] searchById(String text) {
        Product[] currentArray = new Product[0];
        currentArray = repository.findAll();
        Product[] resultReturn = new Product[currentArray.length];
        ArrayList<Product> resultNew = new ArrayList<>();
        for (Product product : currentArray) {
            if (matches(product, text)) {

                resultNew.add(product);
                resultReturn = resultNew.toArray(new Product[0]);
            }
        }
        return resultReturn;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }

        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;

            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getLabelName().equalsIgnoreCase(search)) {
                return true;
            }

        }

        return false;
    }

    public void addTo(Product item) {
        repository.save(item);
    }

}