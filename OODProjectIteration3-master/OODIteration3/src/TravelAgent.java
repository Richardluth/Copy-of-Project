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
    public void addTrip(Trip t)
    {
        //System.out.println(travelerNum);
        if(tripNum==tripCapacity)
        {
            increaseTripSize();
        }
        trips[tripNum] = t;
        currentTrip = tripNum;
        tripNum++;

        //printTravelers();
    }
    private void increaseTripSize() { //if we need to increase the size of the cart
        Trip[] temp=new Trip[tripCapacity+1];
        tripCapacity+=1;
        System.arraycopy(trips, 0, temp, 0, tripCapacity-1);

        trips=temp;
    }
    public void deleteTrips()
    {
        tripNum = 0;
        currentTrip = 0;
        trips = new Trip[1];
    }
}
