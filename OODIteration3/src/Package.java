//this class holds a package, which is a conglomerate of rides in vehicles
public class Package
{
    String travelsFrom;//where it starts
    String travelsTo;//where it ends
    double price;//price of the package
    double hoursOfTravel;//how many hours it takes to travel
    Vehicle elCamino = new Vehicle();
    Vehicle[] vehicles = new Vehicle[]{elCamino};//currently never accessed

    public Package(String from, String to, double p, double hot)
    {
        travelsFrom = from;
        travelsTo = to;
        price = p;
        hoursOfTravel = hot;
    }

    public String getTravelsFrom() {
        return travelsFrom;
    }

    public String getTravelsTo() {
        return travelsTo;
    }

    public double getPrice() {
        return price;
    }

    public double getHoursOfTravel() {
        return hoursOfTravel;
    }
}
