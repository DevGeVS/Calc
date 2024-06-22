package Student;

public class Student {
    int IdBilet;
    String name;
    String surname;
    int yars;
    double massessmentInMath;
    double massessmentInEconom;
    double massessmentInLang;
}

class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        student1.IdBilet = 1;
        student1.name = "Ivan";
        student1.surname = "Ivanov";
        student1.yars = 2004;
        student1.massessmentInMath = 4.3;
        student1.massessmentInEconom = 4.7;
        student1.massessmentInLang = 3.5;

        student2.IdBilet = 2;
        student2.name = "Petr";
        student2.surname = "Petrov";
        student2.yars = 2012;
        student2.massessmentInMath = 3.3;
        student2.massessmentInEconom = 4.3;
        student2.massessmentInLang = 4.5;

        student3.IdBilet = 3;
        student3.name = "Serj";
        student3.surname = "Svetov";
        student3.yars = 2012;
        student3.massessmentInMath = 3.3;
        student3.massessmentInEconom = 3.3;
        student3.massessmentInLang = 4.1;
        System.out.println("Студент " + student1.name + " " + student1.surname + " Студенческий билет № " + student1.IdBilet + " средняя оценка " +
                (student1.massessmentInMath + student1.massessmentInEconom + student1.massessmentInLang)/3);

        System.out.println("Студент " + student2.name + " " + student2.surname + " Студенческий билет № " + student2.IdBilet + " средняя оценка " +
                (student2.massessmentInMath + student2.massessmentInEconom + student2.massessmentInLang)/3);
        System.out.println("Студент " + student3.name + " " + student3.surname + " Студенческий билет № " + student3.IdBilet + " средняя оценка " +
                (student3.massessmentInMath + student3.massessmentInEconom + student3.massessmentInLang)/3);
    }
}
