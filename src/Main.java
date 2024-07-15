import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * once upon a time, in a land far far away lived a princess , whose beauty was yet unmatched
     * a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,yandex
     * a,,,b,qw
     *
     * len = 9 * 3 = 27
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();

        int maxWordLength = 0, currLength = 0;
        StringBuilder wellWords = new StringBuilder();
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ',' && array[i - 1] == ' ') {
                wellWords.deleteCharAt(i - 1);
            }
            if (Character.isLetter(array[i]) && i != 0 && array[i - 1] == ',') {
                wellWords.append(' ');
                currLength = 0;
            }
            currLength++;
            wellWords.append(array[i]);

            if (array[i] == ' ') {
                currLength = 0;
            }
            maxWordLength = Math.max(maxWordLength, currLength);
        }


        StringBuilder resultString = new StringBuilder();
        int len = 0;
        for(String word: wellWords.toString().split(" ")) {
            if (len + word.length() <= maxWordLength * 3) {
                if (resultString.length() > 0 && resultString.charAt(resultString.length() - 1) != '\n') {
                    resultString.append(" ");
                }
                resultString.append(word);
                len += word.length() + 1;
            } else {
                resultString.append("\n");
                resultString.append(word);
                len = word.length();
            }

        }

        System.out.printf(resultString.toString());
    }
}