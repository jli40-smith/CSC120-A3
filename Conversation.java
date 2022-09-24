import java.util.Scanner; 

public class Conversation {
  public static void main(String[] args) {
    // You will start the conversation here 
      System.out.println("How many rounds of conversation would you like?"); 
      
      Scanner scan = new Scanner(System.in); 
      int conversationRounds = scan.nextInt();
      
      for(int i = 0; i < conversationRounds; i++) {
        System.out.println("Chat with me:"); 
        
        String userInput = scan.next(); 
        userInput += scan.nextLine(); 
        System.out.println(userInput); 
      }
      System.out.println("Goodbye!"); 
  }

} 
