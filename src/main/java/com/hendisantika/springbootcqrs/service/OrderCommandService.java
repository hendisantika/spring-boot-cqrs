package com.hendisantika.springbootcqrs.service;

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
public interface OrderCommandService {
    void createOrder(int userIndex, int productIndex);

    void cancelOrder(long orderId);
}
