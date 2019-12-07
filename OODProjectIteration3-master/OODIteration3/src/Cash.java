public class Cash extends PaymentType
{
    public Cash()
    {
        //askForInformation();
    }
    public void pay(double amt)
    {
        System.out.println("Paid $" + amt + " with cash");
    }
}
