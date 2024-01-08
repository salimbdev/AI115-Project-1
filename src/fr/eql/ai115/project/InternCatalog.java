package fr.eql.ai115.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
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

    private String splitMyString(String string){
        StringBuffer sb = new StringBuffer();
        String s3 = string.replaceAll("\r\n", " ");
        System.out.println(s3);
        sb.append(string);
        return sb.toString();
    }

    private Intern createIntern(String chaine){
        Intern intern=null;
        String chaineTokenizer = splitMyString(chaine);
        StringTokenizer st = new StringTokenizer(chaineTokenizer, "\r\n");
        if(st.countTokens()==5){
            String promotion = st.nextToken();
            int year = Integer.parseInt(st.nextToken());
            String lastName = st.nextToken();
            String firstName= st.nextToken();
            int department = Integer.parseInt(st.nextToken());
            intern = new Intern(lastName, firstName, promotion, department, year);
        }
        return intern;
    }

    public List<Intern> createVector(){
        String chaine;
        Intern intern;
        List<Intern> interns = new Vector<Intern>();
        try{
            do{
                chaine = bfr.readLine();
//                System.out.println(chaine);

                if(chaine!=null){
                    intern= createIntern(chaine);
                    interns.add(intern);
                }
            }while(chaine!=null);

        }catch(IOException e){
            System.out.println("Problème de lecture : " +e.getMessage());
        }
        return interns;
    }
}
