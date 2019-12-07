//this class can be added to an itinerary to display information about the travelers on a trip
public class TravelersDecorator extends ItineraryDecorator
{
    TravelersDecorator(Itinerary itin)
    {
        super(itin);
    }
    public void print(Trip t)
    {
        super.print(t);
        t.printTravelers();
    }
}
