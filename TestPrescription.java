import org.junit.*;


public class TestPrescription {
    @Test
    //Check with valid inputs
    public void testAddPrescription(){
        Prescription prescription = new Prescription();
        //Check with valid inputs
        Assert.assertEquals(true, prescription.addPrescription(1,"Jackman", "Micheal", "Melbourne 3000 CBD Australia", 0, 90, 0, "Doctor Dan","9/12/24"));
        Assert.assertEquals(true, prescription.addPrescription(2,"Samuel", "Micheal", "Melbourne 3000 CBD Australia", 0, 90, 0, "Doctor Dan","9/12/24"));
        

        
        //First Name has to have 4 min and max 15 characters
        //check with invalid First name, less than min 4 or more than max 15 characters
        Assert.assertEquals(false, prescription.addPrescription(3,"Sam", "Micheal", "Melbourne 3000 CBD Australia", 0, 90, 0, "Doctor Dan","9/12/24"));
        Assert.assertEquals(false, prescription.addPrescription(4,"Alonelypumpkinbytheriver", "Micheal", "Melbourne 3000 CBD Australia", 0, 90, 0, "Doctor Dan","9/12/24"));
        
        
        //Last Name has to have 4 min and max 15 characters
        //check with invalid Last name, less than min 4 or greater than max 15 characters
        Assert.assertEquals(false, prescription.addPrescription(5,"Sierra", "Rao", "Melbourne 3000 CBD Australia", 0, 90, 0, "Doctor Dan","9/12/24"));
        Assert.assertEquals(false, prescription.addPrescription(6,"Felix", "Alonelyapplebytheriver", "Melbourne 3000 CBD Australia", 0, 90, 0, "Doctor Dan","9/12/24"));
        
        
        //Address should have a minimum of 20 characters
        //check for invalid Address, 19 characters or below
        Assert.assertEquals(false, prescription.addPrescription(7,"Rastoue", "Raol", "Melbourne 3000 CBD ", 0, 90, 0, "Doctor Dan","9/12/24"));
        Assert.assertEquals(false, prescription.addPrescription(8,"Mitch", "Cabone", "Melbourne", 0, 90, 0, "Doctor Dan","9/12/24"));
        
        
        //Sphere Value should be between -20 min and 20 max
        //Check for invalid sphere value less than -20 or greater than 20
        Assert.assertEquals(false, prescription.addPrescription(9,"Sameual", "Raol", "Melbourne 3000 CBD Australia", -30, 90, 0, "Doctor Dan","9/12/24"));
        Assert.assertEquals(false, prescription.addPrescription(10,"Jackman", "Cabone", "Melbourne 3000 CBD Australia", 21.99f, 90, 0, "Doctor Dan","9/12/24"));
        
        
        //Axis Value should be between 0 min and 180 max
        //Check for invalid axis value less than 0 or greater than 180
        Assert.assertEquals(false, prescription.addPrescription(11,"Felix", "Raol", "Melbourne 3000 CBD Australia", 0, -20, 0, "Doctor Dan","9/12/24"));
        Assert.assertEquals(false, prescription.addPrescription(12,"Macroon", "Cabone", "Melbourne 3000 CBD Australia", 0, 190, 0, "Doctor Dan","9/12/24"));
        
        //Cylinder Value should be between -4 min and 4 max
        //Check for invalid cylinder value less than -4 or greater than 4
        Assert.assertEquals(false, prescription.addPrescription(13,"Felix", "Mitchell", "Melbourne 3000 CBD Australia", 0, 90, -10, "Doctor Dan","9/12/24"));
        Assert.assertEquals(false, prescription.addPrescription(14,"Macroon", "Cabone", "Melbourne 3000 CBD Australia", 0, 90,10, "Doctor Dan","9/12/24"));
        

        //Optometrist has to have 8 min and max 25 characters
        //check with invalid optometrist, less than min 8 or greater than max 25 characters
        Assert.assertEquals(false, prescription.addPrescription(5,"Sierra", "Raoly", "Melbourne 3000 CBD Australia", 0, 90, 0, "Dan","9/12/24"));
        Assert.assertEquals(false, prescription.addPrescription(6,"Felix", "Angelo", "Melbourne 3000 CBD Australia", 0, 90, 0, "Doctor SupermegaAwesomeguyforreal","9/12/24"));
        
        
    }


    @Test
    public void testAddRemark(){
        Prescription prescription = new Prescription();
        //check with Valid Inputs
        Assert.assertEquals(true, prescription.addRemark("This product is very good indeed for you.", "client"));
        Assert.assertEquals(true, prescription.addRemark("This product is not very good indeed for you.", "optometrist"));


        prescription = new Prescription(); // new prescription object is created as to reset count increment of remarks for the prescription

        //category can only accept Client or Optometrist
        //check with invalid data for category
        Assert.assertEquals(false, prescription.addRemark("This product is very good indeed for you.", "User"));
        Assert.assertEquals(false, prescription.addRemark("This product is not very good indeed for you.", "Pediatrician"));


        //Remark has to have 6 min and max 20 words
        //check with invalid Remark, less than min 6 or more than max 20 words
        Assert.assertEquals(false, prescription.addRemark("Bad", "client"));
        Assert.assertEquals(false, prescription.addRemark("This product is not very good indeed for you, atlest I am not re sure bout it any more, so try find something else", "optometrist"));


        //Remark has to have 6 min and max 20 words
        //check with valid Remark, with border exactly 6 and 20 characters
        Assert.assertEquals(true, prescription.addRemark("This product is not very good", "optometrist"));
        Assert.assertEquals(true, prescription.addRemark("This product is not very indeed for you, atlest I am not really sure bout it any more, so try", "optometrist"));

        prescription = new Prescription(); // new prescription object is created as to reset count increment of remarks for the prescription


        //The first letter of the the first work in Remark has to be capitalized
        //Check with invalid remark with the first letter not capitalized
        Assert.assertEquals(false, prescription.addRemark("this product is not very good, I don't like it", "client"));
        Assert.assertEquals(false, prescription.addRemark("this product is not very indeed for you, atlest I am not really sure, don't try", "optometrist"));

        //None of the parameters should work with an empty string
        //Check for invalid remark and category, using an empty sting
        Assert.assertEquals(false, prescription.addRemark("", "client"));
        Assert.assertEquals(false, prescription.addRemark("This product is not very good, don't buy it", ""));


    }

}
