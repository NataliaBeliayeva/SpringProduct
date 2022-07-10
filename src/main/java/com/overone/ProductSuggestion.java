package com.overone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSuggestion {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductDao productDao;

    public void findProductsForUser(int userId){
        Double userMoney = userDao.findUserMoneyById(userId);
        List<Product> products = productDao.findAllProductByMoney(userMoney);
        System.out.println("Доступные продукты для человека с id = " + userId);
        System.out.println(products);

    }
}
