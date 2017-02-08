import java.util.Scanner;

public class DigitsToWords {

    //Instance variables [array] for words.
    
    public static String[] units = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public static String[] tens = {"Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fiftenn", "Sixteen", "Seventeen",
        "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String hundred = "Hundred";
    public static String thousand = "Thousand";
    
    //Input variable of user.
    int input;
    private static String ans; //To store the answer.
            
    public static void main(String[] args) {
        //Starting the digitToWords method or simply executing the program.  
        digitToWord();
    }
    
    
    private static void digitToWord() {
        //Taking user input from the input method.
        String input = input(""); //Parametr is Empty because it is used only for syntax.
        int input_int = Integer.parseInt(input);
        
        for(int i=0; i<input.length(); i++){
            if(input.length() == 1){
                System.out.println(unitMethod(input));
                break;
            }else if(input.length() == 2){
                System.out.println(tensMethod(input));
                break;
            }else if(input.length() == 3){
                System.out.println(hundredMethod(input));
                break;
            }else if((input.length() >= 4) && (input.length() <=6 )){
                System.out.println(thousandMethod(input)); 
                break;
            }
        }
        
    }

    public static String unitMethod(String n){
		//Taking only the character of unit place.
        String unit = n.substring(0);
		//Initializing the character of unit place.
        int int_ans = Integer.parseInt(unit);
		//A/c to digit(input), extracting the words(from elements of array unit). 
        for(int i=0; i < 10; i++){
            if(int_ans == i){
                ans = units[i];
                break;
            }
        }
		//Returning the Strings(word) of input(digit).
        return ans;
    }
    
    public static String tensMethod(String n) {
        //Taking out the ten place digit of user input
        char tenPlace = n.charAt(0);
        //Taking out the remaining string(digits) of user input
        String unit = n.substring(1);
       
        //Coverting char to int.
        int int_ten = Character.getNumericValue(tenPlace);
        //Converting string(All the digits) in integer.
        int int_ans = Integer.parseInt(n);
        
        //Looping & checking the conditions to convert digits to string
        for(int i =0; i < tens.length; i++){
            
            if(tenPlace == '0'){
                ans = unitMethod(unit);
                break;
            }
            
            /*
            if the string(digits or input of user) is less then 20
            it should follow the following conditions because in arrary; tens, 
            below 9 elements of array; tens; have unique words. Example 'twelve', 'fourteen', 'ten', etc
            Above 9 elements have of array tens follow the similar word for ten's places
            Example: 'forty-four', 'forty-nine', 'ninety', 'ninety-six', etc
            */
            
            if(int_ans < 20 && int_ans == i + 10){ //There is increment of 10 in i to compare with
                //the value of user input. Eg: if i=6 & user-input = 16, but i != user-input that is
                //6 != 16 but incrementing 10 on i. We get. i(6+10) == user-input(16).
                ans = tens[i];
                break;
            }else{
                /*
                If the user input is above 19 then the words starts to have comman word in its ten place
                Eg: if the user-input = 67 then the ten's place of 67 is 6 which is equivalent to sixty.
                */
                if(int_ten == 2){
                    ans = tens[10] + "-" +unitMethod(unit); //The unitMethod() is used for the unit place.
                    break;
                }else if(int_ten ==3){
                    ans = tens[11]+ "-" +unitMethod(unit);
                    break;
                }else if(int_ten == 4){
                    ans = tens[12]+ "-" +unitMethod(unit);
                    break;
                }else if(int_ten == 5){
                    ans = tens[13]+ "-" +unitMethod(unit);
                    break;
                }else if(int_ten == 6){
                    ans = tens[14]+ "-" +unitMethod(unit);
                    break;
                }else if(int_ten == 7){
                    ans = tens[15]+ "-" +unitMethod(unit);
                    break;
                }else if(int_ten == 8){
                    ans = tens[16]+ "-" +unitMethod(unit);
                    break;
                }else if(int_ten == 9){
                    ans = tens[17]+ "-" +unitMethod(unit);
                    break;
                }
            }
        }
        //Returning the the strings(words of digit place of ten).
        return ans;
    }
    
    public static String hundredMethod(String n){
		//Taking out the string(digit) of hundred places and initializing to variable.
        String hundredPlace = n.substring(0, 1);
		//Taking out the remaining string(digit)-(that is ten place) and initializing to variable
        String tenPlace = n.substring(1);
		
		//If the 100th place is 0 then calling the tensMethod() method.
        if(Integer.parseInt(hundredPlace) == 0){
            ans = (tensMethod(tenPlace));
        }else{//Calling the unitMethod() for unit place and tensMethod() for 10th place.
            ans = (unitMethod(hundredPlace) + " " + hundred + " and " + tensMethod(tenPlace));
        }
		
		//Returning the string(words) of given input(digit/string).
        return ans;
    }
    
    public static String thousandMethod(String n){
		//Taking out the 1000th place digit(string) and initializing it.
        String thousandPlace = n.substring(0, 1);  
		//Taking out the 100th place digit(string) and initializing it.	
        String hundredPlace = n.substring(1);
		//Taking out the 10th place digit(string) nad initializing it.
        String tenPlace = n.substring(2);
		//Initializing the variable to check whether the 100th place is zero.
        String checkHundredPlace = n.substring(1,2);
        
        if(Integer.parseInt(thousandPlace) == 0){//Calling the hundredMethod() if the 1st digit of 100th place is zero.
            ans = hundredMethod(hundredPlace);
        }//calling the tensMethod if 100th and 1000th places is equal to zero.
		else if((Integer.parseInt(checkHundredPlace) == 0) && (Integer.parseInt(thousandPlace) == 0)){
            ans = tensMethod(tenPlace);
        }else if(n.length() == 5){//To check and return having 5 number of digits. Example: 23456
            //Taking out ten's place of 1000 and initializing. Example: (23)456.
			String twoDigitPlaceOfThousand = n.substring(0,2);
            //Taking out the 100th place and initializing. Example: 23(456).
			hundredPlace = n.substring(2);
			//calling teh appropriate method to convert digits to string.
            ans = (tensMethod(twoDigitPlaceOfThousand) + " " + thousand + "," + hundredMethod(hundredPlace));
        }else if(n.length() == 6){//To Check and return having 6 number of digits. Example: 120060
            //Taking out the hundred's place of 1000 and initializing. Example: (120)060.
			String threeDigitPlaceOfThousand = n.substring(0,3);
			//Taking the 100th place and initializing. Example: 120(060).
            hundredPlace = n.substring(3);
			//calling teh appropriate method to convert digits to string.
            ans = (hundredMethod(threeDigitPlaceOfThousand) + " " + thousand + "," + hundredMethod(hundredPlace));
        }
		//returning the words(string) of digits(input-String).
        return ans;
    }
    
	//Method for taking input.
    public static String input(String n){
        System.out.println("Enter the digit(s): ");
		//Create a Scanner object to read input.
        Scanner in = new Scanner(System.in);
		//Initializing the variable to user input.
        String usr_input = in.nextLine();
        //returnig the value of input.
        return usr_input;
    }
   
}
