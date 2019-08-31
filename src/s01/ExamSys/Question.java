package s01.ExamSys;

public class Question {
    private String title;
    private  String answer;

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof Question){
            Question anotherQusetion = (Question)obj;
            if(this.title == anotherQusetion.title){
                return true;
            }else {
                return false;
            }
        }else {return false;}
//        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return  this.title.hashCode();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }
}
