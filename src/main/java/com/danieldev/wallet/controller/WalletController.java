package com.danieldev.wallet.controller;

import com.danieldev.wallet.dto.request.TransferRequest;
import com.danieldev.wallet.entity.Wallet;
import com.danieldev.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService service;

    @PostMapping
    public Wallet create(@RequestParam String owner) {
        return service.createWallet(owner);
    }

    @PostMapping("/{id}/deposit")
    public Wallet deposit(@PathVariable Long id,
                          @RequestParam BigDecimal amount) {
        return service.deposit(id, amount);
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransferRequest request) {
        service.transfer(request);
        return ResponseEntity.ok("Transferência realizada");
    }

    @GetMapping("/{id}")
    public Wallet get(@PathVariable Long id) {
        return service.getWallet(id);
    }
}
