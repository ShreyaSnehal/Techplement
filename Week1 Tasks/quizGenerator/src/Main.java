import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Question{
    private String question;
    private ArrayList<String> options;
    private String correctAns;

    public Question(String question,ArrayList<String> option, String correctAns){
        this.question=question;
        this.options=option;
        this.correctAns=correctAns;

    }

    public String getQuestion(){
        return question;
    }

    public ArrayList<String> getOptions(){
        return options;

    }

    public String getCorrectAns(){
        return correctAns;

    }
}
class Quiz{
    private ArrayList<Question> questions;

    public Quiz(ArrayList<Question> questions){
        this.questions=questions;
    }

    public ArrayList<Question> getQuestions(){
        return questions;
    }
}

class QuizGenerator{
    public static Quiz generateQuiz(String topic, int numQues){
        ArrayList<Question> questions=new ArrayList<>();

        Scanner sc=new Scanner(System.in);

        for(int i=0;i<numQues;i++){
            System.out.println("Enter the question"+(i+1));
            String question=sc.nextLine();

            ArrayList<String> options=new ArrayList<>();
            for(int j=0;j<4;j++){
                System.out.println("Enter option"+(char)('A'+j)+":");
                options.add(sc.nextLine());

            }

            Collections.shuffle(options);

            System.out.println("Enter the correct option (A,B,C,D): ");
            String correctAns=sc.nextLine().toUpperCase();

            questions.add(new Question(question,options,correctAns));

        }
        return new Quiz(questions);


    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Topic for the quiz: ");
        String topic = scanner.nextLine();

        System.out.println("Enter the number of questions for the quiz: ");
        int numQues = Integer.parseInt(scanner.nextLine());
        Quiz quiz = QuizGenerator.generateQuiz(topic, numQues);


        int score = 0;
        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            Question ques = quiz.getQuestions().get(i);
            System.out.println("Question" + (i + 1) + ":" + ques.getQuestion());
            ArrayList<String> options = ques.getOptions();

            for (int j = 0; j < options.size(); j++) {
                System.out.println((char) ('A' + j) + ")" + options.get(j));

            }

            System.out.println("Enter your answer (A,B,C,D):");
            String userAns = scanner.nextLine().toUpperCase();
            if (userAns.equals(ques.getCorrectAns())) {
                score++;
            }
        }

        System.out.println("Your score:"+score+"/"+numQues);
    }
}