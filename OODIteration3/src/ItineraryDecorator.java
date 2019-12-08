import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ItineraryDecorator implements Itinerary
{
    //this class's subclasses can be added to an itinerary to print more to the itinerary
    protected Itinerary itin;
    public ItineraryDecorator(Itinerary itin)
    {
        this.itin = itin;
    }

    public void print(Trip t) throws IOException, ParseException {
        itin.print(t);
    }
}
