import org.json.simple.parser.ParseException;

import java.io.IOException;
//this state creates a new trip
public class CreateANewTripState extends State
{
    public void handle() throws IOException, ParseException {
        Main.tas.activeTravelAgent.addTrip(new Trip(Main.tas.activeTravelAgent, Main.tas.activeTravelAgent.getTripNum(),new AddTravelersToTripState()));
        TripWriter writer = TripWriterFactory.getTripWriter("json");
        assert writer != null;
        writer.WriteTrip();
        Main.sc.SetState(new AddTravelersToTripState());
        Main.sc.Handle();

    }
}
