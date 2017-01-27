import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Diana_Bobkova on 1/27/2017.
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner1 = new Scanner(new File("input.txt"));
        Scanner scanner2 = new Scanner(new File("alphabet.txt"));
        Scanner scanner3 = new Scanner(new File("key.txt"));
        PrintWriter printWriter = new PrintWriter(new File("output.txt"));


        String text = scanner1.nextLine().toLowerCase();
        String ABC = scanner2.nextLine();
        String key = scanner3.nextLine();


        String ciphertext = "";
        String decryptedtext = "";


        // HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        //LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        //LinkedHashSet<String> nevhashSet = new LinkedHashSet<>();

        ArrayList<Character> alpList = new ArrayList<>();
        for (char c : ABC.toCharArray()) {
            alpList.add(c);
        }

        ArrayList<Character> keyList = new ArrayList<>();
        for (char k : key.toCharArray()) {
            if (!keyList.contains(k)) {
                keyList.add(k);
            }
        }
        for (char alp : ABC.toCharArray()) {
            if (!keyList.contains(alp)) {
                keyList.add(alp);
            }
        }

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < alpList.size(); j++) {
                if (text.charAt(i) == alpList.get(j)) {
                    ciphertext += keyList.get(j);
                }
            }
        }

        for (int i = 0; i < ciphertext.length(); i++) {
            for (int j = 0; j < keyList.size(); j++) {
                if (ciphertext.charAt(i) == keyList.get(j)) {
                    decryptedtext += alpList.get(j);
                }
            }
        }


        printWriter.println("криптограмма: " + ciphertext);
        printWriter.println("открытый текст: " + decryptedtext);
        printWriter.flush();
    }
}
