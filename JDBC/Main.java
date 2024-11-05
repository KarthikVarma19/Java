import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pwd = "Karthik@1579";

        // String sql = "SELECT * from student"; Fetching the Data
        // String sql = "INSERT INTO student VALUES(6,'Rahul',100)";
        //String sql = "UPDATE student SET sname='Max' WHERE sid=6";
        //String sql = "DELETE FROM student WHERE sid=6";
        //Class.forName("org.postgresql.Driver"); Not So Important
        Connection con = DriverManager.getConnection(url,uname,pwd);
        System.out.println("Connection Established");
        //Statement stmt = con.createStatement();
        String sql = "INSERT INTO student VALUES(?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,7);
        st.setString(2, "Karthik");
        st.setInt(3,100);
        st.execute();
        /*
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.println(rs.getInt(3));
        }
        */
        //stmt.executeQuery();
        con.close();
        System.out.println("Connection Closed");
    }
}