//
//package com.kozak_burger.KozakBurgerShop.domain.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
//
//import java.math.BigDecimal;
//import java.util.Objects;
//
//@Entity
//@Table(name = "product")
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @NotNull(message = "Die Bezeichnung kann nicht leer sein!")
//    @NotBlank(message = "Bitte geben Sie dem Produkt einen Namen!")
//    @Pattern(
//            regexp = "[A-Z][a-z ]{2,}",
//            message = "Bezeichnung von Produkt, sollte nicht kürzer als 3 Zeichen sein! " + " Die Bezeichnung soll mit Großbuchstaben beginnen!"
//    )
//    @Column(name = "title")
//    private String title;
//
//    @DecimalMin(value = "0.25", message = "Der Preis darf nicht weniger als 25 Cent betragen")
//    @DecimalMax(value = "200.00", message = "Der Preis für ein Produkt, darf nicht mehr als 200 Euro sein")
//    @Column(name = "price")
//    private BigDecimal price;
//
//    @Column(name = "image")
//    private String image;
//
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "category")
//    private String category;
//
//	@Pattern(
//            regexp = "[1-10]{1,1}",
//            message = "Bezeichnung soll nur eine Zahl von 1 bis 5 sein!")
//    @Column(name = "rate")
//    private double rate;
//
//    @Column(name = "active")
//    private boolean active;
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public void setRate(double rate) {
//        this.rate = rate;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public double getRate() {
//        return rate;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Product product = (Product) o;
//        return active == product.active && Double.compare(rate, product.rate) == 0 && Objects.equals(id, product.id) && Objects.equals(title, product.title) && Objects.equals(price, product.price) && Objects.equals(description, product.description) && Objects.equals(category, product.category) && Objects.equals(image, product.image);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, title, price, active, description, category, rate, image);
//    }
//
//    @Override
//    public String toString() {
//        return String.format("Product: id - %d, title - %s, price - %s, image - %s, description -%s, category - %s, rate -%d, active - %s", id, title, price, image, description, category, rate, active ? "yes" : "no");
//    }
//
//
//
//}



//Мій робочий код




package com.kozak_burger.KozakBurgerShop.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Die Bezeichnung kann nicht leer sein!")
    @NotBlank(message = "Bitte geben Sie dem Produkt einen Namen!")
    @Pattern(
            regexp = "[A-Z][a-zA-Z ]{2,}",  //  Добавил большую букву
            message = "Bezeichnung von Produkt, sollte nicht kürzer als 3 Zeichen sein! " + " Die Bezeichnung soll mit Großbuchstaben beginnen!"
    )
    @Column(name = "title")
    private String title;

    @DecimalMin(value = "0.25", message = "Der Preis darf nicht weniger als 25 Cent betragen")
    @DecimalMax(value = "200.00", message = "Der Preis für ein Produkt, darf nicht mehr als 200 Euro sein")
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Min(value = 1, message = "Rate must be at least 1")
    @Max(value = 10, message = "Rate must be at most 10")
    @Column(name = "rate")
    private double rate;

    @Column(name = "active")
    private boolean active;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public double getRate() {
        return rate;
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return active == product.active && Double.compare(product.rate, rate) == 0 && Objects.equals(id, product.id) && Objects.equals(title, product.title) && Objects.equals(price, product.price) && Objects.equals(description, product.description) && Objects.equals(category, product.category) && Objects.equals(image, product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, active, description, category, rate, image);
    }

    @Override
    public String toString() {
        return String.format("Product: id - %d, title - %s, price - %s, image - %s, description -%s, category - %s, rate -%.1f, active - %s", id, title, price, image, description, category, rate, active ? "yes" : "no");
    }
}


