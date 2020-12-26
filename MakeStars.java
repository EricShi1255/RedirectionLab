import java.util.*;
public class MakeStars {

public static void main( String[]args ){
    Scanner text = new Scanner( System.in );
    while(text.hasNextLine()) {
        String line = text.nextLine();
        Scanner eachline = new Scanner(line);
        while(eachline.hasNext()) {
            String word = eachline.next();
            System.out.println(word);
        }
    }
    
}

}