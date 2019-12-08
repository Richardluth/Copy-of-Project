//this state shows all of the current trips the travel agent is managing
import org.json.simple.parser.ParseException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class ShowAllTripsState extends State {
    public void handle() throws IOException, ParseException {

        Scanner scan = new Scanner(System.in);
        TripReader reader = TripReaderFactory.getTripReader("json");
        System.out.println("How many trips would you like to load?");
        try {
            int numTrips = scan.nextInt();
            assert reader != null;
            reader.Read(numTrips);
            for (int i = 0; i < numTrips; i++) {
                Trip t = Main.tas.getActiveTravelAgent().trips[i];
                Itinerary itin = new PaymentDecorator(new PackageDecorator(new TravelersDecorator(new TripDetailsDecorator(new SimpleItinerary()))));
                itin.print(t);
            }

            Main.sc.SetState(new LoadATripState());
            Main.sc.Handle();
        }
        catch(InputMismatchException | NumberFormatException e)
        {
            System.out.println("Please enter an integer.");
            Main.sc.SetState(new ShowAllTripsState());
            Main.sc.Handle();
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("This many trips don't exist. Try again.");
            Main.sc.SetState(new ShowAllTripsState());
            Main.sc.Handle();
        }

    }
}
