interface SportsParticipant {
    void playSport();
}

interface CulturalParticipant {
    void performActivity();
}

abstract class Student {
    private int rollNumber;
    private String name;
    private int semester;

    static String universityName;

    static {
        universityName = "Global Tech University";
    }

    final int MAX_SEMESTER = 8;

    Student(int roll, String name, int sem) {
        setRollNumber(roll);
        setName(name);
        setSemester(sem);
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        if (semester < 0 || semester > MAX_SEMESTER)
            this.semester = 1;
        else
            this.semester = semester;
    }

    abstract double calculateGrade();

    void displayDetails() {
        System.out.println("Roll: " + getRollNumber());
        System.out.println("Name: " + getName());
        System.out.println("Semester: " + getSemester());
    }

    static void displayUniversityName() {
        System.out.println("University: " + universityName);
    }

    final void showRules() {
        System.out.println("No cheating. Attendance mandatory.");
    }
}

class EngineeringStudent extends Student {
    int internalMarks;
    int externalMarks;

    EngineeringStudent(int r, String n, int s, int i, int e) {
        super(r, n, s);
        internalMarks = i;
        externalMarks = e;
    }

    double calculateGrade() {
        return (internalMarks * 0.4) + (externalMarks * 0.6);
    }
}

class MedicalStudent extends Student {
    int theory;
    int practical;

    MedicalStudent(int r, String n, int s, int t, int p) {
        super(r, n, s);
        theory = t;
        practical = p;
    }

    double calculateGrade() {
        return (theory + practical) / 2.0;
    }
}

class AllRounderStudent extends Student implements SportsParticipant, CulturalParticipant {
    int marks;

    AllRounderStudent(int r, String n, int s, int m) {
        super(r, n, s);
        marks = m;
    }

    double calculateGrade() {
        return marks;
    }

    public void playSport() {
        System.out.println(getName() + " plays football.");
    }

    public void performActivity() {
        System.out.println(getName() + " performs dance.");
    }
}

public class Main {
    public static void main(String[] args) {
        Student.displayUniversityName();

        Student s1 = new EngineeringStudent(1, "Amit", 4, 80, 90);
        Student s2 = new MedicalStudent(2, "Ashhar", 5, 85, 95);
        Student s3 = new AllRounderStudent(3, "Ishaan", 6, 88);

        System.out.println(s1.calculateGrade());
        System.out.println(s2.calculateGrade());
        System.out.println(s3.calculateGrade());

        SportsParticipant sp = new AllRounderStudent(4, "Sahil", 3, 75);
        sp.playSport();
    }
}
