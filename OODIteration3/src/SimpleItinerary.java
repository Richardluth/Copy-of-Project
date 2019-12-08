//a basic itinerary that decorators can be added to
public class SimpleItinerary implements Itinerary
{
    public SimpleItinerary()
    {
    }
    public void print(Trip t) {
        System.out.println("Printing itinerary...");
    }
}
