//this class can be added to an itinerary to print information about the trip
public class TripDetailsDecorator extends ItineraryDecorator
{
    TripDetailsDecorator(Itinerary itin)
    {
        super(itin);
    }
    public void print(Trip t)
    {
        super.print(t);
        System.out.println("Travel agent name: " +t.ta.getName() + "\nTravel agent phone number: " + t.ta.getMobilePhone() + "\nTrip id: "+ t.uniqueId);
        if(t.complete) {
            t.thankYou();
        }
    }
}
