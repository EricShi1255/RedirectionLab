import java.util.*;
public class MakeStars {

public static void main( String[]args ){
    Scanner text = new Scanner( System.in );
    while(text.hasNextLine()) {
        String line = text.nextLine();
        Scanner eachline = new Scanner(line);
        while(eachline.hasNext()) {
            String word = eachline.next();
            String stars = "";
            for (int i = 0; i < word.length(); i++) {
                stars+="*";
            } 
            System.out.print(stars);
            System.out.print(" ");
        }
        System.out.println();
    }
    
}

}