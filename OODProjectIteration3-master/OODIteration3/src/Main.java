import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;
public class Main
{

    public final static Scanner scan = new Scanner(System.in);
    public static TravelAgentSingleton tas = new TravelAgentSingleton();
    public static TravelerSingleton ts = new TravelerSingleton();
    public static PackageSingleton ps = new PackageSingleton();
    public static Traveler currentTraveler = new Traveler("Generic", "555");
    public static StateContext sc = new StateContext();

    public static void main(String[] args) throws IOException, ParseException {
        tas.displayTravelAgents();
        System.out.println("Hello " + tas.getActiveTravelAgent().getName() +
                "\nWould you like to \n1) Create a new trip" +
                 "\n2) Show all your trips");
        int choice = 0;
        while(choice >2 || choice <1) {
            System.out.println("Enter your choice: ");
            choice = scan.nextInt();
            if (choice == 1)
            {
                sc.SetState(new CreateANewTripState());
            } else if (choice == 2)
            {
                sc.SetState(new ShowAllTripsState());
            }
        }
        sc.myState.handle();

    }
}
