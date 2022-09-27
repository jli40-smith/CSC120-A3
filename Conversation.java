import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
 * Receives and responds to user-inputted Strings for set number of rounds.
 * Records and prints a transcript of the dialogue.
 * 
 * @author Joanna Li 
 * @see #main(String[])
 */
public class Conversation {
  /**
   * Queries user for the rounds of conversation desired and 
   * prints canned or mirrored responses to user input.
   * 
   * Adds dialogue to a transcript of the conversation which is printed when method terminates.
   * 
   * The number of inputs requested should be an integer.
   * 
   * @param args String array with command-line arguments
   */
  public static void main(String[] args) {
      System.out.println("How many rounds of conversation would you like?"); 
      Scanner scan = new Scanner(System.in);
      
      int conversationRounds = scan.nextInt();
      
      String[] transcript = new String[conversationRounds + 1]; //Source [1]

      Arrays.fill(transcript, "");
      System.out.println("\nHi there! What's on your mind?\n");

      for(int i = 0; i < conversationRounds; i++) { 
        String userInput = scan.next(); //Source [3]
        userInput += scan.nextLine();

        String botResponse = mirrorWords(splitIntoWords(userInput));
        
        if (botResponse.equalsIgnoreCase(userInput)) {
          botResponse = selectCannedResponse(); 
        }
    
        System.out.println("\n" + botResponse + "\n"); 

        transcript[i] = userInput + "\n" + botResponse; 
      }

      transcript[conversationRounds] = "It was nice talking with you, Goodbye!";

      scan.close();
      endConversation(transcript);

  }

/**
 * Splits sections of user input separated by whitespace
 * into individual strings
 * 
 * @param userInput String that user types into the console
 * @return String array storing split-up sections of user input
 */
  public static String[] splitIntoWords(String userInput) {
    userInput = userInput.toLowerCase(); 

    String[] splitInput = userInput.split(" ", -1); 
    return splitInput; 
  }

/**
 * Replaces selected strings with "mirrored" String replacements
 * 
 * @param splitInput String array for which String element is compared to "mirrorable" words and replaced with 
 * "mirrored" replacements if a match is found
 * @return String produced by joining the elements of splitInput with whitespace in between
 */
  public static String mirrorWords(String[] splitInput) {
    for (int i = 0; i < splitInput.length; i++) {

      if (splitInput[i].equals("i") ||
          splitInput[i].equals("me")) {
            splitInput[i] = "you"; 
      
      } else if (splitInput[i].equals("you")) {
        splitInput[i] = "I"; 
      
      } else if (splitInput[i].equals("am")) {
        splitInput[i] = "are"; 
      
      } else if (splitInput[i].equals("are")) {
        splitInput[i] = "am"; 
      
      } else if (splitInput[i].equals("my")) {
        splitInput[i] = "your"; 
      
      }else if (splitInput[i].equals("your")) {
        splitInput[i] = "my"; 
      }

    }
    
    if (splitInput[splitInput.length - 1].equals("I")) {
       splitInput[splitInput.length - 1] = "me"; 
    }
    
    String mirroredSentence = String.join(" ", splitInput); 

    return mirroredSentence; 

  }

/**
 * Randomly selects and returns a canned response String
 * 
 * @return String representing a canned conversation response
 */

  public static String selectCannedResponse() {
    String[] cannedResponses = {
      "Could you reword that?",
      "I'm not sure I'm understanding you", 
      "Please elaborate on that!",
      "Please speak in proper sentences!", 
      "Mmhm",
      "Tell me even more!"
    };

    Random random = new Random(); //Source [2]
    
    int i = random.nextInt(cannedResponses.length); 
    
    return cannedResponses[i];  
  }

/**
 * Prints transcript of conversation
 * 
 * @param transcript [] String array containing rounds of conversation dialogue 
 */

  public static void endConversation(String[] transcript) { 
    System.out.println("\nIt was nice talking with you, Goodbye!\n"); 
    System.out.println("***TRANSCRIPT***"); 

      for(int i = 0; i < transcript.length; i++) {
        System.out.println("\n" + transcript[i]);
      }
      
    System.out.println("\n***************");

  }

}