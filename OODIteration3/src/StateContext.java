import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;
//this manages the states. This is singleton, so only one can exist at a time.
public class StateContext {
    public State myState;
    private static StateContext instance;

    private StateContext() {
        SetState(new CreateANewTripState());
    }

    public static StateContext getInstance() {
        if (instance == null) {
            instance = new StateContext();
        }
        return instance;
    }


    //sets the state
    public void SetState(State newState) {
        myState = newState;
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
    public void SetTripState(State newState) throws IOException, ParseException {
        try {
            Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].setState(newState);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The trip doesn't exist. Going to previous trip");
            Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].setState(newState);
        } catch (NullPointerException e) {
            System.out.println("Missing information. Please fill in information.");
            Main.sc.SetState(newState);
            Main.sc.Handle();
        }
    }
}

