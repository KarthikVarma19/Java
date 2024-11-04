import java.util.Scanner;


public class QuestionService {
    Question[] questions = new Question[5];
    String[] selection = new String[5];
    public QuestionService(){
        questions[0] = new Question(1,"What is Size of int","8 bit","16 bit","32 bit","64 bit","32 bit");
        questions[1] = new Question(2,"What is Size of char","8 bit","16 bit","32 bit","64 bit","16 bit");
        questions[2] = new Question(3,"What is Size of float","8 bit","16 bit","32 bit","64 bit","32 bit");
        questions[3] = new Question(4,"What is Size of double","8 bit","16 bit","32 bit","64 bit","64 bit");
        questions[4] = new Question(5,"What is Size of long","8 bit","16 bit","32 bit","64 bit","64 bit");
    }
    public void playQuiz(){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        for(Question q: questions){   
            System.out.println("Question no. " + q.getId());
            System.out.println("Question: " + q.getQuestion());
            System.out.println("Option 1: " + q.getOpt1());
            System.out.println("Option 2: " + q.getOpt2());
            System.out.println("Option 3: " + q.getOpt3());
            System.out.println("Option 4: " + q.getOpt4());
            System.out.print("Enter your answer: ");
            selection[i++] = sc.nextLine();
        }
    }
    public void printScore(){
        int score = 0;
        for(int i=0;i<questions.length;i++){
            if(questions[i].getAnswer().equals(selection[i])){
                score++;
            }
        }
        System.out.println("Your Score is: " + score);
    }
} 
