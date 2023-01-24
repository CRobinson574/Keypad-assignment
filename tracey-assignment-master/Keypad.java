import java.util.Scanner;
import java.util.*;

public class Keypad
{
    public static void main(String [] args)
    {   
        String [] keypad = {"\0", "\0", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String number = in.next();
        phoneMnemonic(number, keypad);
        
        in.close();
    }
    
    public static void phoneMnemonic(String number, String [] keypad)
    {   int numLen = number.length();
        if(numLen > 0)
        {
            char[] currentIndex = new char[number.length()];
            List<String> results = new ArrayList<>();
            getPossibilities(number, keypad, 0, currentIndex, results);
            System.out.println("Here are all the possible possibilities: " + results);
        }
    }

    public static void getPossibilities(String number, String [] keypad, int position, char[] currentIndex, List<String> results)
    {
        if(position == number.length())
        {
            results.add(new String(currentIndex));
        }
        else
        {
            int integer = number.charAt(position)-'0';
            for(int i = 0; i < keypad[integer].length(); i++)
            {
                char c = keypad[integer].charAt(i);
                currentIndex[position] = c;
                getPossibilities(number, keypad, position + 1, currentIndex, results);
            }
        }
    }
}
