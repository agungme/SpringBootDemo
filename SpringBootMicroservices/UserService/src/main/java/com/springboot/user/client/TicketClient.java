package com.springboot.user.client;

import com.springboot.user.entity.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "TicketService", path = "/tickets", decode404 = true)
public interface TicketClient {

    @GetMapping("/user/{id}")
    List<Ticket> getByUserId(@PathVariable("id") Long id);

}
