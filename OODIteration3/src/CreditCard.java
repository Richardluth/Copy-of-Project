public class CreditCard extends PaymentType
{
    String name;
    String cardNum;
    String cardType;
    String expirationDate;
    String securityCode;

    public CreditCard()
    {
        //askForInformation();
    }

    public void askForInformation()
    {
        System.out.println("Enter amount: ");
        amount = Double.parseDouble(scan.nextLine());
        System.out.println("Enter name on card: ");
        name = scan.nextLine();
        System.out.println("Enter card number: ");
        cardNum = scan.nextLine();
        System.out.println("Enter card type: ");
        cardType = scan.nextLine();
        System.out.println("Enter card expiration date: ");
        expirationDate = scan.nextLine();
        System.out.println("Enter security code: ");
        securityCode = scan.nextLine();
    }
    public void pay(double amt)
    {
        System.out.println("Paid $" + amt + " with credit card");
    }
}
