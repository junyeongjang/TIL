class Student{
    String name;
    int number;
    double gpa;

    Student(String name, int number, double gpa){
        this.name = name;
        this.number = number;
        this.gpa = gpa;
    }
    String getName(){
        return name;
    }
    int getNumber(){
        return number;
    }
    double getGPA(){
        return gpa;
    }
    public String toString(){
        return "Name : " + name + ", Number : " + number + ", GPA :" + gpa ;
    }
}

class StudentDB{
    Student[] students;
    int idx = 0;
    enum FindGPAParam {LOWER_THAN, HIGHER_THAN};
    StudentDB(){
      students = new Student[3];
    }
    void add(Student students){
        this.students[idx++] = students;
    }
    void add(String name, int number, double gpa){
        students[idx++] = new Student(name, number, gpa);
    }
    Student findBy(String name) {
        for (int i = 0; i < 3; i++) {
            if (students[i].name == name)
                return students[i];
        }
        return null;
    }
    Student findBy(int number){
        for(int i = 0; i < 3;i++){
            if(students[i].number == number)
                return students[i];
        }
        return null;
    }
    Student findBy(double gpa){
        for(int i = 0; i < 3;i++){
            if(students[i].gpa == gpa)
                return students[i];
        }
        return null;
    }
    Student findBy(FindGPAParam param, double gpa){
        if(FindGPAParam.LOWER_THAN == param) {
            for (int i = 0; i < 3; i++) {
                if (students[i].gpa <= gpa)
                    return students[i];
            }
        }
        else if(FindGPAParam.HIGHER_THAN == param) {
            for (int i = 0; i < 3; i++) {
                if (students[i].gpa   >= gpa)
                    return students[i];
            }
        }
        return null;
    }
}
class Main{
    public static void main(String[] args) {
        StudentDB db = new StudentDB();
        Student student = new Student("김지우", 201911111, 4.01);
        db.add(student);
        db.add("이민준", 201922222, 3.85);
        db.add("박서윤", 201933333, 3.90);

        System.out.println(db.findBy("김지우"));
        System.out.println(db.findBy(201922222));
        System.out.println(db.findBy(3.90));
        System.out.println(db.findBy("김지우"));
        System.out.println(db.findBy(StudentDB.FindGPAParam.LOWER_THAN, 3.95));
        System.out.println(db.findBy(StudentDB.FindGPAParam.HIGHER_THAN, 3.95));
    }
}