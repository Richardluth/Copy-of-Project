public class Check extends PaymentType
{
    String name;
    String checkNumber;
    public Check()
    {
        //askForInformation();
    }
    public void askForInformation()
    {
        System.out.println("Enter amount: ");
        amount = Double.parseDouble(scan.nextLine());
        System.out.println("Enter name: ");
        name = scan.nextLine();
        System.out.println("Enter checkNumber: ");
        checkNumber = scan.nextLine();
    }
    public void pay(double amt)
    {
        System.out.println("Paid $" + amt + " with check");
    }
}
