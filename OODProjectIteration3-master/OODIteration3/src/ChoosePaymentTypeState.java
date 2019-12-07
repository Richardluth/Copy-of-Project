import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;
//this state lets you choose between credit card, cash, and check to pay for the trip
public class ChoosePaymentTypeState extends State
{
    public void handle() throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Current amount owed: $" + Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].currentPayment.amountOwed);
        System.out.println("Choose payment type. \n1: Check \n2: Credit Card \n3: Cash");
        boolean acceptable = false;//assures the answer given works. if it does not, repeat
        while (!acceptable) {
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("Later")) {
                acceptable = true;
                TripWriter writer = TripWriterFactory.getTripWriter("json");
                assert writer != null;
                writer.Write();
                Main.sc.SetState(new ShowAllTripsState());
                Main.sc.Handle();
            } else if (Integer.parseInt(choice) == 1) {
                Main.tas.activeTravelAgent.trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].currentPayment.setCurrentPaymentType(new Check());
                acceptable = true;
                Main.sc.SetStateFull(new CollectPaymentDetailsState());
            }
            else if (Integer.parseInt(choice) == 2) {
                Main.tas.activeTravelAgent.trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].currentPayment.setCurrentPaymentType(new CreditCard());
                acceptable = true;
                Main.sc.SetStateFull(new CollectPaymentDetailsState());
            }
            else if (Integer.parseInt(choice) == 3) {
                Main.tas.activeTravelAgent.trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].currentPayment.setCurrentPaymentType(new Cash());
                acceptable = true;
                Main.sc.SetStateFull(new CollectPaymentDetailsState());
            }
        }


    }
}
