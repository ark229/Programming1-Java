//Unit 1 - Create a simple Quiz Game

import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        // Array to store questions
        String[] questions = {
                "What is the size of an int in Java? A: 32 bits B: 16 bits C: 64 bits D: 8 bits",
                "Where was the first example of paper money used? A: China B: Turkey C: Greece D: Rome",
                "Who is generally considered the inventor of the motor car? A: Henry Ford B: Karl Benz C: Henry M. Leland D: Alexander Winton",
                "What Italian city is famous for its system of canals? A: Rome B: Naples C: Venice D: Comacchio"
                // Add more questions here
        };

        // Array to store correct answers
        String[] correctAnswers = { "A", "A", "B", "C" }; // add more answers here

        // Scanner for reading user input
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]); // Display the question
            String answer;
            do {
                System.out.print("Enter your answer (A, B, C, D): ");
                answer = scanner.nextLine().toUpperCase();
            } while (!answer.matches("[ABCD]")); // Validate user input

            // Check if the answer is correct
            if (answer.equals(correctAnswers[i])) {
                System.out.println("Correct!");
                score++; // Increase score if correct
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswers[i]);
            }
        }

        // Calculate and display the final score as a percentage
        double percentage = (double) score / questions.length * 100;
        System.out.printf("Your score: %.2f%%\n", percentage);

        scanner.close(); // Close the scanner
    }
}
