import org.json.simple.parser.ParseException;

import java.io.IOException;
//this class allows for a trip to be written to files
public interface TripWriter
{
    String type = "none";
    void Write() throws IOException, ParseException;
    void WriteTrip() throws IOException, ParseException;
    void WritePayment() throws IOException, ParseException;
    void WriteTraveler() throws IOException,ParseException;
    void WritePackage() throws IOException,ParseException;
    void WriteThankYouNote() throws IOException,ParseException;
}
