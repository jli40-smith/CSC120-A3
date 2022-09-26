import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
 * 
 */
public class Conversation {
  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    // You will start the conversation here 
      System.out.println("How many rounds of conversation would you like?"); 
      
      Scanner scan = new Scanner(System.in); 
      int conversationRounds = scan.nextInt();
      
      String[] transcript = new String[conversationRounds]; //Source [1]
      Arrays.fill(transcript, "");

      System.out.println("\nHi there! What's on your mind?\n");

      for(int i = 0; i < conversationRounds; i++) { 
        
        String userInput = scan.next(); //Source [4]
        userInput += scan.nextLine(); 

        String botResponse = mirrorWords(splitIntoWords(userInput)); 
        
        if(botResponse.equals(userInput)) {
          botResponse = selectCannedResponse(); 
        }
    
        System.out.println("\n" + botResponse + "\n"); 

        transcript[i] = userInput + "\n" + botResponse; 
      }
      scan.close();
      endConversation(transcript);

  }

/**
 * 
 * @param userInput
 * @return
 */
  public static String[] splitIntoWords(String userInput) {
    userInput = userInput.toLowerCase(); 
    String[] splitInput = userInput.split(" ", 0); 
    return splitInput; 
  }

/**
 * 
 * @param splitInput
 * @return
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
    
    if(splitInput[splitInput.length - 1].equals("I")) {
       splitInput[splitInput.length - 1] = "me"; 
    }
    
    String mirroredSentence = String.join(" ", splitInput); 
    
    return mirroredSentence; 

  }

/**
 * 
 * @return
 */

  public static String selectCannedResponse() {
    String[] cannedResponses = {
      "Could you reword that?",
      "I'm not sure I'm understanding you", 
      "Please elaborate on that!", 
      "If you don't stop spewing nonsense, I'll feel tempted to end our conversation early", 
      "Please speak in proper sentences!", 
      "Tell me even more!"
    };
/* Source [2] */
    Random random = new Random(); 
    int i = random.nextInt(cannedResponses.length); 
    return cannedResponses[i];  
  }

/**
 * 
 * @param transcript
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
