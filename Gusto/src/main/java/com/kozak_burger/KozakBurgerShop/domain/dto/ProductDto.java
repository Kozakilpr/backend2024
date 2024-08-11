
package com.kozak_burger.KozakBurgerShop.domain.dto;

import java.math.BigDecimal;
import java.util.Objects;


public class ProductDto {

    private Long id;


    private String name;


    private BigDecimal price;
	
	
	private String image;
	

    private String description;


    private String category;


    private int rate;
	

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public int getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return rate == that.rate && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(image, that.image) && Objects.equals(description, that.description) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, image, description, category, rate);
    }

    public String toString() {
        return String.format("Product DTO: id - %d, name - %s, price - %s, image - %s, description -%s, category - %s, rate -%d", id, name, price, image, description, category, rate);
    }
}
