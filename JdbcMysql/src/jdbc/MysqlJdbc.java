/**
 * 
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Administrator
 *
 */
public class MysqlJdbc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");  //mysql
		Connection con=DriverManager.getConnection("jdbc:mysql://10.1.1.205:3306/test", "root", "123");   //mysql:ip地址：root/密码
		String sql="insert into jzzz(id,jzzz_zt ,jzzz_mc ,jzzz_bmsah ,jzzz_ajlbmc ,jzzz_bz )values(?,?,?,?,?,?)";   //
		System.out.println(sql);
		PreparedStatement ps=con.prepareStatement(sql);
		String line = null;  
		int count=100;
        while (count<1000) {  
            ps.setInt(1, count);
            ps.setString(2, "zt"+count);  
            ps.setString(3, "mc"+count);  
            ps.setString(4, "bmsah"+count);  
            ps.setString(5, "ajlbmc"+count);  
            ps.setString(6, "bz"+count);  
            ps.addBatch();          // 加入批量处理  
            count++;              
        }  
        ps.executeBatch(); // 执行批量处理  
        con.commit();  // 提交  
        System.out.println("All down : " + count);  
        con.close();  
	}
}
