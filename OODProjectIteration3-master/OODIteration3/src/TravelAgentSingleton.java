import java.util.Scanner;
//this class houses all the travel agents and can display them
public class TravelAgentSingleton
{
    TravelAgent activeTravelAgent;
    TravelAgent jonSnow = new TravelAgent("Jon Snow", "8675309");
    TravelAgent adamWest = new TravelAgent("Adam West", "7351857301");
    TravelAgent lionO = new TravelAgent("Lion-O", "1800SWORDOFOMENS");
    TravelAgent[] travelAgents = new TravelAgent[]{jonSnow,adamWest,lionO};

    void displayTravelAgents()
    {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < travelAgents.length; i++)
        {
            System.out.println(" Employee Number: " + i + ", Name: " + travelAgents[i].getName() + ", Mobile Phone Number: " + travelAgents[i].getMobilePhone());
        }
        System.out.print("Who are you? Type in your Employee Number: ");
        int choice = scan.nextInt();
        selectTravelAgent(travelAgents[choice]);
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
