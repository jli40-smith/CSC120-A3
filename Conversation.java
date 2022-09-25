import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Conversation {
  public static void main(String[] args) {
    // You will start the conversation here 
      System.out.println("How many rounds of conversation would you like?"); 
      
      Scanner scan = new Scanner(System.in); 
      int conversationRounds = scan.nextInt();
      
      String[] transcript = new String[conversationRounds];
      Arrays.fill(transcript, "");

      System.out.println("\nHi there! What's on your mind?\n");

      for(int i = 0; i < conversationRounds; i++) { 
        
        String userInput = scan.next(); 
        userInput += scan.nextLine(); 


        String botResponse = mirrorWords(splitIntoWords(userInput)); //RUN THE RESPOND method here later! 
        System.out.println("\n" + botResponse + "\n"); 

        transcript[i] = userInput + "\n" + botResponse; 
      }
      endConversation(transcript);

  }

  public static String[] splitIntoWords(String userInput) {
    String[] splitInput = userInput.split(" ", 0); 
    return splitInput; 
  }

  public static String mirrorWords(String[] splitInput) {
    for (int i = 0; i < splitInput.length; i++) {

      if (splitInput[i].equals("I") ||
          splitInput[i].equals("i") ||
          splitInput[i].equals("Me") ||
          splitInput[i].equals("me")) {
        splitInput[i] = "you"; 
      
      } else if (splitInput[i].equals("You") ||
          splitInput[i].equals("you")) {
        splitInput[i] = "I"; 
      
      } else if (splitInput[i].equals("Am") ||
          splitInput[i].equals("am")) {
        splitInput[i] = "are"; 
      
      } else if (splitInput[i].equals("Are") ||
          splitInput[i].equals("are")) {
        splitInput[i] = "am"; 
      
      } else if (splitInput[i].equals("My") ||
          splitInput[i].equals("my")) {
        splitInput[i] = "your"; 
      
      }else if (splitInput[i].equals("Your") ||
          splitInput[i].equals("your")) {
        splitInput[i] = "my"; 
      }
    }

    String mirroredSentence = String.join(" ", splitInput); 
    return mirroredSentence; 

  }

/* 
  public static String findAndReplace(String input, String find, String replace) {
    if (input.equals(find)) {
      input = replace; 
      return input; 
    }
  }
*/

  public static String sendCannedResponse() {
    String[] cannedResponses = {
      "Could you reword that?",
      "I'm not sure I'm understanding you", 
      "Please elaborate on that!", 
      "Tell me even more!"
    };

    Random random = new Random(); 
    int i = random.nextInt(cannedResponses.length); 
    return cannedResponses[i];  
  }

  
  public static void endConversation(String[] transcript) { 
    System.out.println("\nIt was nice talking with you, Goodbye!\n"); 

      System.out.println("***TRANSCRIPT***"); 
      for(int i = 0; i < transcript.length; i++) {
        System.out.println("\n" + transcript[i]);
      }
      System.out.println("\n***************");
  }

} 
