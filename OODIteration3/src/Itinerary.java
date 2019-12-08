import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface Itinerary
{
    void print(Trip t) throws IOException, ParseException;
}
