
//this class houses all of the packages offered and allows for a travel agent to see them
public class PackageSingleton
{
    Package package0 = new Package("Google HQ", "Russia", 42585.56, 28);
    Package package1 = new Package("France", "Trap house", 53278.99, 11);
    Package package2 = new Package("Orlando", "Portland", 70248.58, 41);
    Package package3 = new Package("Charlotte", "New York", 29681.86, 74);
    Package package4 = new Package("Germany", "Houston", 62423.56, 67);
    Package package5 = new Package("Charlotte", "Los Angeles", 86421.88, 34);
    Package package6 = new Package("Chicago", "Middle Earth", 24071.77, 66);
    Package package7 = new Package("Portland", "Google HQ", 47884.53, 83);
    Package package8 = new Package("Narnia", "France", 26745.01, 68);
    Package package9 = new Package("Japan", "France", 83361.66, 40);
    Package package10 = new Package("Kremlin", "The Deep", 98374.72, 8);
    Package package11 = new Package("New York", "Australia", 12885.57, 30);
    Package package12 = new Package("Chicago", "Google HQ", 71311.51, 52);
    Package package13 = new Package("Seattle", "Charlotte", 75863.79, 77);
    Package package14 = new Package("Japan", "Turkey", 16387.56, 42);
    Package package15 = new Package("Middle Earth", "Google HQ", 72327.43, 20);
    Package package16 = new Package("Orlando", "New York", 50237.33, 48);
    Package package17 = new Package("Middle Earth", "Seattle", 7791.85, 63);
    Package package18 = new Package("Kremlin", "Seattle", 25272.52, 38);
    Package package19 = new Package("Japan", "Candy Land", 90605.48, 89);
    Package package20 = new Package("Trap house", "Middle Earth", 75636.75, 60);
    Package package21 = new Package("Candy Land", "War zone", 94137.23, 23);
    Package package22 = new Package("New York", "Seattle", 10782.07, 89);
    Package package23 = new Package("War zone", "Phonenix", 84576.23, 93);
    Package package24 = new Package("Honolulu", "Google HQ", 17352.51, 78);
    Package package25 = new Package("Phonenix", "Google HQ", 93343.02, 66);
    Package package26 = new Package("Chicago", "Australia", 97417.46, 6);
    Package package27 = new Package("France", "Pain train", 76393.17, 6);
    Package package28 = new Package("Phonenix", "New York", 79852.37, 37);
    Package package29 = new Package("New York", "Australia", 19150.69, 41);
    Package package30 = new Package("Germany", "Google HQ", 73769.23, 93);
    public Package[] packages = new Package[]{package0,package1,package2,package3,package4,package5,package6,package7,package8,package9,package10,package11,package12,package13,package14,package15,package16,package17,package18,package19,package20,package21,package22,package23,package24,package25,package26,package27,package28,package29,package30};


//loadTravelers() not needed

    public void displayPackages()
    {

        for(int i = 0; i < packages.length; i++)
        {
            System.out.println("Package Number: " + i + "\nFrom: " + packages[i].getTravelsFrom() + "\nTo: " + packages[i].getTravelsTo() + "\nPrice: $" + packages[i].getPrice() + "\nHours of Travel: " + packages[i].getHoursOfTravel() + "\n");
        }
    }

    public void selectPackage(Package p, Trip tr)
    {
        tr.addPackage(p);
        tr.getCurrentPayment().amountOwed+=p.price;
        tr.getCurrentPayment().total+=p.price;
    }
}
