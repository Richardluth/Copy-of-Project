//this class represents a payment made to pay for the trip
public class Payment
{
    PaymentType currentPaymentType;
    double amountOwed;
    double total;
    boolean paidInFull = false;
    boolean payAsYouGo = false;
public Payment(double tot)
{
    this.amountOwed = tot;
    this.total = tot;
}
public void pay(double amt)
{
    amountOwed-=amt;
    currentPaymentType.pay(amt);
    if(amountOwed <= 0)
    {
        paidInFull = true;
        payAsYouGo = false;
    }
    else{
        payAsYouGo = true;
        paidInFull = false;
    }
}
public void setCurrentPaymentType(PaymentType pt)
{
    currentPaymentType = pt;
}
}
