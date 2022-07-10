package com.overone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);

        ProductSuggestion productSuggestion = ctx.getBean(ProductSuggestion.class);
        productSuggestion.findProductsForUser(2);

    }
}
