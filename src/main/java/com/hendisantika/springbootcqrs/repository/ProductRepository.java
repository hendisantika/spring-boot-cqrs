package com.hendisantika.springbootcqrs.repository;

import com.hendisantika.springbootcqrs.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-cqrs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/7/23
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
