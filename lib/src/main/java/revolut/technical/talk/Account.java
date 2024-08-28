package revolut.technical.talk;

import java.math.BigDecimal;

public class Account {
    private final String id;
    private BigDecimal balance;

    public Account(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    BigDecimal withdrawal(BigDecimal withdrawalAmount) {
        if (withdrawalAmount.compareTo(BigDecimal.ZERO) < 1) {
            throw new AccountBalanceException("You cannot withdraw a negative amount");
        }

        boolean fundsAreNotAvailable = balance.compareTo(withdrawalAmount) <= 1;

        if (fundsAreNotAvailable) {
            throw new AccountBalanceException("Insufficient Funds");
        }

        balance = balance.subtract(withdrawalAmount);

        return balance;
    }

    BigDecimal lodge(BigDecimal lodgementAmount) {
        balance = balance.add(lodgementAmount);

        return balance;
    }
}
