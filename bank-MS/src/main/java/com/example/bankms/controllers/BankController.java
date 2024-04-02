package com.example.bankms.controllers;


import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.bankms.services.BankAccountService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class BankController {

    final BankAccountService bankAccountService;

    @GetMapping("/{accountNumber}")
    public Double getBalance(@PathVariable String accountNumber){
        return bankAccountService.getBalance(accountNumber);
    }

    @PostMapping("/transfer")
    public void transferGrant(@RequestBody ObjectNode objectNode){
        bankAccountService.transferGrant(objectNode.get("accountNumber").asText(), objectNode.get("grant").asDouble());
    }

    @PostMapping("/debit")
    public void debitGrant(@RequestBody ObjectNode objectNode) throws Exception {
        bankAccountService.debitGrant(objectNode.get("accountNumber").asText(), objectNode.get("grant").asDouble());
    }

}
