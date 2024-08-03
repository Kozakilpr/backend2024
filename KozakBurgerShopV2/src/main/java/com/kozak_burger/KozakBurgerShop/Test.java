package com.kozak_burger.KozakBurgerShop;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {

    // шифровка пароля пользователя
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "password";
        String encodedPassword = encoder.encode(password);
        System.out.println(encodedPassword);
    }
}
