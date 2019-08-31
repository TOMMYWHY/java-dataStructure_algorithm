package s01.ExamSys;

import java.util.ArrayList;

public class Teacher {

    public int checkPaper (ArrayList<Question> paper, String[] answers){
        int score = 0;
        for (int i = 0; i< paper.size();i++){
            if(paper.get(i).getAnswer().equalsIgnoreCase(answers[i])){
                score += (100/paper.size());
            }
        }

        return  score;
    }



}
