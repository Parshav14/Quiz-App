package com.codecademy.unquote;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private int currentQuestionIndex;
    private int totalCorrect;
    private int totalQuestions;
    private ArrayList<Question> questions;
    private ImageView questionImageView;
    private TextView questionTextView;
    private TextView questionsRemainingTextView;
    private Button answer0Button;
    private Button answer1Button;
    private Button answer2Button;
    private Button answer3Button;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Show app icon in ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_unquote_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setElevation(0);

        setContentView(R.layout.activity_main);

        // assign View member variables
        questionImageView = findViewById(R.id.iv_main_question_image);
        questionTextView = findViewById(R.id.tv_main_question_title);
        questionsRemainingTextView = findViewById(R.id.tv_main_questions_remaining_count);
        answer0Button = findViewById(R.id.btn_main_answer_0);
        answer1Button = findViewById(R.id.btn_main_answer_1);
        answer2Button = findViewById(R.id.btn_main_answer_2);
        answer3Button = findViewById(R.id.btn_main_answer_3);
        submitButton = findViewById(R.id.btn_main_submit_answer);

        // set onClickListener for each answer Button
        answer0Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(0);
            }
        });
        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(1);
            }
        });
        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(2);
            }
        });
        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(3);
            }
        });

        // set onClickListener for the submit answer Button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSubmission();
            }
        });

        // initialize new game
        startNewGame();
    }

    // display the question passed in
    public void displayQuestion(Question question) {
        questionImageView.setImageResource(question.getImageId());
        questionTextView.setText(question.getQuestionText());
        answer0Button.setText(question.getAnswer0());
        answer1Button.setText(question.getAnswer1());
        answer2Button.setText(question.getAnswer2());
        answer3Button.setText(question.getAnswer3());
    }

    // display how many questions remained
    public void displayQuestionsRemaining(int questionRemaining) {
        questionsRemainingTextView.setText(String.valueOf(questionRemaining));
    }

    // actions to happen when an answer is selected
    public void onAnswerSelected(int answerSelected) {
        Question currentQuestion = this.getCurrentQuestion();
        currentQuestion.setPlayerAnswer(answerSelected);
        // reset all questions to starting state first
        answer0Button.setText(currentQuestion.getAnswer0());
        answer1Button.setText(currentQuestion.getAnswer1());
        answer2Button.setText(currentQuestion.getAnswer2());
        answer3Button.setText(currentQuestion.getAnswer3());
        // check the selected question
        switch (answerSelected) {
            case 0:
                answer0Button.setText("✔ " + currentQuestion.getAnswer0());
                break;
            case 1:
                answer1Button.setText("✔ " + currentQuestion.getAnswer1());
                break;
            case 2:
                answer2Button.setText("✔ " + currentQuestion.getAnswer2());
                break;
            case 3:
                answer3Button.setText("✔ " + currentQuestion.getAnswer3());
                break;
        }
    }

    public void startNewGame() {
        // created 13 questions and add them to the questions array list
        Question question1 = new Question(R.drawable.img_quote_0, "Pretty good advice, and perhaps a scientist did say it… Who actually did?", "Albert Einstein", "Isaac Newton", "Rita Mae Brown", "Rosalind Franklin", 2);
        Question question2 = new Question(R.drawable.img_quote_1, "Was honest Abe honestly quoted? Who authored this pithy bit of wisdom?", "Edward Stieglitz", "Maya Angelou", "Abraham Lincoln", "Ralph Waldo Emerson", 0);
        Question question3 = new Question(R.drawable.img_quote_2, "Easy advice to read, difficult advice to follow — who actually said this?", "Martin Luther King Jr.", "Mother Teresa", "Fred Rogers", "Oprah Winfrey", 1);
        Question question4 = new Question(R.drawable.img_quote_3, "Insanely inspiring, insanely incorrect (maybe). Who is the true source of this inspiration?", "Nelson Mandela", "Harriet Tubman", "Mahatma Gandhi", "Nicholas Klein", 3);
        Question question5 = new Question(R.drawable.img_quote_4, "A peace worth striving for — who actually reminded us of this?", "Malala Yousafzai", "Martin Luther King Jr.", "Liu Xiaobo", "Dalai Lama", 1);
        Question question6 = new Question(R.drawable.img_quote_5, "Unfortunately, true — but did Marilyn Monroe convey it or did someone else?", "Laurel Thatcher Ulrich", "Eleanor Roosevelt", "Marilyn Monroe", "Queen Victoria", 0);
        Question question7 = new Question(R.drawable.img_quote_6, "Here’s the truth, Will Smith did say this, but in which movie?", "Independence Day", "Bad Boys", "Men In Black", "The Pursuit of Happyness", 2);
        Question question8 = new Question(R.drawable.img_quote_7, "Which TV funny gal actually quipped this 1-liner?", "Ellen Degeneres", "Amy Poehler", "Betty White", "Tina Fay", 3);
        Question question9 = new Question(R.drawable.img_quote_8, "This mayor won’t get my vote — but did he actually give this piece of advice? And if not, who did?", "Forrest Gump, Forrest Gump", "Dory, Finding Nemo", "Esther Williams", "The Mayor, Jaws", 1);
        Question question10 = new Question(R.drawable.img_quote_9, "Her heart will go on, but whose heart is it?", "Whitney Houston", "Diana Ross", "Celine Dion", "Mariah Carey", 0);
        Question question11 = new Question(R.drawable.img_quote_10, "He’s the king of something alright — to whom does this self-titling line belong to?", "Tony Montana, Scarface", "Joker, The Dark Knight", "Lex Luthor, Batman v Superman", "Jack, Titanic", 3);
        Question question12 = new Question(R.drawable.img_quote_11, "Is “Grey” synonymous for “wise”? If so, maybe Gandalf did preach this advice. If not, who did?", "Yoda, Star Wars", "Gandalf The Grey, Lord of the Rings", "Dumbledore, Harry Potter", "Uncle Ben, Spider-Man", 0);
        Question question13 = new Question(R.drawable.img_quote_12, "Houston, we have a problem with this quote — which space-traveler does this catch-phrase actually belong to?", "Han Solo, Star Wars", "Captain Kirk, Star Trek", "Buzz Lightyear, Toy Story", "Jim Lovell, Apollo 13", 2);

        this.questions = new ArrayList<>(Arrays.asList(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13));

        // remove 7 questions at random from the questions set so only 6 questions remains
        while (questions.size() > 6) {
            questions.remove(generateRandomNumber(questions.size()));
        }

        // reset the totalCorrect and totalQuestions, for each new game
        this.totalCorrect = 0;
        this.totalQuestions = questions.size();
        Question firstQuestion = chooseNewQuestion();
        displayQuestion(firstQuestion);
        displayQuestionsRemaining(questions.size());
    }

    // choose a new question to be prompted to player randomly
    private Question chooseNewQuestion() {
        int maxNum = questions.size() - 1;
        int questionIdx = this.generateRandomNumber(maxNum);
        currentQuestionIndex = questionIdx;
        return questions.get(questionIdx);
    }

    // returns the current question
    private Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    // actions to happen when player selects the submit button
    public void onAnswerSubmission() {
        Question currentQuestion = this.getCurrentQuestion();
        // only proceed if the player's answer is not -1 (the default value), player has to select an answer
        if (currentQuestion.getPlayerAnswer() != -1) {
            if (currentQuestion.isCorrect()) {
                this.totalCorrect++;
            }
            // remove a question from the collection of questions whether player answered it correctly or not
            questions.remove(currentQuestion);
            // display updated questions remaining
            displayQuestionsRemaining(questions.size());
            // if there is no question left, display the game over alert, else, choose and display a new question
            if (questions.size() == 0) {
                gameOverAlert();
            } else {
                chooseNewQuestion();
                displayQuestion(getCurrentQuestion());
            }
        }
    }

    // Show a popup when game is over
    public void gameOverAlert() {
        String gameOverMessage = getGameOverMessage(totalCorrect, totalQuestions);
        AlertDialog.Builder gameOverDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        gameOverDialogBuilder.setCancelable(false);
        gameOverDialogBuilder.setTitle("Game Over!");
        gameOverDialogBuilder.setMessage(gameOverMessage);
        gameOverDialogBuilder.setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startNewGame();
            }
        });
        gameOverDialogBuilder.create().show();
    }

    private int generateRandomNumber(int max) {
        double randomNumber = Math.random();
        double result = max * randomNumber;
        return (int) result;
    }

    private String getGameOverMessage(int totalCorrect, int totalQuestions) {
        if (totalCorrect == totalQuestions) {
            return "You got all " + totalQuestions + " right! You won!";
        } else {
            return "You got " + totalCorrect + " right out of " + totalQuestions + ". Better luck next time!";
        }
    }

}

