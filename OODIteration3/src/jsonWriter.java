import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
//this class writes information about your trips to a file
public class jsonWriter implements TripWriter {

    @SuppressWarnings("unchecked")
    public void WriteTraveler() {
        System.out.println("Writing travelers");
        JSONArray travelerList = new JSONArray(); //creating the JSON list for travelers

        //no longer needed int n = 0; //variable to grab final capacity values

        //loop to iterate through the array to get traveler details
        for (int i = 0; i < Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].travelerNum; i++) {
            JSONObject travelerDetails = new JSONObject(); //details to place into traveler object
            JSONObject travelerObject = new JSONObject(); //the traveler object, to be added to travelerList

            //details for json object
            travelerDetails.put("name", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].travelers[i].getName());
            travelerDetails.put("phone Number", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].travelers[i].getMobilePhone());
            //System.out.println(travelerDetails); //this was a test!

            travelerObject.put("traveler", travelerDetails); //places the details into the traveler object

            travelerList.add(travelerObject); //places the traveler object into the traveler list, to be written to JSON

            //System.out.println(travelerObject); //this was a test
        }

        //Write JSON file
        try (FileWriter file1 = new FileWriter("travelers" + Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].uniqueId + ".json")) {

            file1.write(travelerList.toJSONString());
            //System.out.println("JSON Written!"); //this was a test!
            file1.flush();

        } catch (IOException e) {
            System.out.println("Danger Will Robinson! Danger!");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    //Writes packages to json file
    public void WritePackage() {
        System.out.println("Writing packages");

        JSONArray packageList = new JSONArray(); //creating the JSON list for trips

        for (int i = 0; i < Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].packageNum; i++) {
            JSONObject packageDetails = new JSONObject(); //details about the trip
            JSONObject packageObject = new JSONObject(); //the trip object, gets added to a different json


            packageDetails.put("travels to", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].packages[i].travelsTo);
            packageDetails.put("travels from", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].packages[i].travelsFrom);
            packageDetails.put("price", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].packages[i].price);
            packageDetails.put("hours of travel", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].packages[i].hoursOfTravel);


            packageObject.put("package info", packageDetails); //places the details into the trip object

            packageList.add(packageObject);
        }

        try (FileWriter file2 = new FileWriter("packages" + Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].uniqueId + ".json")) {

            file2.write(packageList.toJSONString());
        } catch (IOException e) {
            System.out.println("Danger Will Robinson! Danger!");
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    public void WriteTrip(){
        System.out.println("Writing Trip");
        JSONArray tripList = new JSONArray(); //creating the JSON list for trips

        for (int i = 0; i < Main.tas.getActiveTravelAgent().trips.length; i++) {
            try {
                JSONObject tripDetails = new JSONObject(); //details about the trip
                JSONObject tripObject = new JSONObject(); //the trip object, gets added to a different json

                tripDetails.put("state", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].tripState.toString());
                tripDetails.put("agent", Main.tas.getActiveTravelAgent().getName());
                //tripDetails.put("capacity", Main.tas.getActiveTravelAgent().trips[i].getTravCapacity());
                //tripDetails.put("Package Array Size", Main.tas.getActiveTravelAgent().trips[i].getPackCapacity());
                //tripDetails.put("Pay Size", Main.tas.getActiveTravelAgent().trips[i].getPayCapacity());
                tripObject.put("trip info", tripDetails); //places the details into the trip object

                tripList.add(tripObject);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                break;
            }
        }

        try (FileWriter file2 = new FileWriter("trips" + Main.tas.getActiveTravelAgent().getCurrentTrip() + ".json")) {

            file2.write(tripList.toJSONString());
        } catch (IOException e) {
            System.out.println("Danger Will Robinson! Danger!");
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public void WritePayment() {
        System.out.println("Writing payments");

        JSONArray paymentList = new JSONArray(); //creating the JSON list for payments

        for (int i = 0; i < Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].paymentNum; i++) {
            try {
                JSONObject paymentDetails = new JSONObject(); //details about the payments
                JSONObject paymentObject = new JSONObject(); //the payment object, gets added to a different json

                paymentDetails.put("amount owed", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].payments[i].amountOwed);
                paymentDetails.put("total", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].payments[i].total);
                paymentDetails.put("paid in full", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].payments[i].paidInFull);
                paymentDetails.put("pay as you go", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].payments[i].payAsYouGo);

                paymentObject.put("payment info", paymentDetails);

                paymentList.add(paymentObject);

            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                break;
            }
            try (FileWriter file4 = new FileWriter("payments" + Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].uniqueId + ".json")) {

                file4.write(paymentList.toJSONString());
            } catch (IOException e) {
                System.out.println("Danger Will Robinson! Danger!");
                e.printStackTrace();
            }
        }


    }
    @SuppressWarnings("unchecked")
    public void WriteThankYouNote() {
        System.out.println("Writing thank you note");

        JSONArray thankYouList = new JSONArray(); //creating the JSON list for the thank you note

            JSONObject thankYouDetails = new JSONObject(); //details about the thank you note
            JSONObject thankYouObject = new JSONObject(); //the thank you note object, gets added to a different json

            thankYouDetails.put("thanks", Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].thankYouNote);

            thankYouObject.put("thank you note", thankYouDetails);
            thankYouList.add(thankYouObject);


            try (FileWriter file5 = new FileWriter("thankYouNote" + Main.tas.getActiveTravelAgent().trips[Main.tas.getActiveTravelAgent().getCurrentTrip()].uniqueId + ".json")) {

                file5.write(thankYouList.toJSONString()); //I'm tired of commenting redundant things, refer to earlier comments
            } catch (IOException e) {
                System.out.println("Danger Will Robinson! Danger!");
                e.printStackTrace();
            }
    }

    //I put this here to not break current implementation
    //Need to implement new methods to call at each state
    @Override
    public void Write() {

    }
}