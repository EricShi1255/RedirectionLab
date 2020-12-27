import java.util.*;
public class PigLatin {
    public static String pigLatinSimple(String s){
        //Words that start with a,e,i,o,u  add 'hay' to the end of the word
        s = s.toLowerCase();
        String first = s.substring(0,1);
        String rest = s.substring(1);
        if ( first.equals("a") || first.equals("e") || first.equals("i") || first.equals("o") || first.equals("u") ) {
            s = s + "hay";
            return s;
        }
        else {
            return rest+first+"ay";
        }
    }
    public static String pigLatin(String s){
        s = s.toLowerCase();
        String[] digraphs = 
        {"bl","br","ch","ck","cl","cr","dr","fl","fr","gh","gl","gr","ng","ph","pl","pr","qu","sc","sh","sk","sl","sm","sn","sp","st","sw","th","tr","tw","wh","wr"};
        if (s.length() > 1) {
            String direst = s.substring(2);
            String di = s.substring(0,2);
            for (int i = 0; i < digraphs.length; i++) {
                if (di.equals(digraphs[i])) {
                    return direst + di + "ay"; 
                }
            }
        }
        String first = s.substring(0,1);
        String rest = s.substring(1);
        if ( first.equals("a") || first.equals("e") || first.equals("i") || first.equals("o") || first.equals("u") ) {
            s = s + "hay";
            return s;
        }
        else {
            return rest+first+"ay";
        }

    }
    public static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= '0' && c <= '9');
    }

    public static String pigLatinBest(String s){
        boolean hasdigraph = false; //digraph first
        boolean hasvowel = false; //vowel first pos
        boolean haspunctuation = false;
        s = s.toLowerCase();
        if (s.length() > 1) {
            String[] digraphs = 
            {"bl","br","ch","ck","cl","cr","dr","fl","fr","gh","gl","gr","ng","ph","pl","pr","qu","sc","sh","sk","sl","sm","sn","sp","st","sw","th","tr","tw","wh","wr"};
            for (String element : digraphs) {
                if (s.substring(0,2).equals(element)) {
                    hasdigraph = true;
                }
            }
        }
        String first = s.substring(0,1);
        if ( first.equals("a") || first.equals("e") || first.equals("i") || first.equals("o") || first.equals("u") ) {
            hasvowel = true;
        }
        if (!isLetterOrDigit(s.charAt(s.length()-1))) {
            haspunctuation = false;
        }
        //actual return values bloew
        if (s.charAt(0) < 'a' || s.charAt(0) > 'z') { //first char is not a letter --> leave it alone
            return s;
        }
        String end = s.substring(s.length()-1); //end meaning possible punctuation
        if (hasdigraph) {
            String di = s.substring(0,2);
            if (haspunctuation) { //digraph + punctuation
                return (s.substring(2,s.length()-1)) + di + "ay" + end;
            }
            return s.substring(2) + di + "ay";
        }
        if (hasvowel) {
            if (haspunctuation) {
                return (s.substring(1, s.length()-1)) + first + "hay" + end;
            }
            return s.substring(1) + first + "hay";
        }
        else {
            if (haspunctuation) {
                return (s.substring(1, s.length()-1)) + first + "ay" + end;
            }
            return (s.substring(1)) + first + "ay";
        }
        
        
    }

    public static void main( String[]args ){
        
        Scanner text = new Scanner( System.in );
        while(text.hasNextLine()) {
            String line = text.nextLine();
            Scanner eachline = new Scanner(line);
            while(eachline.hasNext()) {
                String word = eachline.next();
                System.out.print(pigLatinBest(word) + " ");
            }
            System.out.println();
        };
        
        System.out.println(pigLatin(args[0]));
    }
}
