package s01.ExamSys;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String name;
    private String password;

    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String[] exam (ArrayList<Question> paper){
        String[] answers = new String[paper.size()];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < paper.size(); i ++){
            Question question = paper.get(i);
            System.out.println(i+1+" : "+ question.getTitle());
            System.out.println("your answer is :");
            String answer =  scanner.nextLine();
            answers[i] = answer;
        }
        return answers;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
