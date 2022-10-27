package b.a.entities;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class History {


    private static final int TOP_OF_THE_LIST = 0;

    public static final String STATEMENT_HEADER = "date       | credit   | debit    | balance";

    private List<HistoryLine> historyLines = new LinkedList();

    public void addLineContaining(Operation operation, Amount currentBalance) {
        historyLines.add(TOP_OF_THE_LIST, new HistoryLine(operation, currentBalance));
    }

    public void printTo(PrintStream printer) {
        printer.println(STATEMENT_HEADER);
        printStatementLines(printer);
    }

    private void printStatementLines(PrintStream printer) {
        for (HistoryLine statementLine : historyLines) {
            statementLine.printTo(printer);
        }
    }
}
