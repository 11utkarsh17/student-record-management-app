import java.io.*;                             // Import classes for reading/writing files
import java.util.*;                           // Import utility classes like List and ArrayList


public class StudentManager {
    private final String FILE_NAME ="student.txt";     // call the txt file
    private List<Student> stulist;            // list to store Student objects in memory

    public StudentManager(){
        stulist=new ArrayList<>();            // create empty ArrayList of students
        loadstu();                            // load students from file into the list
    }

    public void loadstu(){
        try(BufferedReader br= new BufferedReader(new FileReader (FILE_NAME))){    // open the file for reading
            String line;
            while((line= br.readLine()) !=null){         // read line by line until file ends
                stulist.add(Student.extractfromfile(line));   // convert line into Student and add to list
            }
        }catch(IOException e){
            //file does not exist...........               // if file missing, do nothing (not an error)
        }
    }


    private void savestudent(){
             try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))){   // open file to write all students
                for(Student s: stulist){                // for each student in the list
                    bw.write(s.movetofile());           // convert student to string and write to file
                    bw.newLine();                       // move to next line in file
                }
             }catch (IOException e){
                System.out.println("ERROR IN SAVING STUDENTS");     // print if saving failed
             }

    }
    public void addstudent(Student s){
        stulist.add(s);                 // add student to list
        savestudent();                 // save updated list to file

    }
    public void viewallstudents(){
        if(stulist.isEmpty()){                         // if no students in list
            System.out.println("NO STUDENTS RECORD FOUND");  // print message
            return;
        }
        for(Student s: stulist){                       // for every student in list
            System.out.println("Rollno: " + s.getrollno() + ", Name: " + s.getname() + ", Age: "+ s.getage() + ", Course: " + s.getcourse());  // show student info
        }
    }
    public void searchstudent(int rollnumber){
        for(Student s: stulist){                        // loop through student list
            if(s.getrollno()==rollnumber){              // if roll number matches
                System.out.println("Found: " + s.getname() + ", Age: " + s.getage() + ", Course: " + s.getcourse());  // show found student info
                return;
            }
        }
        System.out.println("Student not found");         // print if student not found
    }
    public void delstudent(int rollnumber){
        boolean removed = stulist.removeIf(s -> s.getrollno()==rollnumber);   // remove student with matching roll number
        if(removed){
            savestudent();                     // save updated list
            System.out.println("Student deleted.");
        }else{
            System.out.println("Student not found.");    // if no student was deleted
        }
    }   
    public void updatestudent(int rollnumber,String name,int age,String course){
        for(Student s: stulist){                         // go through all students
            if(s.getrollno()==rollnumber){               // if roll number matches
                s.setrollno(rollnumber);                 // update roll number (optional)
                stulist.set(stulist.indexOf(s),new Student (rollnumber,name,age,course));  // replace student with new updated one
                savestudent();                           // save to file
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found");         // if not found
    }                     
}
