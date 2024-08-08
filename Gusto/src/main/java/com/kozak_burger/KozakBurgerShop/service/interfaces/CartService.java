package com.kozak_burger.KozakBurgerShop.service.interfaces;

import com.kozak_burger.KozakBurgerShop.domain.dto.CartDto;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {


    CartDto save(CartDto cart);


    List<CartDto> getAllCarts();


    CartDto getById(Long id);


    CartDto update(CartDto cart);


    void deleteById(Long id);


    void restoreById(Long id);


    long getActiveProductsQuantity();

    /**
     * Отримує загальну ціну продуктів в активних кошиках.
     *
     * @return Загальна ціна продуктів.
     */
    BigDecimal getActiveProductsTotalPrice();

    /**
     * Отримує середню ціну продуктів в активних кошиках.
     *
     * @return Середня ціна продуктів.
     */
    BigDecimal getActiveProductsAveragePrice();
}
