package com.hendisantika.springbootcqrs.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-cqrs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/7/23
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class MaterializedViewRefresher {

    private final EntityManager entityManager;

    @Transactional
    @Scheduled(fixedRate = 5000L)
    public void refresh() {
        this.entityManager.createNativeQuery("call refresh_mat_view();").executeUpdate();
    }
}
