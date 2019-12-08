//this class represents a single person, which has a name and a phone number
public class Person
{
    private String name;
    private String MobilePhone;

    public String getName()
    {
        return name;
    }

    public String getMobilePhone()
    {
        return MobilePhone;
    }

    public Person(String n, String mp)
    {
        name = n;
        MobilePhone = mp;
    }
}
