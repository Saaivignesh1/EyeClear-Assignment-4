
import java.util.Date;
import java.util.Scanner;

class Eyewear{  
    public static void main(String args[]){  
        
        Scanner inSS = new Scanner(System.in);
        Prescription prescription = new Prescription();
        String val;
        int prescID;
        String firstName;
        String lastName;
        String address;
        float sphere;
        float axis;
        float cylinder;
        String examinationDate;
        String optometrist;
        //Boolean check = true;
        String remark;
        String category;
        System.out.println("Type 1 to add prescription, Type 2 to add a remark for the prescription, Press any other key to exit the program");
        val = inSS.nextLine();


        do{
            //check = true;
            if(val.equals("1")){
                System.out.println("Enter Firstname: ");
                firstName = inSS.nextLine();
                System.out.println("Enter Lastname: ");
                lastName = inSS.nextLine();
                System.out.println("Enter Prescription ID: ");
                prescID = Integer.parseInt(inSS.nextLine());
                System.out.println("Enter Address: ");
                address = inSS.nextLine();
                System.out.println("Enter Sphere: ");
                sphere = Float.parseFloat(inSS.nextLine());
                System.out.println("Enter Axis: ");
                axis = Float.parseFloat(inSS.nextLine());
                System.out.println("Enter Cylinder: ");
                cylinder = Float.parseFloat(inSS.nextLine());
                System.out.println("Enter Optometrist: ");
                optometrist = inSS.nextLine();
                System.out.println("Enter Date(Format:dd/mm/yy)");
                examinationDate = inSS.nextLine();
                if(!prescription.addPrescription(prescID, firstName, lastName, address, sphere, axis, cylinder, optometrist, examinationDate)){
                    //check = false;
                    System.out.println("Invalid Presciption Input, please type 1 to try Again");
                }
                else{
                    System.out.println("Prescription Entered Successfully, Press 1 to add other prescriptions, or 2 to add remarks, or any other key to exit:");
                }
            }
            else if (val.equals("2")){
                System.out.println("remark chosen(Max of 2 remarks per prescription)");
                System.out.println("Enter Remark: ");
                remark = inSS.nextLine();
                System.out.println("Enter Category(Only client and optometrist is acceptable): ");
                category = inSS.nextLine();

                if(!prescription.addRemark(remark, category)){
                    System.out.println("Invalid Remark");
                }
                else{
                    System.out.println("Remark Entered Successfully");
                }
                System.out.println("Press 1 to enter another prescription, or 2 to enter another remark. Press any other key to exit:");
            }

            val = inSS.nextLine();
        }
        while(val.equals("1") || val.equals("2"));


    

     
    }  
}  