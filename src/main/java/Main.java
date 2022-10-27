import b.a.entities.Account;
import b.a.entities.History;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static b.a.entities.Amount.amountOf;


public class Main {

    public static void main(String[] args) throws ParseException {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Account account = new Account(new History());

        account.deposit(amountOf(1000), simpleDateFormat.parse("03/10/2022"));
        account.deposit(amountOf(2000), simpleDateFormat.parse("05/10/2022"));
        account.withdrawal(amountOf(500), simpleDateFormat.parse("14/09/2022"));

        account.printHistory(System.out);

    }


}