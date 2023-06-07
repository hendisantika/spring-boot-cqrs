package com.hendisantika.springbootcqrs.service;

import com.hendisantika.springbootcqrs.dto.PurchaseOrderSummaryDto;
import com.hendisantika.springbootcqrs.repository.PurchaseOrderSummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PurchaseOrderSummaryDto> getSaleSummaryGroupByState() {
        return this.purchaseOrderSummaryRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public PurchaseOrderSummaryDto getSaleSummaryByState(String state) {
        return this.purchaseOrderSummaryRepository.findByState(state)
                .map(this::entityToDto)
                .orElseGet(() -> new PurchaseOrderSummaryDto(state, 0));
    }

    public double getTotalSale() {
        return this.purchaseOrderSummaryRepository.findAll()
                .stream()
                .mapToDouble(PurchaseOrderSummary::getTotalSale)
                .sum();
    }
}
