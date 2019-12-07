//this class adds payment information to the itinerary
public class PaymentDecorator extends ItineraryDecorator
{
    PaymentDecorator(Itinerary itin)
    {
        super(itin);
    }
    public void print(Trip t)
    {
        super.print(t);
        t.displayPayments();
    }
}