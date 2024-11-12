package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private static int index = 0;

    public static void startGame() {
        System.out.println("Game started.");
        GeneratorOfNumbers.generateUniqueRandomNumbers(0,4,5);

        showQuestion();
    }

    private static void showQuestion() {
        System.out.println(Questions.questions[GeneratorOfNumbers.uniqueNumbers[index]].getQuestion());
        System.out.println("-----------------------------------");
        System.out.println("1. " + Questions.questions[GeneratorOfNumbers.uniqueNumbers[index]].getFirstAnswer());
        System.out.println("2. " + Questions.questions[GeneratorOfNumbers.uniqueNumbers[index]].getSecondAnswer());
        System.out.println("3. " + Questions.questions[GeneratorOfNumbers.uniqueNumbers[index]].getThirdAnswer());
        System.out.println("4. " + Questions.questions[GeneratorOfNumbers.uniqueNumbers[index]].getFourthAnswer());

        getUserAnswer();
    }

    private static void getUserAnswer() {
        System.out.println("Ваш ответ: ");

        try {
            Scanner sc = new Scanner(System.in);
            var userAnswer = sc.nextInt();

            checkAnswer(userAnswer);
        }
        catch (InputMismatchException e) {
            System.out.println("Неккоретно введён ответ. Попробуйте ещё.");

            getUserAnswer();
        }
    }

    private static void checkAnswer(int userAnswer) {
        if(userAnswer == Questions.questions[GeneratorOfNumbers.uniqueNumbers[index]].getCORRECT_NUMBER_INDEX()) {
            System.out.println("Вы победили!");

            checkQuestions();
        }
        else {
            System.out.println("Вы проиграли!");

            checkQuestions();
        }
    }

    private static void checkQuestions() {
        index++;
        if (index == Questions.questions.length) {
            System.exit(0);
        }
        else showQuestion();
    }
}