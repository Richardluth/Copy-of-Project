import org.json.simple.parser.ParseException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
//this state lets you choose a person to pay
public class ChoosePaymentByPersonState extends State
{
    public void handle() throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);
        try {
            Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].printTravelers();
        }
        catch(NullPointerException e)
        {

        }
        boolean acceptable = false;//assures the answer given works. if it does not, repeat
        while (!acceptable) {
            System.out.println("Current amount owed: $" + Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].currentPayment.amountOwed);
            System.out.print("Who would you like to choose payment type for? Type in their Traveler Number. \nType \"Later\" to save and show all trips.");
            try {
                String choice = scan.nextLine();
                if (choice.equalsIgnoreCase("Later")) {
                    acceptable = true;
                    TripWriter writer = TripWriterFactory.getTripWriter("json");
                    assert writer != null;
                    writer.Write();
                    Main.sc.SetState(new ShowAllTripsState());
                    Main.sc.Handle();
                } else if (Integer.parseInt(choice) > -1 && Integer.parseInt(choice) < Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].travelers.length) {
                    Main.currentTraveler = Main.tas.activeTravelAgent.trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].travelers[Integer.parseInt(choice)];
                    acceptable = true;
                    Main.sc.SetStateFull(new ChoosePaymentTypeState());
                }
            }
            catch(InputMismatchException | NumberFormatException e)
            {
                acceptable = false;
            }
        }
    }
}
