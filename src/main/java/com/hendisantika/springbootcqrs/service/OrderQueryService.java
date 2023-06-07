package com.hendisantika.springbootcqrs.service;

import com.hendisantika.springbootcqrs.repository.PurchaseOrderSummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-cqrs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/7/23
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class OrderQueryService {
    private final PurchaseOrderSummaryRepository purchaseOrderSummaryRepository;
}
