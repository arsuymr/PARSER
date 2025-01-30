import java.io.*;

public class ParserTest {
    public static void main(String[] args) {
        try {
            String inputString = "()";
            System.out.println("Starting parsing...");

            // Simuler l'entrée avec un ByteArrayInputStream
            InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
            
            // Initialiser le parser avec l'InputStream
            Parser parser = new Parser(inputStream);
            System.out.println("Calling parser.Z()");
            parser.Z();
            System.out.println("Parsing completed successfully.");
        } catch (ParseException e) {
            System.out.println("Parse exception occurred: " + e.getMessage());
        }
    }
}
