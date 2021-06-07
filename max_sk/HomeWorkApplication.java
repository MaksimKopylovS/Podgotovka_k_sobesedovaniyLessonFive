package max_sk;

import max_sk.configuration.CrudApp;
import max_sk.model.Students;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkApplication {
    public static void main(String[] args) {
        List<Students> studentsList = new ArrayList<>();

        for(int i = 0; i < 1000; i ++){
            studentsList.add(new Students("Stutent"+i, 1 + (int)Math.random() * 5));
        }

        CrudApp.createExampleAll(studentsList);

        CrudApp.delStudents(new Students(998, "Stutent987", 1));
        List list = CrudApp.getAllStudents();
        CrudApp.updateStudent(new Students(980, "Петька", 5));

        Students students = CrudApp.findStudentById(980);
        System.out.println(students.getName());
        List<Students> students1 = CrudApp.getAllStudents();
        System.out.println(students1.size());

    }
}
