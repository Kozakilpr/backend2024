package com.kozak_burger.KozakBurgerShop.domain.dto;

import com.kozak_burger.KozakBurgerShop.domain.dto.CartDto;

import java.util.Objects;

public class CustomerDto {
	
	
    private Long id;
    private String name;
    private String surname;
    private String street;
    private String city;
    private String postalAddress;
	private String email;
    private String phoneNumber;
	private CartDto cart;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(postalAddress, that.postalAddress) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, street, city, postalAddress, email, phoneNumber, cart);
    }

    @Override
    public String toString() {
        return String.format("Customer DTO: id - %d, name - %s, surname - %s, " +
                "email - %s, street - %s, city - %s, postalAddress - %s", id, name, surname, email, street, city, postalAddress);
    }

}
