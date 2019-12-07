import org.json.simple.parser.ParseException;

import java.io.IOException;
//this manages the states
public class StateContext
{
    public State myState;

    public StateContext()
    {
        SetState( new CreateANewTripState());
    }

    //sets the state
    public void SetState(State newState)
    {
        myState = newState;
        //myState.handle();
    }
    //sets the state, saves the trip state to the current trip, then handles it
    public void SetStateFull(State newState) throws IOException, ParseException {
        myState = newState;
        SetTripState(myState);
        myState.handle();
    }
    //handles the current state
    public void Handle() throws IOException, ParseException {
        myState.handle();
    }
    //sets the current state of the trip, allowing for it to be accessed later
    public void SetTripState(State newState)
    {
        Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].setState(newState);
    }

}
