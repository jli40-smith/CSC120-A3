import java.util.Scanner; 

import java.util.Arrays;

public class Conversation {
  public static void main(String[] args) {
    // You will start the conversation here 
      System.out.println("How many rounds of conversation would you like?"); 
      
      Scanner scan = new Scanner(System.in); 
      int conversationRounds = scan.nextInt();
      
      String[] transcript = new String[conversationRounds];
      Arrays.fill(transcript, "");

      for(int i = 0; i < conversationRounds; i++) {
        System.out.println("\nHi there! What's on your mind?\n"); 
        
        String userInput = scan.next(); 
        userInput += scan.nextLine(); 

        String botResponse = userInput + "-Bot"; //THIS IS WHERE TO ADD THE OUTPUT OF THE Mirror Words  
        System.out.println("\n" + botResponse); 

        transcript[i] = userInput + "\n" + botResponse; 
      }
      endConversation(transcript);

  }

  public static void endConversation(String[] transcript) { 
    System.out.println("\nIt was nice talking with you, Goodbye!\n"); 

      System.out.println("***TRANSCRIPT***"); 
      for(int i = 0; i < transcript.length; i++) {
        System.out.println("\n" + transcript[i]);
      }
      System.out.println("\n***************");
  }

  public static String sendCannedResponse() {
    String[] cannedResponses = {"Could you reword that?", "I'm not sure I'm understanding you", "Please elaborate on that!", "Tell me even more!"}
    
    return String botResponse; 
  }

} 
