package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Smartphone extends Product {
    String labelName;

    public Smartphone(int id, String name, int price, String labelName) { //конструктор
        super(id, name, price);
        this.labelName = labelName;
    }

    @Override
    public String toString() {
        return "name= " + labelName + " brand= " + getName();

    }
}

