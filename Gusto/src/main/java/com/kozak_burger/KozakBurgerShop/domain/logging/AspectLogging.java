package com.kozak_burger.KozakBurgerShop.domain.logging;


import io.jsonwebtoken.lang.Objects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {

    private Logger logger = LoggerFactory.getLogger(AspectLogging.class);

    //Пойнткат/срез правило, куда будет внедрена доп логика

    @Pointcut("execution(* com.kozak_burger.KozakBurgerShop.service.ProductServiceImpl.save(..))")
    public void saveProduct() {}

//    @Before("saveProduct()")
//    public void before() {
//        logger.info("Method save called in ProductServiceImpl");
//    }

    // получаем все об. посредством JoinPoint joinPoint


    @Before("saveProduct()")
    public void before(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        logger.info("Method save called in ProductServiceImpl with parameter {}", params[0]);
    }

    @After("saveProduct()")
    public void after() {
        logger.info("Method save called in ProductServiceImpl finished its work");
    }

    @Pointcut("execution(* com.kozak_burger.KozakBurgerShop.service.ProductServiceImpl.getById(..))")
    public void getById() {}


    @AfterReturning("getById()")
    public void afterReturning() {
        logger.info("Method getById called in ProductServiceImpl returned result");
    }

    @AfterThrowing("getById()")
    public void afterThrowing() {
        logger.info("Method getById called in ProductServiceImpl threw an exception");
    }


}
