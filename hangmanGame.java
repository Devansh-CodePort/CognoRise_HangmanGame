import java.util.*;
class hangmanGame 
{
    public static void main(String[] args) 
    {
        String[] word={"apple","orange","banana","grape"};
        Random rd=new Random();
        int randomIndex=rd.nextInt(word.length);
        String randomWord=word[randomIndex];
        int length=randomWord.length();
        Scanner sc=new Scanner(System.in);
        char[] hiddenWord=new char[length];
        Arrays.fill(hiddenWord, '_');
        int attempts=5;
        char[] guessedLetters=new char[length];
        Arrays.fill(guessedLetters,' ');
        int incorrectGuesses=0;
        while(attempts>0) 
        {
            System.out.println("Guess a Letter that is Fruit name");
            System.out.println("Word: "+String.valueOf(hiddenWord));
            System.out.println("Guessed Letters: "+String.valueOf(guessedLetters));
            System.out.println("Attempts left: "+attempts);
            displayHangmanFigure(incorrectGuesses);
            String guess=sc.nextLine().toLowerCase();

            if(guess.length()!= 1 || !Character.isLetter(guess.charAt(0))) 
            {
                System.out.println("Invalid input. Please enter a single letter.");
                continue;
            }
            char guessedLetter=guess.charAt(0);
            boolean correctGuess=false;
            for(int i=0; i<length;i++) 
            {
                if(randomWord.charAt(i)==guessedLetter) 
                {
                    hiddenWord[i]=guessedLetter;
                    correctGuess=true;
                }
            }
            if(!correctGuess) 
            {
                attempts--;
                guessedLetters[attempts]=guessedLetter;
                incorrectGuesses++;
            }
            if(String.valueOf(hiddenWord).equals(randomWord)) 
            {
                System.out.println("Congratulations! You guessed the word: "+randomWord);
                break;
            }
        }
        if(attempts==0) 
        {
            System.out.println("You ran out of attempts. The word was: "+randomWord);
        }
    }
    private static void displayHangmanFigure(int incorrectGuesses) 
    {
        String[] hangmanFigures={
                " +---+\n     |\n     |\n     |\n    ===",
                " +---+\n O   |\n     |\n     |\n    ===",
                " +---+\n O   |\n |   |\n     |\n    ===",
                " +---+\n O   |\n/|   |\n     |\n    ===",
                " +---+\n O   |\n/|\\  |\n     |\n    ===",
                " +---+\n O   |\n/|\\  |\n/    |\n    ===",
                " +---+\n O   |\n/|\\  |\n/ \\  |\n    ==="
        };
        System.out.println(hangmanFigures[incorrectGuesses]);
    }
}