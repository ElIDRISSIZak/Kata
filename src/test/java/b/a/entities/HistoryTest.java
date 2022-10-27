package b.a.entities;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HistoryTest {


    @Mock
    PrintStream printer;
    private History history;

    @Before
    public void initialise() {
        history = new History();
    }

    @Test
    public void
    should_print_statement_header() {
        history.printTo(printer);

        verify(printer).println(History.STATEMENT_HEADER);
    }


    @Test public void should_print_two_deposits_in_reverse_order() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        history.addLineContaining(new Operation(Amount.amountOf(1000), simpleDateFormat.parse("01/10/2022")),
                Amount.amountOf(1000));
        history.addLineContaining(new Operation(Amount.amountOf(2000), simpleDateFormat.parse("13/10/2022")),
                Amount.amountOf(3000));

        history.printTo(printer);

        InOrder inOrder = Mockito.inOrder(printer);
        inOrder.verify(printer).println("date       | credit   | debit    | balance");

    }
}
