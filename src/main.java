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


        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        LinkedHashSet<String> nevhashSet = new LinkedHashSet<>();

        int m = ABC.length();
        for (int i = 0; i <key.length() ; i++) {
           if (key.charAt(i)!=' '){
                hashSet.add(String.valueOf(key.charAt(i)));
            }
        }
        printSet(hashSet);
        for (int i = 0; i <ABC.length() ; i++) {
            if (!hashSet.contains(ABC.charAt(i))){
                nevhashSet.add(String.valueOf(ABC.charAt(i)));
            }
        }

        // Шифрование методом замены (код Цезаря)
   //     for (int i = 0; i < text.length(); i++) {

    //        ciphertext += ABC.charAt(B);
     //   }


        printWriter.println(ciphertext);
        printWriter.println(decryptedtext);
        printWriter.flush();
    }

    private static void printSet(LinkedHashSet<String> hashSet) {
        for (Iterator iter = hashSet.iterator(); iter.hasNext();) {
            System.out.print(iter.next() + ", ");
        }
        System.out.println(" ");
    }
    private static void printNevSet(LinkedHashSet<String> nevhashSet) {
        Iterator iterator = nevhashSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }

}
