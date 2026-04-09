import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        

        String correctUsername = "admin";
        String correctPassword = "password123";

        int attempts = 0;
        boolean isAuthenticated = false;

        while (attempts < 3) {
            System.out.print("enter your username: ");
            String username = input.nextLine();
            System.out.print("enter your password: ");
            String password = input.nextLine();
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                isAuthenticated = true;
                break;
            } else {
                attempts++;
                System.out.println("Wrong username or password.");
                System.out.println("Attempts left: " + (3 - attempts) + "\n");

            }
        }
        if (isAuthenticated) {
            System.out.print("Enter Student Name: ");
            String studentName = input.nextLine();

            System.out.print("Enter Quiz Score: ");
            double quiz = input.nextDouble();

            System.out.print("Enter Exam Score: ");
            double exam = input.nextDouble();

            System.out.print("Enter Project Score: ");
            double project = input.nextDouble();

            System.out.println("\nStudent Name: " + studentName);
            System.out.println("Quiz: " + quiz);
            System.out.println("Exam: " + exam);
            System.out.println("Project: " + project);
        } else {
            System.out.println("Too many failed attempts. Program terminated.");
        }

        input.close();

        
            
    }

}

        

    

      
     