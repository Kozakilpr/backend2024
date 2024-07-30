
package com.kozak_burger.KozakBurgerShop.domain.entity;
import jakarta.persistence.*;
import java.util.Objects;



//@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private int phonenumber;

    @Column(name = "active")
    private boolean active;

    private Cart cart;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public boolean isActive() {
        return active;
    }

    public Cart getCart() {
        return cart;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return phonenumber == customer.phonenumber && active == customer.active && Objects.equals(id, customer.id) && Objects.equals(email, customer.email) && Objects.equals(cart, customer.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phonenumber, active, cart);
    }

    @Override
    public String toString() {
        return String.format("Customer: id - %d, email - %s, phonenumber - %d, active - %s, cart - %s", id, email, phonenumber, active ? "yes" : "no", cart == null ? "ERROR! Cart is missing" : cart);
    }

}
