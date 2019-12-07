import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;
//this state collects payment details from the person paying
public class CollectPaymentDetailsState extends State
{
    public void handle() throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Type \"Yes\" if you wish to enter payment details now. Type \"Later\" to save and show all trips");
        boolean acceptable = false;//assures the answer given works. if it does not, repeat
        while (!acceptable) {
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("Later")) {
                acceptable = true;
                Main.sc.SetState(new ShowAllTripsState());
                Main.sc.Handle();
            } else if (choice.equalsIgnoreCase("Yes")) {
                acceptable = true;
                Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].currentPayment.currentPaymentType.askForInformation();
                Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].currentPayment.pay(Main.tas.activeTravelAgent.trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].currentPayment.currentPaymentType.amount);
                Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].addPayment(Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].getCurrentPayment());
                TripWriter writer = TripWriterFactory.getTripWriter("json");
                assert writer != null;
                writer.WritePayment();
                if(Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].getCurrentPayment().paidInFull)
                {
                    System.out.println("The trip is fully paid for.");
                    if(Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].getCurrentPayment().amountOwed<0)
                    {
                        System.out.println("You overpaid by $" + -Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].getCurrentPayment().amountOwed + ". We are refunding you this amount.");
                        Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].getCurrentPayment().amountOwed = 0;
                    }
                    writer.WritePayment();
                    //writer.WriteTrip();
                    Main.sc.SetStateFull(new ThankYouNoteState());
                }
                else if(Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].getCurrentPayment().payAsYouGo)
                {
                    System.out.println("Current amount owed: $" + Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].currentPayment.amountOwed + ". Would you like to make another payment(enter 1) or continue(enter 2)?");
                    boolean acceptable2= false;
                    while (!acceptable2) {
                        String choice2 = scan.nextLine();
                        if (choice2.equalsIgnoreCase("1")) {
                            acceptable2 = true;
                            writer.WritePayment();
                            //writer.WriteTrip();
                            Main.sc.SetStateFull(new ChoosePaymentByPersonState());
                        }
                        else if(choice2.equalsIgnoreCase("2"))
                        {
                            acceptable2 = true;
                            writer.WritePayment();
                            //writer.WriteTrip();
                            Main.sc.SetStateFull(new ThankYouNoteState());
                        }
                        }
                }
                }
                System.out.println("Current amount owed: $" + Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].currentPayment.amountOwed);
            }
        }

    }

