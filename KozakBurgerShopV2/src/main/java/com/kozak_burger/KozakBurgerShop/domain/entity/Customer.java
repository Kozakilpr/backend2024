
package com.kozak_burger.KozakBurgerShop.domain.entity;
import jakarta.persistence.*;
import java.util.Objects;



//@Entity
@Table(name = "customer")
public class Customer {

    //Нужно решить что и куда переложить

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

    @Column(name = "postalAddress")
    private String postalAddress;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private int phoneNumber;

    @Column(name = "active")
    private boolean active;

    private Cart cart;

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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return phoneNumber == customer.phoneNumber && active == customer.active && Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(street, customer.street) && Objects.equals(city, customer.city) && Objects.equals(postalAddress, customer.postalAddress) && Objects.equals(email, customer.email) && Objects.equals(cart, customer.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, street, city, postalAddress, email, phoneNumber, active, cart);
    }

    @Override
    public String toString() {
        return String.format("Customer: id - %d, name -%s, surname -%s, street -%s, city -%s, postalAddress -%s, email - %s, phoneNumber - %d, active - %s, cart - %s", id, name, surname, street, city, postalAddress, email, phoneNumber, active ? "yes" : "no", cart == null ? "ERROR! Cart is missing" : cart);
    }

}
