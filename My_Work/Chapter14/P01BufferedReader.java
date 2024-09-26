package Chapter14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author oracle
 */
public class P01BufferedReader {
    
    public static void main(String[] args) {
        
        try{
            BufferedReader bReader = 
                new BufferedReader(new FileReader("C:\\Bootcamp\\Java_Bootcamp\\Java_Advance\\My_Work\\Chapter14\\hamlet.txt"));
            
            System.out.println("=== Entire File ===");
            bReader.lines()
                .forEach(line -> 
                    System.out.println(line));
                        
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    } 
}
