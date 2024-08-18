package com.aniket.uberApp.strategies.impl;

import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.entities.Payment;
import com.aniket.uberApp.entities.Rider;
import com.aniket.uberApp.entities.enums.PaymentStatus;
import com.aniket.uberApp.entities.enums.TransactionMethod;
import com.aniket.uberApp.repositories.PaymentRepository;
import com.aniket.uberApp.services.WalletService;
import com.aniket.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();
        walletService.withdrawMoneyFromWallet(rider.getUser(), payment.getAmount(),
                null, payment.getRide(), TransactionMethod.RIDE);
        double driversAmount = payment.getAmount() * (1 - PLATFORM_COMMISSION);
        walletService.addMoneyToWallet(driver.getUser(), driversAmount,
                null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);

    }
}
