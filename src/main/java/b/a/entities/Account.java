package b.a.entities;

import static b.a.entities.Amount.amountOf;

import java.io.PrintStream;
import java.util.Date;

public class Account {

    private History history;

    private Amount balance = amountOf(0);

    public Account(History history) {
        this.history = history;
    }

    public void deposit(Amount value, Date date) {
        recordTransaction(value, date);
    }

    public void withdrawal(Amount value, Date date) {
        recordTransaction(value.negative(), date);
    }

    public void printHistory(PrintStream printer) {
        history.printTo(printer);
    }

    private void recordTransaction(Amount value, Date date) {
        Operation operation = new Operation(value, date);
        Amount balanceAfterTransaction = operation.balanceAfterOperation(balance);
        balance = balanceAfterTransaction;
        history.addLineContaining(operation, balanceAfterTransaction);
    }
}
