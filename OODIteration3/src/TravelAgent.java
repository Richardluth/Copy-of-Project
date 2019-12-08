//this class represents a single travel agent that can manage trips
public class TravelAgent extends Person
{
    int tripCapacity = 1;
    public Trip[] trips = new Trip[tripCapacity];
    int tripNum = 0;
    int currentTrip = 0;

    TravelAgent(String n, String pn)
    {
        super(n,pn);
    }

    public void printTrips()
    {
        for(int i = 0; i < tripNum; i++)
        {
            System.out.println("Trip id: " + trips[i].uniqueId + "\nTravelers: " + trips[i].travelerNum + "\nPackages: " + trips[i].packageNum + "\nPayments: " + trips[i].paymentNum + "\nAmount Owed: " + trips[i].getCurrentPayment().amountOwed + "\n");
        }
    }


    public int getTripNum()
    {
        return tripNum;
    }
    public int getCurrentTrip()
    {
        return currentTrip;
    }
    public void setTripNum(int tripNum) {
        this.tripNum = tripNum;
    }

    public void setCurrentTrip(int currentTrip) {
        this.currentTrip = currentTrip;
    }

    //adds a trip to the trips array. if there is not room, increase the size of the trip array to fit it
    public void addTrip(Trip t)
    {
        try {
            //System.out.println(travelerNum);
            if (tripNum + 1 == tripCapacity) {
                increaseTripSize();
            }
            trips[currentTrip] = t;
            currentTrip = tripNum;
            tripNum++;

            //printTravelers();
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            if(currentTrip < 0)
            {
                currentTrip++;
                addTrip(t);
            }
            else if (currentTrip > trips.length)
            {
                currentTrip--;
                addTrip(t);
            }
        }
    }

    //increases the size of the trip array, while retaining all its components
    private void increaseTripSize() { //if we need to increase the size of the cart
        Trip[] temp=new Trip[tripCapacity+1];
        tripCapacity+=1;
        System.arraycopy(trips, 0, temp, 0, tripNum);

        trips=temp;
    }
    public void deleteTrips()
    {
        tripNum = 0;
        currentTrip = 0;
        trips = new Trip[1];
    }
}
