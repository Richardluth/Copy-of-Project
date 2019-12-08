import java.util.InputMismatchException;
import java.util.Scanner;
//this class houses all the travel agents and can display them. This is singleton, so only one can exist at a time.
public class TravelAgentSingleton
{
    private static TravelAgentSingleton instance;

    private TravelAgentSingleton()
    {
    }

    public static TravelAgentSingleton getInstance()
    {
        if(instance == null)
        {
            instance = new TravelAgentSingleton();
        }
        return instance;
    }

    TravelAgent activeTravelAgent;
    TravelAgent jonSnow = new TravelAgent("Jon Snow", "8675309");
    TravelAgent adamWest = new TravelAgent("Adam West", "7351857301");
    TravelAgent lionO = new TravelAgent("Lion-O", "1800SWORDOFOMENS");
    TravelAgent[] travelAgents = new TravelAgent[]{jonSnow,adamWest,lionO};

    void displayTravelAgents()
    {
        for(int i = 0; i < travelAgents.length; i++)
        {
            System.out.println(" Employee Number: " + i + ", Name: " + travelAgents[i].getName() + ", Mobile Phone Number: " + travelAgents[i].getMobilePhone());
        }
        boolean acceptable = false;
        while(!acceptable) {
            try {
                System.out.print("Who are you? Type in your Employee Number: ");
                Scanner scan = new Scanner(System.in);
                int choice = scan.nextInt();
                if(choice > -1 && choice < travelAgents.length) {
                    selectTravelAgent(travelAgents[choice]);
                    acceptable = true;
                }
                else
                {
                    System.out.println("Enter a valid choice");
                    acceptable = false;
                }
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                acceptable = false;
            }
        }
    }

    void selectTravelAgent(TravelAgent ta)
    {
        activeTravelAgent = ta;
    }
    TravelAgent getActiveTravelAgent()
    {
        return activeTravelAgent;
    }
}
