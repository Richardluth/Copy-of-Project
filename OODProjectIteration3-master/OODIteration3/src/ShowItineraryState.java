//this state prints an itinerary for the current trip
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ShowItineraryState extends State
{
    public void handle() throws IOException, ParseException {
        Trip t = Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()];
        Itinerary itin = new PaymentDecorator(new TravelersDecorator(new PackageDecorator(new TripDetailsDecorator(new SimpleItinerary()))));
        itin.print(t);
        Main.sc.SetState(new ShowAllTripsState());
        Main.sc.Handle();
    }
}
