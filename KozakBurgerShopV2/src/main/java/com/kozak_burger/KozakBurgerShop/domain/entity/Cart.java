
package com.kozak_burger.KozakBurgerShop.domain.entity;

import com.kozak_burger.KozakBurgerShop.domain.entity.Customer;
import com.kozak_burger.KozakBurgerShop.domain.entity.Product;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;


@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


	@JsonIgnore
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    //@JdbcTypeCode(SqlTypes.JSON)
	
	@ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
	
	 public void addProduct(Product product) {
        if (product.isActive()) {
            products.add(product);
        }
    }
	
	public List<Product> getActiveProducts() {
        return products
                .stream()
                .filter(Product::isActive)
                .toList();
    }



	 public void removeProductById(Long id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }
	
	
    public void clear() {
        products.clear();
    }
	
	 public BigDecimal getActiveProductsTotalCost() {
        return products
                .stream()
                .filter(Product::isActive)
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal(0));
    }

    public BigDecimal getActiveProductsAverageCost() {
        long activeProductsCount = products.stream()
                .filter(Product::isActive)
                .count();

        return activeProductsCount == 0 ?
                new BigDecimal(0) :
                getActiveProductsTotalCost().divide(new BigDecimal(activeProductsCount), RoundingMode.CEILING);
    }
	
	
    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) && Objects.equals(customer, cart.customer) && Objects.equals(products, cart.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, products);
    }

    @Override
    public String toString() {
        return String.format("Cart: id=%d,  contains %d products", id, products == null ? 0 : products.size());
    }
}
