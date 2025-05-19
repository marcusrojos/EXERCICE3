import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class WordCounter {
    public static void main(String[] args) {
        // Scanner pour l'entrée utilisateur (ne pas fermer celui-ci !)
        Scanner userInput = new Scanner(System.in);
        System.out.println("Entrez le chemin complet du fichier à analyser :");
        String filePath = userInput.nextLine();

        // Utilisation de try-with-resources pour le Scanner du fichier
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            int totalWords = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // \\s+ gère un ou plusieurs espaces/retours à la ligne
                String[] words = line.split("\\s+");
                totalWords += words.length;
            }

            System.out.println("Le fichier contient " + totalWords + " mots.");

        } catch (FileNotFoundException e) {
            System.err.println("Erreur : Fichier non trouvé - " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur inattendue : " + e.getMessage());
        }
    }
}