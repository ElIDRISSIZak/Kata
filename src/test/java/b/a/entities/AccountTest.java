package b.a.entities;

import b.a.entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static b.a.entities.Amount.amountOf;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    private History history;
    private Account account;

    @Before
    public void initialise() {
        account = new Account(history);
    }

    @Test
    public void
    should_add_deposit_line_to_history() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date depositDate = simpleDateFormat.parse("10/10/2022");

        Amount depositAmount = amountOf(1000);

        account.deposit(depositAmount, depositDate);

        verify(history).addLineContaining(new Operation(depositAmount, depositDate),
                currentBalanceEqualsTo(depositAmount));
    }

    @Test public void
    should_add_withdraw_line_to_history() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date withdrawalDate = simpleDateFormat.parse("12/10/2022");

        account.withdrawal(amountOf(500), withdrawalDate);

        verify(history).addLineContaining(new Operation(amountOf(-500), withdrawalDate),
                amountOf(-500));
    }

    @Test public void
    should_print_history() {
        PrintStream printer = System.out;

        account.printHistory(printer);

        verify(history).printTo(printer);
    }

    private Amount currentBalanceEqualsTo(Amount amount) {
        return amount;
    }
}
