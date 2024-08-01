
package com.kozak_burger.KozakBurgerShop.domain.entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;



//@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "postal address")
    private String postalAddress;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private int phonenumber;

    @Column(name = "title")
    private String title;

    @Column(name = "bill")
    private BigDecimal bill;

    @Column(name = "category")
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getBill() {
        return bill;
    }

    public void setBill(BigDecimal bill) {
        this.bill = bill;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return phonenumber == order.phonenumber && Objects.equals(id, order.id) && Objects.equals(name, order.name) && Objects.equals(surname, order.surname) && Objects.equals(street, order.street) && Objects.equals(city, order.city) && Objects.equals(postalAddress, order.postalAddress) && Objects.equals(email, order.email) && Objects.equals(title, order.title) && Objects.equals(bill, order.bill) && Objects.equals(category, order.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, street, city, postalAddress, email, phonenumber, title, bill, category);
    }

    @Override
    public String toString() {
        return String.format("Customer: id - %d, name -%s, surname -%s, street -%s, city -%s, postal address -%s, email - %s, phonenumber - %d, title - %s, bill -%s, category -%s", id, name,surname, street, city, postalAddress,email, phonenumber, title, bill, category);
    }

}
