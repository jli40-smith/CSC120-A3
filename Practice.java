public class Practice {
    public static void main(String[] args) {
        welcome(); 
        multiply(2,3); 
        multiply(5, 10); 
        divide(50, 10); 
        divide(6, 3); 
    }
    public static void welcome() {
        System.out.println("Welcome to our calculator!\n"); 
    }

    public static void multiply(int a, int b){
        System.out.println(a * b);
    }

    public static void divide(int a, int b){
        System.out.println(a/b); 
    }

}
