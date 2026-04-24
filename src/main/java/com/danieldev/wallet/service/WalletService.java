package com.danieldev.wallet.service;

import com.danieldev.wallet.dto.request.TransferRequest;
import com.danieldev.wallet.entity.Transaction;
import com.danieldev.wallet.entity.Wallet;
import com.danieldev.wallet.exception.BusinessException;
import com.danieldev.wallet.exception.ResourceNotFoundException;
import com.danieldev.wallet.repository.TransactionRepository;
import com.danieldev.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;
    private final TransactionRepository trasactionRepository;

    @Transactional
    public Wallet createWallet(String owner) {
        Wallet wallet = new Wallet();
        wallet.setOwner(owner);
        wallet.setBalance(BigDecimal.ZERO);
        return walletRepository.save(wallet);
    }

    @Transactional
    public Wallet deposit(Long walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Carteira não encontrada"));
        wallet.setBalance(wallet.getBalance().add(amount));
        return walletRepository.save(wallet);
    }

    @Transactional
    public void transfer(TransferRequest request) {
        Wallet from = walletRepository.findById(request.getFromWallet())
                .orElseThrow(() -> new RuntimeException("Remetente não encontrado."));
        Wallet to = walletRepository.findById(request.getToWallet())
                .orElseThrow(() -> new RuntimeException("Receptor não encontrado."));
        if (from.getBalance().compareTo(request.getAmount()) < 0) {
            throw new BusinessException("Saldo insuficiente");
        }

        from.setBalance(from.getBalance().subtract(request.getAmount()));
        to.setBalance(to.getBalance().add(request.getAmount()));
        walletRepository.save(from);
        walletRepository.save(to);
        Transaction tx = new Transaction();
        tx.setFromWallet(from.getId());
        tx.setToWallet(to.getId());
        tx.setAmount(request.getAmount());
        tx.setCreatedAt(LocalDateTime.now());
        trasactionRepository.save(tx);
    }

    public Wallet getWallet(Long id) {
        return walletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada."));
    }
}
