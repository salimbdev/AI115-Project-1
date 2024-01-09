package fr.eql.ai115.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class InternCatalog {
    private static final Logger logger = LogManager.getLogger();
    private BufferedReader bfr;


    private static final int LASTNAME_LENGTH = 30;
    private static final int FIRSTNAME_LENGTH = 30;
    private static final int PROMOTION_LENGTH = 15;
    private static final int DEPARTMENT_LENGTH = 3;
    private static final int YEARS_LENGTH = 4;
    private static final int CHILD_LEFT_NODE_POINTER_LENGTH = 10;
    private static final int CHILD_RIGHT_NODE_POINTER_LENGTH = 10;
    private static final int INTERN_LENGTH = LASTNAME_LENGTH + FIRSTNAME_LENGTH + PROMOTION_LENGTH +
            DEPARTMENT_LENGTH + YEARS_LENGTH + CHILD_LEFT_NODE_POINTER_LENGTH + CHILD_RIGHT_NODE_POINTER_LENGTH;
    private static final int INTERN_RAF_LENGTH = INTERN_LENGTH * 2;

    private final String sourceFile;
    private final RandomAccessFile raf;
    private int internsCount;




    /**
     * This constructor will create the RandomAccessFile instance used to write and read celestial objects.
     * @param sourceFile The path to the text file containing the list of
     *                   interns to write in the binary file.
     * @param binaryFile The path to the binary file.
     * @throws FileNotFoundException When the creation or access to the binary file fails.
     */
    public InternCatalog(String sourceFile, String binaryFile) throws FileNotFoundException {
        this.sourceFile = sourceFile;
        raf = new RandomAccessFile(binaryFile, "rw");

        try {
            FileReader in = new FileReader(sourceFile);
            bfr= new BufferedReader(in);
        } catch (IOException e){
            System.out.println("Pb entrée sortie :" + e.getMessage());
        }
    }

    public List<String> formattedString() throws IOException {
        List<String> arrayListString = new ArrayList<>();
        try {
            // Variable pour stocker chaque ligne formatée
            StringBuilder formattedLine = new StringBuilder();

            // Boucle de lecture des lignes du fichier d'entrée
            String line;
            while ((line = bfr.readLine()) != null) {
                // Supprime les astérisques (*)
                line = line.replace("*", "");


                // Ajoute chaque élément de la ligne formatée à la StringBuilder
                formattedLine.append("*").append(line);
                // Si la ligne contient un espace vide, écrire la ligne formatée dans le fichier
                if (line.trim().isEmpty()) {
                    arrayListString.add(formattedLine.toString().trim());

                    // Réinitialise la StringBuilder pour la ligne suivante
                    formattedLine.setLength(0);
                }
            }

            // Ferme les lecteurs et flux d'écriture
            bfr.close();

        } catch (IOException e) {
            logger.error(e);
        }
        return arrayListString;
    }


    //Transformer le fichier en une collection d'employés
    public List<Intern> createVector(ArrayList<String> myList){
        String chaine;
        Intern intern;
        List<Intern> interns = new Vector<Intern>();
        for (String str : myList) {
            chaine = str;
            if(chaine!=null){
                intern= createIntern(chaine);
                interns.add(intern);
            }
        }

        return interns;
    }

    // Transforme une chaine en un objet de type Employe
    //format de la chaine : 1*BARBE*Rue des Vignes Paris*0123546789*10000
    private Intern createIntern(String chaine){
        Intern intern=null;
        StringTokenizer st = new StringTokenizer(chaine, "*");
        if(st.countTokens()==5){
            String promotion = st.nextToken();
            int year = Integer.parseInt(st.nextToken());
            String lastName= st.nextToken();
            String firstName = st.nextToken();
            int department= Integer.parseInt(st.nextToken());
            intern = new Intern(lastName,firstName,promotion,department,year);
        }
        return intern;
    }
}
