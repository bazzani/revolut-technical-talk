package revolut.technical.talk;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {
    @Test
    void should() {
        // given
        Account account = new Account();

        // when
        var accountBalanceException = assertThrows(AccountBalanceException.class,
                () -> account.withdrawal(BigDecimal.ONE));

        // then
        assertEquals("Insufficient Funds", accountBalanceException.getLocalizedMessage());
    }
}
