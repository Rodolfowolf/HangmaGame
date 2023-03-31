
/**
 * Assignment 8 College Course objects working with bidimensional array and try catch.
 * @author Igor Guimaraes 200540189 - Navjot Kaur 200547472 - Yuvraj Singla - Rodolfo Carvalho 200536943
 * @date March 18, 2023
 * @time 09:00pm 
 */
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class HangmanGame {
    
    private static final String[] WORDS = { "apple", "banana", "artificial", "funny", "hardware" };
    private static final String[] TIPS = { "Fruit, usually rounded red, yellow, or green.",
            "Elongated usually tapering tropical fruit.", "humanly contrived", "causing amusement or laughter",
            "Major items of equipment or their components." };
    private static final int MAX_GUESSES = 4;

    public static void main(String[] args) {
        ArrayList<Hangman> list = new ArrayList<>();
        int x;
        int y;
        int position = 0;
        Random random = new Random();
        // x = random.nextInt(5);
        Scanner scanner = new Scanner(System.in);

        int score = 0;
        char opt = 'y';
        String name;
        System.out.print("Please input your player name: ");// User input
        name = (scanner.nextLine());// User input record
        System.out.println("Now you have 4 guesses to discover the hidden world, good luck!!!");
        do {
            try {
                x = random.nextInt(5);
                String word = selectRandomWord(x);
                String tips = selectRandomTips(x);
                Hangman recorder = new Hangman(word, tips);
                list.add(recorder);
                position = position + 1;

                int remainingGuesses = MAX_GUESSES;
                StringBuilder guessedLetters = new StringBuilder();

                while (remainingGuesses > 0) {
                    System.out.println("---------------------------------------------");
                    System.out.println("Tips: " + tips);
                    System.out.println("Word: " + getHiddenWord(word, guessedLetters));
                    System.out.println("Guesses left: " + remainingGuesses);
                    System.out.print("Enter a letter: ");
                    String letter = scanner.nextLine();

                    if (guessedLetters.indexOf(letter) != -1) {
                        System.out.println("You already guessed that letter!");
                    } else {
                        guessedLetters.append(letter);

                        if (word.indexOf(letter) != -1) {
                            System.out.println("Correct!");
                        } else {
                            System.out.println("Wrong!");
                            remainingGuesses--;
                        }
                    }

                    if (getHiddenWord(word, guessedLetters).equals(word)) {
                        System.out.println("Congratulations, you won!");
                        score = score + 1;
                        break;
                    }
                }

                if (remainingGuesses == 0) {
                    System.out.println("Sorry, you lost. The word was " + word);
                }
                System.out.println("Process finished, Would you like to try again (Y|N): ");// User input
                opt = (scanner.nextLine().charAt(0));// User input record
            } // Exceptions treatment
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The exception is: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("The exception is: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("The exception is: " + e.getMessage());
            }
        } while (opt == 'y' || opt == 'Y');

        System.out.println("---------------------------------------------");
        for (int i = 0; i < position; i++) {
            String word = list.get(i).getWordRec();
            String tips = list.get(i).getTipsRec();

            System.out.println("Word " + (i+1) + " : " + word + " | " + tips);
        }
        System.out.println("End game, "+name+" your score is: " + score);
    }

    // --------

    static String selectRandomWord(int x) {
        return WORDS[x];
    }

    static String selectRandomTips(int x) {
        return TIPS[x];
    }

    static private String getHiddenWord(String word, StringBuilder guessedLetters) {
        StringBuilder hiddenWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (guessedLetters.indexOf(String.valueOf(c)) != -1) {
                hiddenWord.append(c);
            } else {
                hiddenWord.append("_");
            }
        }

        return hiddenWord.toString();
    }
}