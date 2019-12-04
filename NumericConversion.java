import java.util.*;
// Testing github update. HI!!!!
public class NumericConversion {

    // Returns the base 16 value of a series of characters
    public static Long hexStringDecode(String hex){
        String newHex = hex;
        // Determines if the user is using the hex notation
        if(hex.substring(0,2).equals("0x")){
            newHex = hex.substring(2);
        }
        Long decimalValue = 0L;
        int hexLen = newHex.length()-1;
        // Loops through the string
        for(int i = 0; i < newHex.length(); i++){
            // Adds value of each character to the total
            decimalValue += (Long) Math.round(Math.pow(16 , hexLen)) * NumericConversion.hexCharDecode(newHex.charAt(i));
            hexLen--;
        }
        return decimalValue;
    }


    // Returns the base 16 value of a single character
    public static short hexCharDecode(char Digit){
        char digitLow = Character.toLowerCase(Digit);
        // Finds what the value of the character is in base 16
        switch(digitLow){
            case 'a':
                return 10;
            case 'b':
                return 11;
            case 'c':
                return 12;
            case 'd':
                return 13;
            case'e':
                return 14;
            case 'f':
                return 15;
            default:
                String digitStr = Character.toString(digitLow);
                return (short)Integer.parseInt(digitStr);
        }
    }
    // returns a decimal value of a binary number
    public static short binaryStringDecode(String binary){
        String newBinary = binary;
        // checks if user is using binary notation
        if(binary.substring(0,2).equals("0b")){
            newBinary = binary.substring(2);
        }
        short binaryValue = 0;
        int binaryLength = newBinary.length() - 1;
        // loops through the binary string
        for(int i = 1;i < newBinary.length() + 1;i++){
            // Gets the 0 or 1 from the current index in the string
            int currentDigit = Integer.parseInt(newBinary.substring( i - 1 ,i));
            // multiplies the 0 or one by the corresponding power of 2
            binaryValue += (short) Math.pow(2 , binaryLength) * currentDigit;
            // DEBUG
            /*System.out.println("current digit is: "+currentDigit);
            System.out.println("total value is: "+binaryValue);*/
            binaryLength--;
        }
        return binaryValue;
    }
    public static void printMenu(){
        //Prints menu
        System.out.println("\nDecoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");
    }

    public static void main(String[] args){
        boolean convert = true;
        // Initializes scanner
        Scanner scr = new Scanner(System.in);

        while(convert){
            //Prints menu
            NumericConversion.printMenu();
            System.out.print("Please enter an option: ");
            // Gets user input
            int choice = scr.nextInt();
            String userInput = "";
            switch(choice){
                // Gets hex string from user and prints the decimal value
                case 1:
                    System.out.print("Please enter the numeric string to convert: ");
                    userInput = scr.next();
                    System.out.println("Result: "+NumericConversion.hexStringDecode(userInput));
                    break;
                // Gets binary string from user and prints the decimal value
                    case 2:
                    System.out.print("Please enter the numeric string to convert: ");
                    userInput = scr.next();
                    System.out.println("Result: "+NumericConversion.binaryStringDecode(userInput));
                    break;
                case 3:
                    break;
                // exits loop if the user enters any value >3 or <1
                default:
                    convert = false;
                    System.out.println("Goodbye!");
                    break;
            }


        }
    }
}
