import java.util.Scanner; 

import java.util.ArrayList;

public class Conversation {
  public static void main(String[] args) {
    // You will start the conversation here 
      System.out.println("How many rounds of conversation would you like?"); 
      
      Scanner scan = new Scanner(System.in); 
      int conversationRounds = scan.nextInt();
      
      ArrayList<String> transcript =  new ArrayList<String>();

      for(int i = 0; i < conversationRounds; i++) {
        System.out.println("\nHi there! What's on your mind?\n"); 
        
        String userInput = scan.next(); 
        userInput += scan.nextLine(); 

        String botResponse = userInput; 

        transcript.add(userInput); 
        transcript.add()

        System.out.println(botResponse); 
      }
      System.out.println("\nIt was nice talking with you, Goodbye!\n"); 
      System.out.println("********CONVERSATION TRANSCRIPT********");
  
      System.out.println(transcript);
  }

} 
