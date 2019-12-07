import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;
//this state asks the agent for a thank you note that will be printed on the receipt
public class ThankYouNoteState extends State{
    public void handle() throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);
        String thanks;
        boolean acceptable = false;
        while(!acceptable) {
            System.out.println("What would you like the thank you note for this trip to say? Enter \"Later\" to save and show all trips. Enter \"done\" if you have entered a thank you note you are satisfied with.");
            thanks = scan.nextLine();
            if (thanks.equalsIgnoreCase("later"))
            {
                acceptable = true;
                TripWriter writer = TripWriterFactory.getTripWriter("json");
                assert writer != null;
                writer.Write();
                Main.sc.SetStateFull(new ShowAllTripsState());
            }
            else if (thanks.equalsIgnoreCase("done") && Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].thankYouNote.length() >=5)
            {
                acceptable = true;
                TripWriter writer = TripWriterFactory.getTripWriter("json");
                assert writer != null;
                writer.WriteThankYouNote();
                Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].complete = true;
                Main.sc.SetStateFull(new ShowItineraryState());
            }
            else {
                Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].thankYouNote = thanks;
                TripWriter writer = TripWriterFactory.getTripWriter("json");
                assert writer != null;
                writer.WriteThankYouNote();
                //writer.WriteTrip();
            }
        }

    }
}
