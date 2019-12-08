import org.json.simple.parser.ParseException;

import java.io.IOException;

//this class adds package information to the itinerary
public class PackageDecorator extends ItineraryDecorator
{
    PackageDecorator(Itinerary itin)
    {
        super(itin);
    }
    public void print(Trip t) throws IOException, ParseException {
        super.print(t);
        t.displayPackages();
    }
}
