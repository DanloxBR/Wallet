package com.danieldev.wallet.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private Long fromWallet;
    private Long toWallet;
    private BigDecimal amount;
}
