package com.kozak_burger.KozakBurgerShop;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryption {

    public static void main(String[] args) {

    // шифровка пароля пользователя
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "admin";
        String encodedPassword = encoder.encode(password);
        System.out.println(encodedPassword);
    }
}
