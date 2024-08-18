package com.aniket.uberApp.services;

import com.aniket.uberApp.entities.Ride;
import com.aniket.uberApp.entities.User;
import com.aniket.uberApp.entities.Wallet;
import com.aniket.uberApp.entities.enums.TransactionMethod;

public interface WalletService {
    Wallet addMoneyToWallet(User user, Double amount, String transactionId,
                            Ride ride, TransactionMethod transactionMethod);

    Wallet withdrawMoneyFromWallet(User user, Double amount, String transactionId,
                                   Ride ride, TransactionMethod transactionMethod);

    void withdrawAllMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findWalletByUser(User user);
}
