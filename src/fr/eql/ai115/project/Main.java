package fr.eql.ai115.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    private static final String SOURCE_FILE = "stagiaires.txt";
    private static final String BINARY_FILE = "stagiaires.bin";
    public static void main(String[] args) {
        try {
            InternCatalog catalog = new InternCatalog(SOURCE_FILE, BINARY_FILE);
            List<String> myList = catalog.formattedString();
            List<Intern> myInternList = catalog.createVector((ArrayList<String>) myList);
            for (Intern intern : myInternList) {
                System.out.println(intern.getPromotion()+ " " + intern.getLastName() + " " +
                        intern.getFirstName() + " " + intern.getYear() + " " + intern.getDepartment());
            }
        } catch (FileNotFoundException e) {
            logger.error("Impossible d'accéder au fichier binaire des objets célestes.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
