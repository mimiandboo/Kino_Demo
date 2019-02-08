/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.projects;

import java.util.*;                               //imports java Scanner for Scanner object
import java.text.DecimalFormat;                         //imports Decimal Format used in displayArrays method

/**
 *
 * @author Mia Benedek
 * Email: BenedekMia@gmail.com
 */
public class Kino_Demo {
    ArrayList<String> shoppingList = new ArrayList<String>();
    
    public static String[] shoppingArray = new String[100];
                                                        //creates a public static String array shoppingArray[]
    public static double[] shoppingPriceArray = new double[100];
                                                        //creates a public static double array shoppingPriceArray[]
    /*-----------------------------------------------------------------------*/ 
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);          //creates a scanner object named scan
        char choice = '0';                              //new variable int choice
        
        String[] booksArray = {"Intro to Java", "Intro to C++", "Python", "Perl", "C#"};
                                                        //new string array booksArray with book names
        /*-----------------------------------------------------------------------*/
        
        double[] booksPrice = {45.99, 89.34, 100.00, 25.00, 49.99};
                                                        //new double array booksPrice with prices of books                                                                
        /*-----------------------------------------------------------------------*/ 
        
        sort(booksArray, booksPrice);                   //sorts the booksArray and booksPrice arrays in order from least to greatist
        
        while(choice != '9'){                           //while loop
            displayMenu();                              //displays menu method
            choice = scan.next().charAt(0);             //user input is saved into choice
                                                        //*note: should change to scan.next() instead of int*
        /*-----------------------------------------------------------------------*/                                                
            switch(choice){                             //start of switch case
                case '1':                               //if choice == 1
                    displayArrays(booksArray, booksPrice, "Books");
                                                        //displayArrays() method is used for Books
                    System.out.println("\n");           //prints out two lines
                    break;
                    
                case '2':                               //if choice == 3
                    getInventoryNumber(booksArray, booksPrice, "Book");
                                                        //getInventoryNumber() method is used for books
                    break;

                case '3':                               //if choice == 5
                    displayArrays(shoppingArray, shoppingPriceArray, "Cart");
                                                        //displayArrays() method is used for cart array
                    break;
                case '4':                               //if choice == 6
                    getTotal();                         //getTotal() method is called to check the user out
                    break;
                case '5':                               //if choice == 7
                    clearArrays();                      //clearArrays() method is called to clear the arrays
                    break;
                case '6':                               //if choice == 9
                    break;
                default:                                //if choice != 1-7 | 9
                    System.out.println("This option is not acceptable.\n");
                                                        //default error code
            }
    /*-----------------------------------------------------------------------*/
        }                                               //end of while loop
    /*-----------------------------------------------------------------------*/ 
    
    
    //once user input choice == 9, prompt below is shown
    System.out.println("\nThank you for shopping with us today.\n"
            + "We hope to see you again soon!");
       
    System.out.println();                           //prints a new line
    }
    /*-----------------------------------------------------------------------*/
    //sort(String[], double[]) sorts the Arrays in ascending order
    public static void sort(String[] itemsArray, double[] pricesArray){
        double temp;                                    //new double variable temp
        String foo;                                     //new String variable foo
        
        for(int i = 0; i < itemsArray.length; i++){     //for loop for sorting pricesArray in ascending order
            for(int j = i + 1; j < itemsArray.length; j++){
                if(pricesArray[i] > pricesArray[j]){    //if statement
                    //for double price array
                    temp = pricesArray[i];
                    pricesArray[i] = pricesArray[j];    //i and j switch if i > j
                    pricesArray[j] = temp;
                    
                    //for String name array
                    foo = itemsArray[i];
                    itemsArray[i] = itemsArray[j];      //String names at i and j switch if i > j
                    itemsArray[j] = foo;
                } //end of if statement
            }
        } //end of for loop
    } //end of sort()
    /*-----------------------------------------------------------------------*/
    //displayMenu() method designed to display selection menu for users
    public static void displayMenu(){
        System.out.println("**Welcome to Kinokuniya bookstore!**\n");
        System.out.println("Choose from the following options:");
        System.out.println("1 - Browse books inventory (price low to high)");
        System.out.println("2 - Add a book to the cart");
        System.out.println("3 - View cart");
        System.out.println("4 - Checkout");
        System.out.println("5 - Cancel order");
        System.out.println("6 - Exit store\n");
    } //end of displayMenu()
    /*-----------------------------------------------------------------------*/
    //displayArrays(String[], double[], String) method designed to display the arrays
    //of the item selected (either menu choice 1 or 2)
    public static void displayArrays(String[] itemsArray, double[] pricesArray, String itemType){
        DecimalFormat df = new DecimalFormat("#.00");   //decimal format for two decimal spaces
        
        //displays arrays from choices 1 and 2 (Book and DVD arrays)
        if(itemType.equals("Books")){
            //header format
            System.out.println("\nInventory Number\t"+ itemType +"\t\t\tPrices");
            //for loop to print out the "----.."
            for(int j = 0; j < 56; j++){
                System.out.print("-");                  //prints '-'
            } //end of for loop
        
            System.out.print("\n");                     //prints out two new lines
        
            for(int i = 0; i < itemsArray.length; i++){ //for loop for printing out inventory #, item name array
                                                        //and prices array in ascending order
                System.out.printf("%-23d %-20s %-3s %6s %n", i + 1, itemsArray[i], "$", df.format(pricesArray[i]));
            } //end of for loop
        } //end of if statement
        /*-----------------------------------------------------------------------*/
        //displays array from choice 5 (shopping cart array)
        else if(itemType.equals("Cart")){
            
            
            System.out.println();                       //prints a new line
            
            //if array is empty, tell customer cart is empty
            if(itemsArray[0] == null){
                    System.out.println("Your cart is empty.\n\n");
            } //end of if
            
            else{
                //header format
                System.out.println("Items\t\tPrices");
                
                //for loop to print out the "----.."
                for(int j = 0; j < 23; j++){
                    System.out.print("-");              //prints '-'
                } //end of for loop
                
                System.out.println();                   //prints out new line
                
                //for loop to display cart array
                for(int i = 0; i < itemsArray.length; i++){
                    if(itemsArray[i] == null){          //to check to see if the item at i is null
                                                        //if null, terminate for loop
                        i += itemsArray.length;         //adds length of array to make sure loop is terminated
                    } //end of if statement
                    else{
                        System.out.printf("%-13s %-1s %6s", itemsArray[i], "$",  df.format(pricesArray[i]));
                        System.out.println();           //prints out new line
                    } //end of else statement
                } //end of for loop
                System.out.println("\n\n");             //prints 3 new line
            } //end of else   
        } //end of else if statement
        /*-----------------------------------------------------------------------*/
        else{                                           //printed if code fucks up
            System.out.println("Command not recognized. Please try again.\n\n");
        } //end of else statement
    } //end of displayArrays()
    /*-----------------------------------------------------------------------*/
    //getInventoryNumber(String[], double[], String) asks user to input a inventory number
    //then adds the item to the shopping cart
    public static void getInventoryNumber(String[] itemsArray, double[] pricesArray, String itemType){
        int userInput;                                  //new integer variable userInput
        Scanner scan = new Scanner(System.in);          //creates a scanner object named scan
        
        //prompts user to enter an inventory number
        System.out.println("What is the inventory number of the item you'd like to purchase?");
        userInput = scan.nextInt();                     //user input is saved into userInput
        
        String name;                                    //new String variable name
        double price;                                   //new double variable price
        
        //userInput must be less than itemsArray length
        if(userInput < itemsArray.length){
            //for loop to add a new item to the shopping cart array
            for(int i = 0; i < shoppingArray.length; i++){
                if(shoppingArray[i] == null){           //if shopping array area is null, then add them into the null space
                    shoppingArray[i] = itemsArray[userInput - 1];
                                                        //adding String name to shopping cart from itemsArray
                    shoppingPriceArray[i] = pricesArray[userInput - 1];
                                                        //adding double price to shopping cart from pricesArray
                    i += 100;                           //if found, to end for loop, add 100
                
                    System.out.println(itemType + " " + "\"" + itemsArray[userInput - 1] + "\"" + " has been added to the cart!\n\n");
                                                        //prints out what item has been added to the cart
                } //end of if statement
            } //end of for loop
        } //end of if
        
        //else will output error message if userInput is out of bounds
        else{
            System.out.println("This option is unavailable.\nPlease try again.\n\n");
        } //end of else
        
    } //end of getInventoryNumber()
    /*-----------------------------------------------------------------------*/
    //clearArrays(String[], double[]) clears the array called
    public static void clearArrays(){
        //for loop to clear the whole array
        for(int i = 0; i < shoppingArray.length; i++){
            shoppingArray[i] = null;                    //sets each itemsArray[i] to null
            shoppingPriceArray[i] = 0;                  //sets each pricesArray[i] to 0
        } //end of for loop
        
        //prints out a statement to inform user's cart has been cleared
        System.out.println("Your shopping cart has been cleared!\n\n");
    } //end of clearArrays()
    /*-----------------------------------------------------------------------*/
    //getTotal() prints the total + 8.25% tax from the shoppingPriceArray (shopping cart)
    public static void getTotal(){
        double total = 0;                               //new double variable total
        DecimalFormat df = new DecimalFormat("#.00");   //decimal format for two decimal spaces
        
        //if the cart is empty, output message saying cart is empty
        if(shoppingArray[0] == null){
            System.out.println("Shopping cart is empty.\nPlease place an item in cart before checking out.\n\n");
        } //end of if
        
        //else cart is not empty
        else{
            //adds all prices in the array to find total
            for(int i = 0; i < shoppingPriceArray.length; i++){
                total += shoppingPriceArray[i];         //adds to total
            } //end of for loop
        
            total += total*(.0825);                     //calculates total + 8.25% tax
            
            //prints out total
            System.out.println("Total:\t$ " + df.format(total) + "\n");
            //prints out a respectful message
            System.out.println("Thank you for shopping with us today!\n\n");
        
            clearArrays();                              //clears arrays after purchase
        } //end of else
    } //end of getTotal()
}
