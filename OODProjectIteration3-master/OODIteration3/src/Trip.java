import java.util.Scanner;
//this class represents a single trip, which contains travelers, payments, and packages
public class Trip
{
    TravelAgent ta;
    int uniqueId;
    boolean complete = false;
    String thankYouNote = "Thank you for booking your trip with the A team!";
    //String destination;
    State tripState = new AddTravelersToTripState();
    int tCapacity = 1;
    int pCapacity = 1;
    int payCapacity = 1;
    public Traveler[] travelers = new Traveler[tCapacity];
    int travelerNum = 0;
    Package[] packages = new Package[pCapacity];
    int packageNum = 0;
    public Payment currentPayment = new Payment(0);
    public Payment[] payments = new Payment[payCapacity];
    public int paymentNum = 0;


    public Trip(TravelAgent ta, int id, State s)
    {
        this.ta = ta;
        uniqueId = id;
        tripState = s;
        //thankYouNote = thanks;
        //destination = dest;
    }

    public String thankYou()
    {
        return thankYouNote;
    }

    public void addTraveler(Traveler t)
    {
        //System.out.println(travelerNum);
        if(travelerNum+1==tCapacity)
        {
            increaseTravelerSize();
        }
        travelers[travelerNum] = t;
        travelerNum++;
        //printTravelers();
    }
    public void printTravelers()
    {
        for(int i = 0; i < travelers.length-1; i++)
        {
            System.out.println("Traveler Number: " + i + ", Name: " + travelers[i].getName() + ", Mobile Phone Number: " + travelers[i].getMobilePhone());
        }
    }

    public void displayPackages()
    {
        for(int i = 0; i < packages.length; i++)
        {
            System.out.println("Package Number: " + i + "\nFrom: " + packages[i].getTravelsFrom() + "\nTo: " + packages[i].getTravelsTo() + "\nPrice: $" + packages[i].getPrice() + "\nHours of Travel: " + packages[i].getHoursOfTravel() + "\n");
        }
    }

    public void displayPayments()
    {
        for(int i = 0; i < payments.length; i++)
        {
            System.out.println("Payment Number: " + i + "\nAmount Owed: " + payments[i].amountOwed + "\nTotal cost: " + payments[i].total + "\n");
            if(payments[i].paidInFull)
            {
                System.out.println("Paid in full");
            }
            else if(payments[i].payAsYouGo)
            {
                System.out.println("Pay as you go");
            }
        }
    }

    public void addPackage(Package p)
    {
        if(packageNum==pCapacity)
        {
            increasePackageSize();
        }
        packages[packageNum] = p;
        packageNum++;
    }

    public void addPayment(Payment p)
    {
        if(paymentNum==payCapacity)
        {
            increasePaymentSize();
        }
        payments[paymentNum] = p;
        paymentNum++;
    }

    private void increaseTravelerSize() { //if we need to increase the size of the cart
        Traveler[] temp=new Traveler[tCapacity+1];
        tCapacity+=1;
        System.arraycopy(travelers, 0, temp, 0, tCapacity-1);
        travelers=temp;
    }

    private void increasePackageSize() { //if we need to increase the size of the cart
        Package[] temp=new Package[pCapacity+1];
        pCapacity+=1;
        System.arraycopy(packages, 0, temp, 0, pCapacity-1);
        packages=temp;
    }

    private void increasePaymentSize() { //if we need to increase the size of the cart
        Payment[] temp=new Payment[payCapacity+1];
        payCapacity+=1;
        System.arraycopy(payments, 0, temp, 0, payCapacity-1);
        payments=temp;
    }
    public void setState(State s)
    {
        tripState = s;
    }

    public int getPaymentNum() {
        return paymentNum;
    }

    public Payment getCurrentPayment() {
        return currentPayment;
    }

    public int getTravCapacity() {return tCapacity; }

    public int getPackCapacity() {return pCapacity; };

    public int getPayCapacity () {return payCapacity; }

}
