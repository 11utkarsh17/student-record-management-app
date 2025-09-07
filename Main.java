import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner (System.in);

        while(true){
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("Choose an Option: ");
            int choice = sc.nextInt();
            sc.nextLine();  //consume newline

            switch(choice){
                case 1 -> {
                    System.out.println("Roll no: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    manager.addstudent(new Student(roll, name, age, course));

                }
                case 2 -> manager.viewallstudents();
                case 3 -> {
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    manager.searchstudent(roll);
                }
                case 4 -> {
                    System.out.print("Enter roll number to update: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String name = sc.nextLine();
                    System.out.print("New Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Course: ");
                    String course = sc.nextLine();
                    manager.updatestudent(roll, name, age, course);
                }
                case 5 -> {
                    System.out.print("Enter roll number to delete: ");
                    int roll = sc.nextInt();
                    manager.delstudent(roll);
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
            }
        }
    
