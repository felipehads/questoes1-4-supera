package questao2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Questao2 q1 = new Questao2();
        q1.resolve();
    }

    static class Questao2 {
        public void resolve() {

            // CLEAR SCREEN
            System.out.print("\033[H\033[2J");

            Scanner input = new Scanner(System.in).useLocale(Locale.US);

            Float floatNumber = input.nextFloat();
            
            input.close();

            getMiniumAmountOfNotes(floatNumber%.2f);
            
        }

        protected void getMiniumAmountOfNotes(Float input) {


            List<Integer> possibleNotes = getPossibleNotes();
            List<Float> possibleCoins = getPossibleCoins();

            List<Integer> notesAmount = new ArrayList<>(possibleNotes.size());
            List<Integer> coinsAmount = new ArrayList<>(possibleCoins.size());

            Float currentInput = input;
            
            try {

                for (int noteIndex = 0; noteIndex < possibleNotes.size(); noteIndex++) {

                    int currentNoteAmount = (int) (currentInput / possibleNotes.get(noteIndex));

                    currentInput = currentInput - (float) (currentNoteAmount * possibleNotes.get(noteIndex));

                    notesAmount.add(currentNoteAmount);
                }

                for (int coinIndex = 0; coinIndex < possibleCoins.size(); coinIndex++) {

                    int currentCoinAmount = (int) (currentInput / possibleCoins.get(coinIndex));
                    
                    currentInput = currentInput - (float) (currentCoinAmount * possibleCoins.get(coinIndex));
                    
                    // TRATAMENTO DE FLOAT 0.01 ==> 0.009
                    if(coinIndex == possibleCoins.size() - 1 && currentInput > 0.009f) {
                        currentCoinAmount += 1;
                    }

                    coinsAmount.add(currentCoinAmount);
                    
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }   

            System.out.println("NOTAS:");
            for (int noteIndex = 0; noteIndex < possibleNotes.size(); noteIndex++) {
                System.out.println(notesAmount.get(noteIndex) + "\t nota(s) \t de \t R$ \t" + possibleNotes.get(noteIndex) + ".00");
            }

            System.out.println("MOEDAS:");
            for (int coinIndex = 0; coinIndex < possibleCoins.size(); coinIndex++) {
                System.out.println(coinsAmount.get(coinIndex) + "\t moeda(s) \t de \t R$ \t" + possibleCoins.get(coinIndex));
            }
        }

        protected List<Integer> getPossibleNotes() {
            List<Integer> possibleNotes = new ArrayList<>();
            possibleNotes.add(100);
            possibleNotes.add(50);
            possibleNotes.add(20);
            possibleNotes.add(10);
            possibleNotes.add(5);
            possibleNotes.add(2);
            return possibleNotes;
        }

        protected List<Float> getPossibleCoins() {
            List<Float> possibleNotes = new ArrayList<>();
            possibleNotes.add(1.00f);
            possibleNotes.add(0.50f);
            possibleNotes.add(0.25f);
            possibleNotes.add(0.10f);
            possibleNotes.add(0.05f);
            possibleNotes.add(0.01f);
            return possibleNotes;
        }
    }

}
