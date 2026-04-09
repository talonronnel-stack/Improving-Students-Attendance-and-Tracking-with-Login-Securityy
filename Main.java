import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in); 

    static String correctUsername = "admin";
    static String correctPassword = "12345";

    static ArrayList<String> students = new ArrayList<>();

    static HashMap<String, String> attendance = new HashMap<>();

    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {

        students.add("Ronnel");
        students.add("janblair");
        students.add("Melvin");
        students.add("Maleck");
        students.add("Mark");

        while (true) {

            int loginAttempts = 3;
            boolean loggedIn = false;

            while (loginAttempts > 0) {
                System.out.print("Enter Username: ");
                String user = sc.nextLine();

                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                if (user.equals(correctUsername) && pass.equals(correctPassword)) {
                    System.out.println("Login Successful!\n");
                    loggedIn = true;
                    break;
                } else {
                    loginAttempts--;
                    System.out.println("Wrong login!");
                    if (loginAttempts > 0) {
                        System.out.println("Attempts left: " + loginAttempts + "\n");
                    } else {
                        System.out.println("Too many failed attempts. System locked.");
                        return; 
                    }
                }
            }

            while (loggedIn) { 
                System.out.println("\n=== MENU ===");
                System.out.println("1. Mark Attendance");
                System.out.println("2. View Attendance");
                System.out.println("3. View History");
                System.out.println("4. Delete Attendance"); 
                System.out.println("5. Logout");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); 

                if (choice == 1) {
                    int attempts = 3;
                    while (attempts > 0) {
                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();

                        if (students.contains(name)) {

                            if (attendance.containsKey(name)) {
                                System.out.println("Attendance already marked for " + name);
                                break; 
                            }

                            String date = java.time.LocalDate.now().toString();
                            System.out.print("Present or Absent (P/A): ");
                            String status = sc.nextLine();

                            attendance.put(name, status);
                            history.add(name + " - " + status + " - " + date);

                            System.out.println("Attendance recorded!");
                            break;
                        } else {
                            attempts--;
                            if (attempts > 0) {
                                System.out.println("Name not found. Attempts left: " + attempts);
                            } else {
                                System.out.println("Failed. Returning to menu.");
                            }
                        }
                    }

                } else if (choice == 2) {
                    System.out.println("\n--- Attendance Today ---");
                    if (attendance.isEmpty()) {
                        System.out.println("No attendance recorded yet.");
                    } else {
                        for (String name : attendance.keySet()) {
                            System.out.println(name + " : " + attendance.get(name));
                        }
                    }

                } else if (choice == 3) {
                    System.out.println("\n--- Attendance History ---");
                    if (history.isEmpty()) {
                        System.out.println("No history available.");
                    } else {
                        for (String record : history) { 
                            System.out.println(record);
                        }
                    }

                } else if (choice == 4) { 
                    System.out.print("Enter Student Name to delete attendance: ");
                    String name = sc.nextLine();

                    if (attendance.containsKey(name)) {
                        attendance.remove(name);

                        
                        String date = java.time.LocalDate.now().toString();
                        history.add(name + " - Attendance Deleted - " + date);

                        System.out.println("Attendance deleted for " + name);   
                    } else {
                        System.out.println("No attendance found for " + name);  
                    }

                } else if (choice == 5) {
                    System.out.println("Logging out...\n");
                    loggedIn = false;

                } else {
                    System.out.println("Invalid choice!");
                }
            }
        }
    }
}
        

    

      
     
