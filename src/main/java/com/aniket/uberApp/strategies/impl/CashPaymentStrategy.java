package com.aniket.uberApp.strategies.impl;

import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.entities.Payment;
import com.aniket.uberApp.entities.enums.PaymentStatus;
import com.aniket.uberApp.entities.enums.TransactionMethod;
import com.aniket.uberApp.repositories.PaymentRepository;
import com.aniket.uberApp.services.WalletService;
import com.aniket.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Double platform_commission = payment.getAmount() * PLATFORM_COMMISSION;
        walletService.withdrawMoneyFromWallet(driver.getUser(), platform_commission,
                null, payment.getRide(), TransactionMethod.RIDE);
        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
