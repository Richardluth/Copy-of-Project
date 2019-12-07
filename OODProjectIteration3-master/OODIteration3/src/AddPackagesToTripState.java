import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;
//This state lets you add packages to the Trip
public class AddPackagesToTripState extends State
{
    public void handle() throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);
        boolean done = false;//if the loop is done or not
        while(!done) {
            Main.ps.displayPackages();
            boolean acceptable = false;//assures the answer given works. if it does not, repeat
            while (!acceptable) {
                System.out.print("Which package would you like to add to the trip? Type in its package number. \nType \"Later\" to save and show all trips. \nType \"Done\" if you have added all the packages you need.");
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
                    writer.WritePackage();
                    //writer.WriteTrip();
                    Main.sc.SetStateFull(new ChoosePaymentByPersonState());
                }
                else if (Integer.parseInt(choice) > -1 && Integer.parseInt(choice) < Main.ps.packages.length) {
                    Main.ps.selectPackage(Main.ps.packages[Integer.parseInt(choice)], Main.tas.activeTravelAgent.trips[Main.tas.getActiveTravelAgent().getCurrentTrip()]);
                    TripWriter writer = TripWriterFactory.getTripWriter("json");
                    assert writer != null;
                    writer.WritePackage();
                    acceptable = true;
                }
            }
        }
    }
}
