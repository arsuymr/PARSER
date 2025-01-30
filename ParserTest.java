import java.io.*;

public class ParserTest {
    public static void main(String[] args) {
        try {
            String inputString = "Id9ft55_";
            System.out.println("Starting parsing...");
            InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
            Parser parser = new Parser(inputStream);
            System.out.println("Calling parser.E()");
            parser.E();
            System.out.println("Parsing completed successfully.");
        } catch (ParseException e) {
            System.out.println("Parse exception occurred: " + e.getMessage());
        }
    }
}
