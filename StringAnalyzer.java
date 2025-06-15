// In this assignment, a string analyzer program was created that works according to the input entered by the user.
import java.util.Scanner;
public class StringAnalyzer {
/** Main method */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitProgram = false;
        System.out.println("Welcome to our String Analyzer Program.");
        while (!exitProgram) {
        	// Outputs for menu options.
        System.out.println("1. Count number of chars");
        System.out.println("2. Print the words in a sentence");
        System.out.println("3. Delete substring");
        System.out.println("4. Replace substring");
        System.out.println("5. Sort Characters");
        System.out.println("6. Hash code of a string");
         // Prompt the user to choose menu.
        System.out.println("Please enter your menu choice: ");
       String choice = input.next();

        switch (choice.toLowerCase()) {
            case "1":
            	// Prompt the user to enter string.
                System.out.print("Enter an input string: ");
                String str = input.next();
                // Prompt the user to enter char.
                System.out.print("Enter an input char: ");
                char ch = input.next().charAt(0);
                int result = numOfChars(str, ch);
                System.out.println("The number of " + ch + " in " + str + " is " + result + ".");
                break;

            case "2":
            	// Prompt the user to enter string.
                System.out.print("Enter an input string: ");
                input.nextLine(); // The newline character is printed.
                String str1 = input.nextLine();
                printWords(str1);
                break;

            case "3":
            	// Prompt the user to enter string.
                System.out.print("Enter an input string: ");
                input.nextLine(); // The newline character is printed.
                String str2 = input.nextLine();
                // Prompt the user to enter a substring
                System.out.print("Enter a substring to delete: ");
                String subStringToDelete = input.nextLine();
                System.out.print("Enter type: ");
                int deleteType = input.nextInt();
                String resultStr = delete(str2, subStringToDelete, deleteType);
                System.out.println("Updated string: " + resultStr);
                break;
            case "4":
            	// Prompt the user to enter string.
            	System.out.print("Enter an input string: ");
            	input.nextLine();
            	String str4 = input.nextLine();
            	// Prompt the user to enter first substring
            	System.out.print("Enter the first substring: ");
                String subStr1 = input.nextLine();
                // Prompt the user to enter second substring
                System.out.print("Enter the second substring: ");
                String subStr2 = input.nextLine();
                String replacedString = replace(str4, subStr1, subStr2);
                System.out.println("Output: " + replacedString);
                break;
            case "5":
            	// Prompt the user to enter string.
            	 System.out.print("Enter an input string: ");
                 input.nextLine(); 
                 String str5 = input.nextLine();
                 System.out.print("Enter a type: ");
                 int sortType = input.nextInt();
                 String sortedString = sortChars(str5, sortType);
                 System.out.println("Output: " + sortedString);
                 break;	
            case "6":
            	// Prompt the user to enter string.
            	System.out.print("Enter an input string: ");
            	input.nextLine();
                String str6 = input.nextLine();
                // Prompt the user to enter a value for b.
                System.out.print("Enter a value for b: ");
                int b = input.nextInt();
                int hashCodeResult = hashCode(str6, b);
                System.out.println("The hash code for " + str6 + " is " + hashCodeResult + ".");
                break;
           
            case "exit":
            case "quit":
            exitProgram = true;
            System.out.println("Program ends. Bye :)");
            break;
            
            default:
                System.out.println("Invalid choice. Choose a valid option. ");
        }
    }
    }
    // The aim of this method to count the number of occurrences of character.
    public static int numOfChars(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
      // The purpose of this method is to write words on separate lines.
    public static void printWords(String str) {
        System.out.println("Words in the sentence: ");
        for (char ch : str.toCharArray()) {
            if (Character.isWhitespace(ch) || ",!_().?-".indexOf(ch) != -1) {
                System.out.println();
            } else {
                System.out.print(ch);
            }
        }
        System.out.println();
    }
    // The purpose of this method is to delete a specific substring in a specific sentence.
    public static String delete(String str, String subStr, int type) {
       if(str == null || subStr ==null) {
    	   return str;
        }
       int index;
       if (type == 0) {
    	   index = str.indexOf(subStr);
    	   if (index != 0) {
    		   return str.substring(0, index) + str.substring(index + subStr.length());
    	   }
       }
       else if (type == 1) {
   		int lastIndex = 0;
   		index = str.indexOf(subStr , lastIndex);
   		while (index != -1) {
   			str = str.substring(0, index) + str.substring(index + subStr.length());
   			lastIndex = index;
   			index = str.indexOf(subStr , lastIndex);
   		}
   	}
   	return str;
   }
    // The purpose of this method is to replace a specific substring with a specific substring.
    public static String replace(String str, String subStr1, String subStr2) {
    	int index = str.indexOf(subStr1);
    	while (index >=0) {
    		str = str.substring(0, index) +subStr2 + str.substring(index + subStr1.length());
    	index = str.indexOf(subStr1, index + subStr2.length());
    	}
    	return str;
    }
    // The purpose of this method is to ensure that characters are sorted according to a certain sorting type.
    public static String sortChars(String str, int type) {
        if (type == 0) {
            char[] list = str.toCharArray();
             for (int i=0; i<list.length; i++) {
            	 char currentchar = list[i];
            	 int currentcharindex = i;
            	 for (int j=i+1;j<list.length;j++) {
            		 if (currentchar> list[j]) {
            			 currentchar = list[j];
            			 currentcharindex = j;
            		 }
            	 }
            	 if (currentcharindex != i) {
            		 list[currentcharindex] = list[i];
            		 list[i] = currentchar;
            	 }
             }
       
             return new String(list);
        } else if (type == 1) {
            String lowerCase = "", upperCase = "", digits = "", others = "";

            for (char ch : str.toCharArray()) {
                if (Character.isLowerCase(ch)) {
                    lowerCase += ch;
                } else if (Character.isUpperCase(ch)) {
                    upperCase += ch;
                } else if (Character.isDigit(ch)) {
                    digits += ch;
                } else {
                    others += ch;
                }
            }
            return lowerCase + upperCase + digits + others;
        }
        return str;
    }
    // This method allows calculating the code using an algorithm.
 public static int hashCode(String str , int  b) {
	 int hashCode = 0;
	 int j = str.length();
	 for (int i = 0; i < j; i++) {
		 hashCode += str.charAt(i) * power(b, j - 1 - i);
	 }
	 return hashCode;
 }
 public static int power(int n , int exponent) {
	 int result = 1;
	 for (int i =0; i < exponent; i++) {
		 result *= n;
	 }
	 return result;
 }
}