package questao3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Q3 {
     public static void main(String[] args) {

        Questao3 q3 = new Questao3();
        q3.resolve();
    }

    static class Questao3 {
        public void resolve() {

            // CLEAR SCREEN
            System.out.print("\033[H\033[2J");

            Scanner input = new Scanner(System.in).useLocale(Locale.US);

            int arraySize;

            arraySize = input.nextInt();
            
            System.out.println("array size" +  arraySize);
            
            Integer[] arr = new Integer[arraySize];
            
            int difference;
            
            difference = input.nextInt();
            
            System.out.println("difference" +  difference);

            for (int iterator = 0; iterator < arr.length; iterator++) {
                arr[iterator] = input.nextInt();
            }

            List<Integer> lista = Arrays.asList(arr);

            // System.out.println(lista);

            getNumberOfPairsWithGivenDifference(lista, difference);

            input.close();

            
        }

        protected void getNumberOfPairsWithGivenDifference(List<Integer> inputArray, int difference) {
            
            Collections.sort(inputArray);

            int givenDifferenceOcurrences = 0;

            for (int arrayIndex = 1; arrayIndex < inputArray.size(); arrayIndex ++) {
                for (int comparatorIndex = 0; comparatorIndex < arrayIndex; comparatorIndex++) {
                    if ( inputArray.get(arrayIndex) - inputArray.get(comparatorIndex) < difference ) {
                        break;
                    } 

                    if ( (inputArray.get(arrayIndex) - inputArray.get(comparatorIndex)) == difference )  {
                        givenDifferenceOcurrences += 1;
                    }
                }
            }

            System.out.println(givenDifferenceOcurrences);
            
        } 

    }
}
