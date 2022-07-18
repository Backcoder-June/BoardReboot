import java.sql.*;
import java.util.Scanner;

public class Java_Query_DB {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection
        ("jdbc:mysql://127.0.0.1:3306/board_db", "root", "dnjffl12!@");

        String query = "select * from board_entity";

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);  // select 전용 - ResultSet / executeQuery

        /*while (rs.next()) {
            System.out.print("title : " + rs.getString("title"));

            System.out.println("  ||  contents : " + rs.getString("contents"));
        }

        rs.close();
*/
        String query2 = "insert into board_entity"
                + " values( 11, 'Java SQL', 'with Statement and Connection and Execute update')";

//        st.executeUpdate(query2);

        String query3 = "update board_entity set"
                + " contents = 'updated by java SQL' where id = 11";

//        st.executeUpdate(query3);

        String query4 = "select title from board_entity where contents ='out'";

        ResultSet rs2 = st.executeQuery(query4);

        rs2.next();

//        System.out.println(rs2.getString("조회값"));
        System.out.println(rs2.getString(1));
        System.out.println(rs2.getString("title"));


        String query5 = "delete from board_entity where id = 6";

//        st.executeUpdate(query5);


        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String query6 = "select contents from board_entity where title = '" + input + "'";

        ResultSet rs6 = st.executeQuery(query6);

        rs6.next();
        System.out.println(rs6.getString("contents"));

    }
}
