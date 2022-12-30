package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectJoinEmp {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String passwd = "tiger";
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT ename, dname FROM emp INNER JOIN dept USING (deptno)");
		System.out.printf("%8s%8s\n", "성명", "부서명");
		System.out.println("  -----------------------------------");
		while (rs.next()) {
			System.out.printf("%10s%12s\n", rs.getString("ename"), rs.getString("dname"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
