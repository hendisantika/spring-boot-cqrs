package com.hendisantika.springbootcqrs.service;

import com.hendisantika.springbootcqrs.entity.Product;
import com.hendisantika.springbootcqrs.entity.PurchaseOrder;
import com.hendisantika.springbootcqrs.entity.User;
import com.hendisantika.springbootcqrs.repository.ProductRepository;
import com.hendisantika.springbootcqrs.repository.PurchaseOrderRepository;
import com.hendisantika.springbootcqrs.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-cqrs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/7/23
 * Time: 10:35
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class OrderCommandService {
    private static final long ORDER_CANCELLATION_WINDOW = 30;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final PurchaseOrderRepository purchaseOrderRepository;

    private List<User> users;
    private List<Product> products;

    @PostConstruct
    private void init() {
        this.users = this.userRepository.findAll();
        this.products = this.productRepository.findAll();
    }

    public void createOrder(int userIndex, int productIndex) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setProductId(this.products.get(productIndex).getId());
        purchaseOrder.setUserId(this.users.get(userIndex).getId());
        this.purchaseOrderRepository.save(purchaseOrder);
    }
}
