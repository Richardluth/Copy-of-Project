//this class houses all the travelers and can display them
public class TravelerSingleton
{
    Traveler trav = new Traveler("Travis", "555");
    Traveler trav0 = new Traveler("clint Eastwood" , "7708247961");
    Traveler trav1 = new Traveler("Brad Pitt" , "7701552221");
    Traveler trav2 = new Traveler("Carrie Underwood" , "7709746922");
    Traveler trav3 = new Traveler("Doctor Tree" , "7703828585");
    Traveler trav4 = new Traveler("Man Vs Machine" , "7706758551");
    Traveler trav5 = new Traveler("Doctor Suiz" , "7704653499");
    Traveler trav6 = new Traveler("Random Guy" , "7703255477");
    Traveler trav7 = new Traveler("Bojack Horseman" , "7703936199");
    Traveler trav8 = new Traveler("Captain Crunch" , "7704963258");
    Traveler trav9 = new Traveler("Thomas Jefferson" , "7702451657");
    Traveler trav10 = new Traveler("Tom Hanks" , "7704827925");
    Traveler trav11 = new Traveler("Bruce WIllis" , "7704775754");
    Traveler trav12 = new Traveler("Robert De Niro" , "7709577683");
    Traveler trav13 = new Traveler("Denzel Washington" , "7702857944");
    Traveler trav14 = new Traveler("Christian Bale" , "7702685742");
    Traveler trav15 = new Traveler("Tom Cruisemissile" , "7706427232");
    Traveler trav16 = new Traveler("Leonardo Dicaprio" , "7707765623");
    Traveler trav17 = new Traveler("Johny Depp" , "7703711195");
    Traveler trav18 = new Traveler("Samual L. Jackson" , "7705917291");
    Traveler trav19 = new Traveler("Sean Connory" , "7707725976");
    Traveler trav20 = new Traveler("Morgan Freeman" , "7707774114");
    Traveler trav21 = new Traveler("Robin Williams" , "7705276836");
    Traveler trav22 = new Traveler("Harrison Ford" , "7702476544");
    Traveler trav23 = new Traveler("Nicolas Cage" , "7705339944");
    Traveler trav24 = new Traveler("Benedict Cumberbatch" , "7708544779");
    Traveler trav25 = new Traveler("Daniel Craig" , "7707744281");
    Traveler trav26 = new Traveler("Alec Baldwin" , "7706518448");
    Traveler trav27 = new Traveler("Micheal Douglas" , "7702253971");
    Traveler trav28 = new Traveler("Heath Ledger" , "7704113975");
    Traveler trav29 = new Traveler("Don Cheadle" , "7704464351");
    Traveler trav30 = new Traveler("Ross Miller" , "7704454352");
public Traveler[] travelers = new Traveler[]{trav, trav0, trav1, trav2, trav3, trav4, trav5,trav6,trav7,trav8,trav9,trav10,trav11,trav12,trav13,trav14,trav15,trav16,trav17,trav18,trav19,trav20,trav21,trav22,trav23,trav24,trav25,trav26,trav27,trav28,trav29,trav30};
public int travelerNum;

//loadTravelers() not needed

public void displayTravelers()
{
    for(int i = 0; i < travelers.length; i++)
    {
        System.out.println(" Traveler Number: " + i + ", Name: " + travelers[i].getName() + ", Mobile Phone Number: " + travelers[i].getMobilePhone());
    }

}

public void addTraveler(Traveler trav, Trip tr)
{
    tr.addTraveler(trav);
}
}
