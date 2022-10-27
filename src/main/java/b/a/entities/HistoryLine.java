package b.a.entities;

import java.io.PrintStream;

public class HistoryLine {


    private Operation operation;
    private Amount currentBalance;

    public HistoryLine(Operation operation, Amount currentBalance) {
        this.operation = operation;
        this.currentBalance = currentBalance;
    }

    public void printTo(PrintStream printer) {
        this.operation.printTo(printer, currentBalance);
    }

}
