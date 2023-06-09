package com.hendisantika.springbootcqrs.controller.command;

import com.hendisantika.springbootcqrs.dto.OrderCommandDto;
import com.hendisantika.springbootcqrs.service.OrderCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-cqrs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/7/23
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("po")
@RequiredArgsConstructor
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "true")
public class OrderCommandController {

    private final OrderCommandService orderCommandService;

    @PostMapping("/sale")
    public void placeOrder(@RequestBody OrderCommandDto dto) {
        this.orderCommandService.createOrder(dto.getUserIndex(), dto.getProductIndex());
    }

    @PutMapping("/cancel-order/{orderId}")
    public void cancelOrder(@PathVariable long orderId) {
        this.orderCommandService.cancelOrder(orderId);
    }
}
