//this class adds package information to the itinerary
public class PackageDecorator extends ItineraryDecorator
{
    PackageDecorator(Itinerary itin)
    {
        super(itin);
    }
    public void print(Trip t)
    {
        super.print(t);
        t.displayPackages();
    }
}
