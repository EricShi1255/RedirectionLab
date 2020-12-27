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
        String first = s.substring(0,1);
        String rest = s.substring(1);
        String direst = s.substring(2);
        String di = s.substring(0,2);
        for (int i = 0; i < digraphs.length; i++) {
            if (di.equals(digraphs[i])) {
                return direst + di + "ay"; 
            }
        }
        if ( first.equals("a") || first.equals("e") || first.equals("i") || first.equals("o") || first.equals("u") ) {
            s = s + "hay";
            return s;
        }
        else {
            return rest+first+"ay";
        }

    }
    public static void main( String[]args ){
        System.out.println(pigLatin(args[0]));
    }
}
