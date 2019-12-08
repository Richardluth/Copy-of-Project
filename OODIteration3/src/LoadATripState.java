import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
//this state allows you to load a state or create a new state
public class LoadATripState extends State {
    public void handle() throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);
        boolean acceptable = false;//assures the answer is acceptable. if not, repeat
        while (!acceptable) {
            System.out.println("Which trip would you like to load? Type \"new\" to create a new trip.");
            try {
                String choice = scan.nextLine();
                if (choice.equalsIgnoreCase("new")) {
                    acceptable = true;
                    Main.sc.SetState(new CreateANewTripState());
                    Main.sc.Handle();
                } else if (Integer.parseInt(choice) > -1 && Integer.parseInt(choice) < Main.tas.getActiveTravelAgent().trips.length) {
                    acceptable = true;
                    Main.tas.getActiveTravelAgent().currentTrip = Integer.parseInt(choice);
                    Main.tas.getActiveTravelAgent().trips[Integer.parseInt(choice)].tripState.handle();
                }
            }
            catch(InputMismatchException | NumberFormatException e)
            {
                acceptable = false;
            }
        }
    }
}