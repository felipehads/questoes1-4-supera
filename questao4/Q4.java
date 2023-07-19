package questao4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {

        Questao4 q4 = new Questao4();
        q4.resolve();
    }

    static class Questao4 {
        public void resolve() {

            // CLEAR SCREEN
            System.out.print("\033[H\033[2J");

            Scanner input = new Scanner(System.in);

            int arraySize = input.nextInt();

            List<String> testCases = new ArrayList<>();
            
            input.nextLine();

            for (int iterator = 0; iterator < arraySize; iterator++) {
                testCases.add(input.nextLine());
            }

            correctSentences(testCases);

            input.close();

        }

        protected void correctSentences(List<String> sentences) {
            System.out.println("\n");

            sentences.stream().forEach((sentence) -> {
                int sentenceLength = sentence.length();
                String firstSentenceHalf = new StringBuilder(sentence.substring(0, sentenceLength/2)).reverse().toString();
                String secondSentenceHalf = new StringBuilder(sentence.substring(sentenceLength/2, sentenceLength)).reverse().toString();

                System.out.println(firstSentenceHalf + secondSentenceHalf);
            });
        }
    }

}