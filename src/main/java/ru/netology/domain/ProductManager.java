
package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.repository.ProductRepository;

public class ProductManager {

    ProductRepository repository = new ProductRepository();

    public ProductManager(ProductRepository repository) { // Конструктор репозитория
        this.repository = repository;
    }

    public Product[] serachById(String text) {
        Product[] result = new Product[0];
        result = repository.findAll();
        int index = -1;
        for (Product product : result) {
            index++;
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, index, tmp, index+1, 1);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        boolean condition = false;
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                boolean conditionActual = true;
                condition = conditionActual;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                boolean conditionActual = true;
                condition = conditionActual;
            }

        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                boolean conditionActual = true;
                condition = conditionActual;
            }
            if (smartphone.getLabelName().equalsIgnoreCase(search)) {
                boolean conditionActual = true;
                condition = conditionActual;
            }

        }

        return condition;
    }

    public void addTo (Product item){
        repository.save(item);
    }

}
