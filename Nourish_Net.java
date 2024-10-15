import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nourish_Net{

public static String[] foodList = new String[100];
public static String[] deliveryDate = new String[100];
public static String[] expirationDate = new String[100];

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to Nourish-Net!");
        System.out.println("This is the portal for RESTAURANTS and GROCERY STORES.");

                // Validation for num food items
        boolean validation1;
        int databaseSize;
        do{ 
        System.out.print("Please, enter the number of FOOD ITEMS for the database (Max 100) : ");
            databaseSize = scnr.nextInt();
        if ( databaseSize <= 100 && databaseSize > 0){
            validation1 = true;
        }
        else {
            System.out.println();
            System.out.println("Invalid value, please, try again.");
            System.out.println();
            validation1 = false;
        }
        } while (validation1 == false);{

        }

                // Sets food list to None
        for (int i = 0; i < databaseSize; ++i){ 
            
            foodList[i] = "N/A";
            
            deliveryDate[i] = "N/A";

            expirationDate[i] = "N/A";
        }


        
                //Menu Selection
        int menuOpt;
        do {
            System.out.println("MAIN MENU");
            System.out.println("0 - EXIT, 1 - ADD/UPDATE FOOD ITEM, 2 - SHOW FOOD LIST, 3 - DELETE FOOD ITEM, 4 - CLEAR LIST");
            System.out.print("Select an option : ");
            menuOpt = scnr.nextInt();
            System.out.println();
            if ( menuOpt == 0){
                System.out.println("Thank you for using Nourish-Net! Your food list will be sent out to the nearest food bank for distribution.");
                System.out.println();
                break;
            }
            else if (menuOpt == 1){
                addFoodItem();
            }
            else if ( menuOpt == 2){
                list(databaseSize);
            }
            else if ( menuOpt == 3){
                deleteItem();
            }
            else if ( menuOpt == 4){
                clearList(databaseSize);
            }
            else{
                System.out.println();
                System.out.println("Invalid value, please, try again.");
                System.out.println();
            }
        } while ( menuOpt != 0); {
        }

    }
    public static void addFoodItem(){
        Scanner scnr = new Scanner(System.in);
        boolean validation1;
        int itemNum;
        do{ 
        System.out.print("Enter the Food Item Number you want to Add/Update: ");
            itemNum = scnr.nextInt();
        if ( itemNum <= 100 && itemNum > 0){
            validation1 = true;
        }
        else {
            System.out.println();
            System.out.println("Invalid value, please, try again.");
            System.out.println();
            validation1 = false;
        }
        } while (validation1 == false);{
        }

        System.out.println("Food Item " + (itemNum) + ": " + foodList[itemNum - 1] + "     Expected Expiration Date: " + expirationDate[itemNum - 1] + "     Earliest Pickup Date: " + deliveryDate[itemNum - 1]);

        System.out.println("Enter your Food Item: ");
        String foodItem = scnr.nextLine();
        foodItem = scnr.nextLine();
        System.out.println();
        foodList[itemNum - 1] = foodItem;
        
        String inputDate;
        boolean validDate = false;

        // Define a regular expression pattern for MM/DD/YYYY format
        Pattern datePattern = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");

        while (!validDate) {
            System.out.print("Enter the Expected Expiration Date(MM/DD/YYYY): ");
            inputDate = scnr.nextLine();

            Matcher matcher = datePattern.matcher(inputDate);

            if (matcher.matches()) {
                // Input matches the pattern, now further validation can be done
                // For example, you can check if the month, day, and year are within valid ranges
                validDate = true;
                System.out.println("You entered a valid date: " + inputDate);
                expirationDate[itemNum - 1] = inputDate;
            } else {
                System.out.println("Invalid date format. Please enter a date in MM/DD/YYYY format.");
            }
        }

        String pickupDate;
        boolean validDate2 = false;

        // Define a regular expression pattern for MM/DD/YYYY format
        Pattern datePattern2 = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");

        while (!validDate2) {
            System.out.print("Enter the Earliest Pickup Date(MM/DD/YYYY): ");
            pickupDate = scnr.nextLine();

            Matcher matcher = datePattern2.matcher(pickupDate);

            if (matcher.matches()) {
                // Input matches the pattern, now further validation can be done
                // For example, you can check if the month, day, and year are within valid ranges
                validDate2 = true;
                System.out.println("You entered a valid date: " + pickupDate);
                deliveryDate[itemNum - 1] = pickupDate;
            } else {
                System.out.println("Invalid date format. Please enter a date in MM/DD/YYYY format.");
            }
        }
    
    }
    public static void list(int databaseSize){
        System.out.println("List of Food Items To Be Donated: ");
        int i;
        for(i = 0; i < databaseSize; ++i){
            System.out.println("Food Item " + (i + 1) + ": " + foodList[i] + "\t Expected Expiration Date: " + expirationDate[i] + "\t Earliest Pickup Date: " + deliveryDate[i]);
        }
    }
    public static void deleteItem(){
        Scanner scnr = new Scanner(System.in);
        

        boolean validation1;
        do{ 
        System.out.print("Enter the Food Item Number you would like to Delete: ");
            int itemDelete = scnr.nextInt();
        if ( itemDelete <= 100 && itemDelete > 0){
            validation1 = true;
            
            foodList[itemDelete - 1] = "N/A";
            deliveryDate[itemDelete - 1] = "N/A";
            expirationDate[itemDelete - 1] = "N/A";
            
            System.out.println("Food Item at " + itemDelete + " Deleted.");
        }
        else {
            System.out.println();
            System.out.println("Invalid value, please, try again.");
            System.out.println();
            validation1 = false;
        }
        } while (validation1 == false);{
        }
    }
    public static void clearList(int databaseSize){
        for (int i = 0; i < databaseSize; ++i){ 
            
            foodList[i] = "N/A";
            deliveryDate[i] = "N/A";
            expirationDate[i] = "N/A";
        }
        System.out.println("Cleared Food List");
        System.out.println();     
    }
}