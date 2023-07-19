package questao1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Questao1 q1 = new Questao1();
        q1.resolve();
    }

    static class Questao1 {
        public void resolve() {

            Scanner input = new Scanner(System.in);

            Integer inputSize = input.nextInt();

            List<Integer> evenNumberList = new ArrayList<>();
            List<Integer> oddNumberList = new ArrayList<>();

            for (int i = 0; i < inputSize; i++) {
                Integer currentNumber = input.nextInt();

                if (isEven(currentNumber))
                    evenNumberList.add(currentNumber);
                else
                    oddNumberList.add(currentNumber);
            }

            input.close();

            Collections.sort(evenNumberList);
            Collections.sort(oddNumberList, Collections.reverseOrder());

            List<Integer> result = new ArrayList<>();

            result.addAll(evenNumberList);
            result.addAll(oddNumberList);

            // CLEAR SCREEN
            System.out.print("\033[H\033[2J");

            result.stream().forEach(number -> {
                System.out.println(number);
            });
        }
    }

    protected static Boolean isEven(Integer number) {
        return number % 2 == 0;
    }
}