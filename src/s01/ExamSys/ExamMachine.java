package s01.ExamSys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ExamMachine {

    private HashMap<String, String> userBox = new HashMap<>();

    {
        userBox.put("tommy", "123");
        userBox.put("sookie", "456");
    }

    private HashSet<Question> questionBank = new HashSet<Question>();

    {
        questionBank.add(new Question(" 1+1 = ?\\n\\tA:1 \\n\\tB:2 \\n\\tC:3 \\n\\tD:4 ", "B"));
        questionBank.add(new Question(" 1+2 = ?\\n\\tA:1 \\n\\tB:2 \\n\\tC:3 \\n\\tD:4 ", "C"));
        questionBank.add(new Question(" 2+2 = ?\\n\\tA:1 \\n\\tB:2 \\n\\tC:3 \\n\\tD:4 ", "D"));
        questionBank.add(new Question(" 3+2 = ?\\n\\tA:5 \\n\\tB:2 \\n\\tC:3 \\n\\tD:4 ", "A"));
        questionBank.add(new Question(" 1*2 = ?\\n\\tA:1 \\n\\tB:2 \\n\\tC:3 \\n\\tD:4 ", "B"));
        questionBank.add(new Question(" 2+2 = ?\\n\\tA:1 \\n\\tB:2 \\n\\tC:3 \\n\\tD:4 ", "D"));
    }

    public ArrayList<Question> getPaper() {
        System.out.println("creating paper... ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HashSet<Question> paper = new HashSet<Question>();
        ArrayList<Question> questionBank = new ArrayList<>(this.questionBank);
        while (paper.size() != 5) {
            int index = new Random().nextInt(this.questionBank.size());
            Question question = questionBank.get(index);
            paper.add(question);
        }
        return new ArrayList<Question>(paper);
    }

    public int login(String username, String password) {
        if (this.userBox.get(username) != null && this.userBox.get(username).equals(password)) {
//            return "login successful";
            return 1;
        } else {
            //return "username or password invalid";
            return 0;
        }
    }


}
