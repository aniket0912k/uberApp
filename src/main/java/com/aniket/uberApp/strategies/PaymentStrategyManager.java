package com.aniket.uberApp.strategies;

import com.aniket.uberApp.strategies.impl.CashPaymentStrategy;
import com.aniket.uberApp.strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {
    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy getPaymentStrategy(String paymentMethod) {
        if (paymentMethod.equals("WALLET")) {
            return walletPaymentStrategy;
        } else if (paymentMethod.equals("CASH")) {
            return cashPaymentStrategy;
        } else {
            throw new IllegalArgumentException("Invalid Payment Method");
        }
    }
}
