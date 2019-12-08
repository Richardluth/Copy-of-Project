import org.json.simple.parser.ParseException;

import java.io.IOException;

//this class can be added to an itinerary to print information about the trip
public class TripDetailsDecorator extends ItineraryDecorator
{
    TripDetailsDecorator(Itinerary itin)
    {
        super(itin);
    }
    public void print(Trip t) throws IOException, ParseException {
        super.print(t);
        try {
            System.out.println("Travel agent name: " + t.ta.getName() + "\nTravel agent phone number: " + t.ta.getMobilePhone() + "\nTrip id: " + t.uniqueId);


            if (t.complete) {
                t.thankYou();
            }
        }
                catch(NullPointerException e)
            {
                System.out.println("Trip " + t + " does not exist. Please select the correct number of trips.");
                Main.sc.SetState(new ShowAllTripsState());
                Main.sc.Handle();
            }
    }
}
