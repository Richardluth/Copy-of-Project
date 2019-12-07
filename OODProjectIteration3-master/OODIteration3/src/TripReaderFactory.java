//this class allows for trip readers to be created that can read different languages
public class TripReaderFactory {
        public static TripReader getTripReader(String type) {
            if ("json".equalsIgnoreCase(type)) return new jsonReader();
            else if("xml".equalsIgnoreCase(type)) return new xmlReader();
            return null;
        }
}
