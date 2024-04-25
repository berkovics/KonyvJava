import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseController {

    private Connection conn;
    private String lenderFile;
    private String lendingFile;

    public DatabaseController(String lenderFile, String lendingFile){
        
        this.lenderFile=lenderFile;
        this.lendingFile=lendingFile;
        buildConnection();
    }

    private void buildConnection(){
        Connect connect = new Connect();
        connect.connecting();
        conn = connect.getConnection();
        //System.out.println(conn.toString());
    }

    public int setLendersTable(){
        ArrayList<Lender> lenders= new ArrayList<>();
        FileController fileCtr=new FileController();
        lenders =fileCtr.ReadKolcsonzok(lenderFile);
        int counter=0;

        String sql="INSERT INTO lenders(name, born) "+"( ? , ?)";
        PreparedStatement pstmt=null;
        try{
            pstmt=conn.prepareStatement(sql);

            for(Lender len : lenders){
                pstmt.setString(1, len.getName());
                pstmt.setDate(2, Date.valueOf(len.getBorn()));

                pstmt.executeQuery();
                counter++;
            }

        }catch(SQLException ex){
            System.out.println("Hiba az írás során");
        }
        return counter;
    }

    public int setLendingsTable(){
        ArrayList<Lending> lendings = new ArrayList<>();
        FileController fileCtr= new FileController();
        lendings=fileCtr.ReadKolcsonzesek(lendingFile);
        String sql="INSERT INTO lendings(writer, type, title, lende_id) "+"( ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        int counter=0;

        try {
            for(Lending lend : lendings){
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, lend.getWriter());
                pstmt.setString(2, lend.getType());
                pstmt.setString(3, lend.getTitle());
                pstmt.setInt(4, Integer.parseInt(lend.getLender_id()));
                
                pstmt.executeQuery();
                counter++;
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return counter;
    }
}
