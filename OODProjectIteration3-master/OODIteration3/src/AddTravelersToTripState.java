
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;
//this state lets you add travelers to the current trip
public class AddTravelersToTripState extends State
{
    public void handle() throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);
        boolean done = false;//if the loop is done or not
        while(!done) {
            Main.ts.displayTravelers();
            boolean acceptable = false;//assures the answer given works. if it does not, repeat
            while (!acceptable) {
                System.out.print("Who would you like to add to the trip? Type in their Traveler Number. \nType \"Later\" to save and show all trips. \nType \"Done\" if you have added all the travelers.");
                String choice = scan.nextLine();
                if (choice.equalsIgnoreCase("Later")) {
                    acceptable = true;
                    done = true;
                    Main.sc.SetState(new ShowAllTripsState());
                    Main.sc.Handle();
                }
                else if (choice.equalsIgnoreCase("Done")) {
                    acceptable = true;
                    done = true;
                    TripWriter writer = TripWriterFactory.getTripWriter("json");
                    assert writer != null;
                    writer.WriteTraveler();
                    //writer.WriteTrip();
                    Main.sc.SetStateFull(new AddPackagesToTripState());
                }
                else if (Integer.parseInt(choice) > -1 && Integer.parseInt(choice) <= Main.ts.travelers.length) {
                    Main.ts.addTraveler(Main.ts.travelers[Integer.parseInt(choice)], Main.tas.activeTravelAgent.trips[Main.tas.getActiveTravelAgent().getCurrentTrip()]);
                    TripWriter writer = TripWriterFactory.getTripWriter("json");
                    assert writer != null;
                    writer.WriteTraveler();
                    acceptable = true;
                }
            }
        }
    }
}
