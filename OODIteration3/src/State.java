import org.json.simple.parser.ParseException;

import java.io.IOException;
//this represents a single state
public abstract class State
{
    //does whatever the state does
    public void handle() throws IOException, ParseException {
        System.out.println("This is the default state");
    }


}