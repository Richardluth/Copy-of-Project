import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//this class reads a json file and load trips from it
public class jsonReader implements TripReader {

    @SuppressWarnings("unchecked")
    public void Read(int num) {
        Main.tas.getActiveTravelAgent().deleteTrips();
        for(int i = 0;i < num; i++) {
            JSONParser jsonParser = new JSONParser();
            final int place = i;
            try (FileReader reader = new FileReader("trips" + place + ".json")) {
                //Read JSON file
                Object obj = jsonParser.parse(reader);

                JSONArray tripList = (JSONArray) obj;

                //Iterate over traveler array
                tripList.forEach(emp -> loadTripObject((JSONObject) emp, place));

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

            try (FileReader reader = new FileReader("travelers" + place + ".json")) {
                //Read JSON file
                Object obj = jsonParser.parse(reader);

                JSONArray travelerList = (JSONArray) obj;

                //Iterate over traveler array
                travelerList.forEach( emp -> loadTravelerObject( (JSONObject) emp,place) );

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

            try (FileReader reader = new FileReader("payments" + place + ".json")) {
                //Read JSON file
                Object obj = jsonParser.parse(reader);

                JSONArray travelerList = (JSONArray) obj;

                //Iterate over traveler array
                travelerList.forEach( emp -> loadPaymentObject( (JSONObject) emp,place) );

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

            try (FileReader reader = new FileReader("packages" + place + ".json")) {
                //Read JSON file
                Object obj = jsonParser.parse(reader);

                JSONArray travelerList = (JSONArray) obj;

                //Iterate over traveler array
                travelerList.forEach( emp -> loadPackageObject( (JSONObject) emp,place) );

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

            try (FileReader reader = new FileReader("thankYouNote" + place + ".json")) {
                //Read JSON file
                Object obj = jsonParser.parse(reader);

                JSONArray travelerList = (JSONArray) obj;

                //Iterate over traveler array
                travelerList.forEach( emp -> loadThankYouNoteObject( (JSONObject) emp,place) );

            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static void loadTravelerObject(JSONObject traveler, int tripNum) {
        //Get traveler object within list
        JSONObject travelerObject = (JSONObject) traveler.get("traveler");

        //Get name
        String name = (String) travelerObject.get("name");
        System.out.println("Traveler Name: " + name);

        //Get phone #
        String phoneNumber = (String) travelerObject.get("phone Number");
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println(); //a blank line, blanking it up

        Main.tas.getActiveTravelAgent().trips[tripNum].addTraveler(new Traveler(name,phoneNumber));
    }
    private static void loadTripObject(JSONObject trip, int tripNum) {
        JSONObject tripObject = (JSONObject) trip.get("trip info");
        System.out.println("Loading trip " + tripNum);

        String name = (String) tripObject.get("agent");
        System.out.println("Agent name: " + name);
        for(int i = 0; i< Main.tas.travelAgents.length;i++)
        {
            if(name.contains(Main.tas.travelAgents[i].getName()))
            {
                Main.tas.selectTravelAgent(Main.tas.travelAgents[i]);
            }
        }
        String state = (String) tripObject.get("state");
        System.out.println(state);
        if(state.contains("AddPackagesToTripState"))
        {
            Main.tas.activeTravelAgent.addTrip(new Trip(Main.tas.activeTravelAgent, tripNum,new AddPackagesToTripState()));
        }
        else if(state.contains("AddTravelersToTripState"))
        {
            Main.tas.activeTravelAgent.addTrip(new Trip(Main.tas.activeTravelAgent, tripNum,new AddTravelersToTripState()));
        }
        else if(state.contains("ChoosePaymentByPersonState"))
        {
            Main.tas.activeTravelAgent.addTrip(new Trip(Main.tas.activeTravelAgent, tripNum,new ChoosePaymentByPersonState()));
        }
        else if(state.contains("ChoosePaymentTypeState"))
        {
            Main.tas.activeTravelAgent.addTrip(new Trip(Main.tas.activeTravelAgent, tripNum,new ChoosePaymentTypeState()));
        }
        else if(state.contains("CollectPaymentDetailsState"))
        {
            Main.tas.activeTravelAgent.addTrip(new Trip(Main.tas.activeTravelAgent, tripNum,new CollectPaymentDetailsState()));
        }
        else if(state.contains("ThankYouNoteState"))
        {
            Main.tas.activeTravelAgent.addTrip(new Trip(Main.tas.activeTravelAgent, tripNum,new ThankYouNoteState()));
        }
        Main.tas.getActiveTravelAgent().setTripNum(tripNum);
    }
    private static void loadPackageObject(JSONObject pack, int tripNum) {
        //Get traveler object within list
        JSONObject packageObject = (JSONObject) pack.get("package info");

        //Saves all values from json file
        String travelsTo = (String) packageObject.get("travels to");
        String travelsFrom = (String) packageObject.get("travels from");
        double price = (double) packageObject.get("price");
        double hoursOfTravel = (double) packageObject.get("hours of travel");

        Main.tas.getActiveTravelAgent().trips[tripNum].addPackage(new Package(travelsFrom,travelsTo,price,hoursOfTravel));
    }
    private static void loadPaymentObject(JSONObject pay, int tripNum) {
        //Get payment object within list
        JSONObject paymentObject = (JSONObject) pay.get("payment info");

        //Saves all values from json file
        double amountOwed = (double) paymentObject.get("amount owed");
        double total = (double) paymentObject.get("total");
        boolean paidInFull = (boolean) paymentObject.get("paid in full");
        boolean payAsYouGo = (boolean) paymentObject.get("pay as you go");

        Main.tas.getActiveTravelAgent().trips[tripNum].addPayment(new Payment(total));
        Main.tas.getActiveTravelAgent().trips[tripNum].payments[Main.tas.getActiveTravelAgent().trips[tripNum].paymentNum-1].amountOwed = amountOwed;
        Main.tas.getActiveTravelAgent().trips[tripNum].payments[Main.tas.getActiveTravelAgent().trips[tripNum].paymentNum-1].paidInFull = paidInFull;
        Main.tas.getActiveTravelAgent().trips[tripNum].payments[Main.tas.getActiveTravelAgent().trips[tripNum].paymentNum-1].payAsYouGo = payAsYouGo;
    }
    private static void loadThankYouNoteObject(JSONObject pay, int tripNum) {
        //Get thank you note object within list
        JSONObject thanksObject = (JSONObject) pay.get("thank you note");

        //Saves all values from json file

        Main.tas.getActiveTravelAgent().trips[tripNum].thankYouNote = (String) thanksObject.get("thanks");


    }
}