package com.example.reactjscrud.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Tutorial {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "published")
    private Byte published;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getPublished() {
        return published;
    }

    public void setPublished(Byte published) {
        this.published = published;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutorial tutorial = (Tutorial) o;
        return id == tutorial.id && Double.compare(tutorial.price, price) == 0 && Objects.equals(name, tutorial.name) && Objects.equals(description, tutorial.description) && Objects.equals(published, tutorial.published);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, published);
    }
}
