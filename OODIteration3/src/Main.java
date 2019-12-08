import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public final static Scanner scan = new Scanner(System.in);
    public static TravelAgentSingleton tas = TravelAgentSingleton.getInstance();
    public static TravelerSingleton ts = TravelerSingleton.getInstance();
    public static PackageSingleton ps = PackageSingleton.getInstance();
    public static StateContext sc = StateContext.getInstance();
    public static Traveler currentTraveler = new Traveler("John Smith", "55555555");

    public static void main(String[] args) throws IOException, ParseException {
        tas.displayTravelAgents();
        System.out.println("Hello " + tas.getActiveTravelAgent().getName() +
                "\nWould you like to \n1) Create a new trip" +
                "\n2) Show all your trips");
        int choice = 0;
        boolean acceptable = false;
        while (!acceptable) {
            while (choice > 2 || choice < 1) {
                System.out.println("Enter your choice: ");
                try {
                    choice = scan.nextInt();
                    if (choice == 1) {
                        acceptable = true;
                        sc.SetState(new CreateANewTripState());
                    } else if (choice == 2) {
                        acceptable = true;
                        sc.SetState(new ShowAllTripsState());
                    }

                } catch (InputMismatchException e) {
                    acceptable = false;
                }
            }
            sc.myState.handle();

        }
    }
}
