
package com.kozak_burger.KozakBurgerShop.domain.dto;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


public class ProductDto {

    private Long id;


    private String title;


    private BigDecimal price;
	
	
	private String image;
	

    private String description;


    private String category;


    private double rate;
	

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
	
	public void setImage(String image) {
        this.image = image;
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

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }
	
	public String getImage() {
        return image;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Double.compare(rate, that.rate) == 0 && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(price, that.price) && Objects.equals(image, that.image) && Objects.equals(description, that.description) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, image, description, category, rate);
    }

    public String toString() {
        return String.format("Product DTO: id - %d, title - %s, price - %s, image - %s, description -%s, category - %s, rate -%d", id, title, price, image, description, category, rate);
    }
}
