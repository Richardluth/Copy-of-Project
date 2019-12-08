import org.json.simple.parser.ParseException;

import java.io.IOException;

//this class adds payment information to the itinerary
public class PaymentDecorator extends ItineraryDecorator
{
    PaymentDecorator(Itinerary itin)
    {
        super(itin);
    }
    public void print(Trip t) throws IOException, ParseException {
        super.print(t);
        t.displayPayments();
    }
}