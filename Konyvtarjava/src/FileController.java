import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileController {
    public FileController(){

    }

    public ArrayList<Lending> ReadKolcsonzesek(String filename){
        FileReader fr = null;

        try {
            fr = new FileReader("../" + filename);
        } catch (FileNotFoundException ex) {
            System.out.println("Nincs meg a fájl!");
        }

        Scanner scan = new Scanner(fr);
        ArrayList<Lending> lendings = new ArrayList<>();
        scan.nextLine();

        while (scan.hasNext()) {
            String row = scan.nextLine();
            String[] rowSp = row.split(";");

            Lending lending = new Lending();
            lending.setLender_id(rowSp[0]);
            lending.setWriter(rowSp[1]);
            lending.setType(rowSp[2]);
            lending.setTitle(rowSp[3]);

            lendings.add(lending);
        }
        return lendings;
    }

    public ArrayList<Lender> ReadKolcsonzok(String filename){
        FileReader fr = null;

        try {
            fr = new FileReader("../" + filename);
        } catch (FileNotFoundException ex) {
            System.out.println("Nincs meg a fájl!");
        }

        Scanner scan = new Scanner(fr);
        ArrayList<Lender> lenders = new ArrayList<>();
        scan.nextLine();

        while (scan.hasNext()) {
            String row = scan.nextLine();
            String[] rowSp = row.split(";");

            Lender lender = new Lender();
            lender.setName(rowSp[0]);
            lender.setBorn(rowSp[1]);
            
            lenders.add(lender);
        }
        return lenders;
    }
}
