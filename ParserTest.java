import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ParserTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        // Demander à l'utilisateur s'il veut entrer du texte ou utiliser le fichier pgmsrc.exp
        System.out.println("Choose input type:");
        System.out.println("1. Enter program source text");
        System.out.println("2. Use the default file (pgmesrc.exp)");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consommer la nouvelle ligne après le choix

        if (choice == 1) {
            // L'utilisateur entre directement du texte
            System.out.println("Please enter the program source text:");
            input = scanner.nextLine();
        } else if (choice == 2) {
            // L'utilisateur veut utiliser le fichier pgmsrc.exp
            String filePath = "pgmesrc.exp";  // Nom du fichier par défaut

            try {
                // Lire le fichier si le chemin existe
                if (Files.exists(Paths.get(filePath))) {
                    input = new String(Files.readAllBytes(Paths.get(filePath)));
                } else {
                    System.err.println("Error: File pgmesrc.exp not found!");
                    System.exit(1);
                }
            } catch (IOException e) {
                System.err.println("Error reading file:");
                e.printStackTrace();
                System.exit(1);
            }
        } else {
            System.err.println("Invalid choice, exiting.");
            System.exit(1);
        }

        System.out.println("Starting parsing...");
        try {
            System.out.println("Input program:");
            System.out.println(input);

            // Créer le parser avec le contenu
            Parser parser = new Parser(new java.io.ByteArrayInputStream(input.getBytes()));
            parser.initASTWriter("test_ast_output.txt");

            System.out.println("Calling parser.E()");
            parser.E();

            // Fermer le writer à la fin
            parser.closeASTWriter();

            System.out.println("Parsing completed successfully");
        } catch (ParseException e) {
            System.err.println("Error during parsing:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
