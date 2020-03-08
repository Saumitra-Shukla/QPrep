import java.io.*;
import java.util.*;
import java.lang.*;

public class LetterCombinationsOfPhoneNumber {


    public int limit(int d) {
        int ans = (d * 2) + (d - 3);
        try {
            
            if (d > 6) {
                ans++;
            }
            if (d > 8) {
                ans++;
            }
            /*
            if (d < 2) {
                ans = 0;
            } 
            */
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        return ans;
    }

    public List<String> letters(int d) {
        int b=0,e=0;
        e = limit(d);
        char end = (char) (e + 97);
        b = limit(d-1);
        char begin = (char) (b + 97);
        List<String> pat = new ArrayList<String>(); 
        for(char i = begin; i < end; ++i) {
            pat.add(Character.toString(i));
        }
        return pat;
    }

    // Implement your solution by completing the below function
    public List<String> letterCombinations(String digits) {
        // int d = Integer.parseInt(digits);
 
         String d1 = Character.toString(digits.charAt(0));
         List<String> num1 = letters(Integer.parseInt(d1));
         List<String> pat_d = new ArrayList<String>();
         for(int i = 0; i < num1.size(); i++) {
             String ans = num1.get(i);
             pat_d.add(ans);
         }
 
         for (int j=1; j<digits.length(); j++) {
             String d = Character.toString(digits.charAt(j));
             List<String> num = letters(Integer.parseInt(d));
             List<String> pat = new ArrayList<String>();
             for(int i = 0; i < pat_d.size(); i++) {
                 for(int k = 0; k < num.size(); k++) {
                     String ans = pat_d.get(i) + num.get(k);
                     pat.add(ans);
                 }
             }
             pat_d=pat;
         
         }
 
         
         return pat_d;
     }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        List<String> combinations = new LetterCombinationsOfPhoneNumber().letterCombinations(line);
        for (String cmbn : combinations)
            System.out.print(cmbn + " ");
    }
}