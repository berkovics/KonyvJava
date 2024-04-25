import java.util.ArrayList;

public class Konyvtarjava {
    public static void main(String[] args) {
        //new DatabaseController();
        //FileController fileCtr = new FileController();
        //fileCtr.ReadKolcsonzesek("Kolcsonzesek.csv");

        DatabaseController dbCtr=new DatabaseController(args[0], args[1]);

        int records=dbCtr.setLendersTable();

        if(records!=0){
            System.out.println("Sikeres írás kiírt rekordok: "+records);
        }else{
            System.out.println("Hiba az írás során ");
        }

        int recordsLendings=dbCtr.setLendingsTable();

        if(recordsLendings!=0){
            System.out.println("Sikeres írás kiírt rekordok: "+recordsLendings);
        }else{
            System.out.println("Hiba az írás során ");
        }
    }
}
