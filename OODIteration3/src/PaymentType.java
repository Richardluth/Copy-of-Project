//this class represents a way to pay for the trip
import java.util.Scanner;
public class PaymentType
{
    Scanner scan = new Scanner(System.in);
    double amount = 0;
    PaymentType()
    {
    }
    public void askForInformation()
    {
        System.out.println("Enter amount: ");
        amount = Double.parseDouble(scan.nextLine());
    }

    public void pay(double amt)
    {
        System.out.println("Paid $" + amt);
    }
}
