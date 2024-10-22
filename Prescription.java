import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.text.ParseException;
import java.io.FileWriter;
import java.io.IOException;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String optometrist;
    //private String[] remarkTypes = {"Client", "Optometrist"};
    private ArrayList<String> postRemarks = new ArrayList<>();

    

    public boolean addPrescription(int PID, String FirstName, String LastName, String Address, float Sphere, float Axis, float Cylinder, String Optometrist, String ExaminationDate) {

        prescID = PID;
        firstName = FirstName;
        lastName = LastName;
        address = Address;
        sphere = Sphere;
        axis = Axis;
        cylinder = Cylinder;
        optometrist = Optometrist;
        
        // Check if first name is less than 4 or greater than 15(not valid)
        if (firstName.length() < 4 || firstName.length() > 15){
            System.out.println("Invalid First name characters, characters cannot be less than 4 or greater than 15.");
            return false;
        }

        // Check if last name is less than 4 or greater than 15(not valid)
        if (lastName.length() < 4 || lastName.length() > 15) {
            System.out.println("Invalid Last name characters, characters cannot be less than 4 or greater than 15.");
            return false;
        }

        // Check if address is less than 20(not valid)
        if (address.length() < 20) {
            System.out.println("Invalid Address characters, characters cannot be less than 20");
            return false;
        }

        //check if sphere is less than -20.00 or more than 20(not valid)
        if ( sphere < -20.00f || sphere > 20.00f){
            System.out.println("Invalid Sphere, cannot be less than -20.00 or more than 20.00");
            return false;
        }

        //check if cylinder is less than -4.00 or more than 4(not valid)
        if (cylinder < -4.00f || cylinder > 4.00f){
            System.out.println("Invalid Cylinder, cannot be less than -4.00 or more than 4.00");
            return false;
        }

        //check if sphere is less than 0 or more than 180(not valid)
        if ( axis < 0 || axis > 180){
            System.out.println("Invalid Axis, cannot be less than 0 or more than 180");
            return false;
        }

        // Check if format matches dd/mm/yy
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            examinationDate = dateFormat.parse(ExaminationDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yy.");
            return false;
        }

        // Check if optometrist is less than 8 or greater than 25(not valid)
        if (optometrist.length() < 8 || optometrist.length() > 25) {
            System.out.println("Invalid optometrist characters, characters cannot be less than 8 or greater than 25.");
            return false;
        }
        
        // If all conditions are met, write to file
        try (FileWriter fileObj = new FileWriter("prescription.txt", true)) {   //Create file object to write to prescription.txt, append information to the end of the file
            fileObj.write("Prescription ID: " + prescID + "\n");
            fileObj.write("First Name: " + firstName + "\n");
            fileObj.write("Last Name: " + lastName + "\n");
            fileObj.write("Address: " + address + "\n");
            fileObj.write("Sphere: " + sphere + "\n");
            fileObj.write("Axis: " + axis + "\n");
            fileObj.write("Cylinder: " + cylinder + "\n");
            fileObj.write("Optometrist: " + optometrist + "\n");
            fileObj.write("Examination Date: " + ExaminationDate + "\n");
            fileObj.write("\n");                                //Add Spacing between Prescriptions
            fileObj.write("\n");            
            fileObj.write("\n");
        } catch (IOException e) {
            return false;
        }

        return true;
    }
    public boolean addRemark(String remark, String category) {
        //System.out.println("Enter function");
        
        // check if remark has been entered at max 2 times for a presciption, if so no more is acceptable
        if (postRemarks.size() >= 2) {
            System.out.println("Invalid Remark, 2 remarks have already been entered for the prescription");
            return false;
        }

        // Check if remark is less than 6 words or greater than 20 wirds (not valid)
        String[] words = remark.trim().split("\\s+");
        if (words.length < 6 || words.length > 20) {
            System.out.println("Invalid length, remark should be less than 6 words or more than 20 words");
            //System.out.println(words.length);
            return false;
        }

        // check if the first character of the first word is uppercase
        if (!Character.isUpperCase(words[0].charAt(0))) {
            System.out.println("Remark not Capitalized");
            return false;
        }
        //check if category is either "Client" or "Optometrist"
        //exit program if category is not equal to client or optometrist
        if (!category.equals("client")&&!category.equals("optometrist")){
            System.out.println("Invalid Category, only client and optometrist is accepted");
            return false;
        }


        // If all conditions are met, add the remark to the file and the list
        try (FileWriter fileObj = new FileWriter("remark.txt", true)) {
            fileObj.write("Prescription ID: " + prescID + "\n");
            fileObj.write("Remark: "+ remark + "("+ category + ")" + "\n");
            fileObj.write("\n");            //Add Spacing between remarks
            fileObj.write("\n");
            fileObj.write("\n");
        } catch (IOException e) {
            //System.out.println("Remark File fail");
            return false;
        }

        //Add remark to the list
        postRemarks.add(remark);

        return true;
    }

}