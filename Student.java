public class Student {
    private int rollno;
    private String name;
    private int age;
    private String course;

    public Student (int rollno,String name, int age, String course){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
        this.course=course;
    }
    //getters &  setters
    public int getrollno(){
        return rollno;
    }
    public void setrollno(int rollno){
        this.rollno = rollno;
    }
    public String getname(){
        return name;
    }
    public int getage(){
        return age;
    }
    public String getcourse(){
        return course;
    }

    public String movetofile () {
    return rollno + "," + name + "," + age + "," + course;
}

    public static Student extractfromfile(String line){
          String parts[]=line.split(",");
          return new Student (Integer.parseInt(parts[0]),parts[1],Integer.parseInt(parts[2]),parts[3]);
    }
}
 