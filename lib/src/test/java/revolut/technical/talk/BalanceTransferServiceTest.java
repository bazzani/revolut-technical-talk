package revolut.technical.talk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalanceTransferServiceTest {
    private BalanceTransferService sut;

    @BeforeEach
    public void setup() {
        sut = new BalanceTransferService();
    }

    @Test
    void shouldGetAccountOneFirst() {
        // given
        Account accountOne = new Account("account1", BigDecimal.ONE);
        Account accountTwo = new Account("account2", BigDecimal.TEN);

        // when
        Account[] orderedAccounts = sut.getOrderedAccounts(accountOne, accountTwo);

        // then
        assertEquals(orderedAccounts[0], accountOne);
        assertEquals(orderedAccounts[1], accountTwo);
    }

    @Test
    void shouldGetAccountTwoFirst() {
        // given
        Account accountOne = new Account("accountOne", BigDecimal.ONE);
        Account accountTwo = new Account("account2", BigDecimal.TEN);

        // when
        Account[] orderedAccounts = sut.getOrderedAccounts(accountOne, accountTwo);

        // then
        assertEquals(orderedAccounts[0], accountTwo);
        assertEquals(orderedAccounts[1], accountOne);
    }
}
