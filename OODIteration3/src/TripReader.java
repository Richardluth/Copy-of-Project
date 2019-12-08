import org.json.simple.parser.ParseException;

import java.io.IOException;
//this interface allows for trips to be read from files
public interface TripReader
{
    String type = "none";
    void Read(int num) throws IOException, ParseException;

}
