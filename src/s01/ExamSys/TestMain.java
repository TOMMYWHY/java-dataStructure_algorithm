package s01.ExamSys;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
//        Question question = new Question("1. 1+2 = ?\\n\\tA:1 \\n\\tB:2 \\n\\tC:3 \\n\\tD:4 ","B:2");

        ExamMachine em = new ExamMachine();
        Scanner scanner = new Scanner(System.in);
        System.out.println("username:");
        String username = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();

        Student student = new Student(username, password);
        int result = em.login(student.getName(), student.getPassword());
        if (result == 1) {
            System.out.println("login successful");

            ArrayList<Question> paper = em.getPaper();
            String[] answer = student.exam(paper);
            Teacher teacher = new Teacher();
            int score = teacher.checkPaper(paper, answer);

            System.out.println(student.getName() + " score is " + score);

        } else {
            System.out.println("username or password invalid");
        }
    }
}
