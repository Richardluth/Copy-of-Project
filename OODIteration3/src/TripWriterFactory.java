//this class allows the creation of trip writers to read different languages
public class TripWriterFactory {
    public static TripWriter getTripWriter(String type) {
        if ("json".equalsIgnoreCase(type)) return new jsonWriter();
        else if ("xml".equalsIgnoreCase(type)) return new xmlWriter();
        return null;
    }
}
