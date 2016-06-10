package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Repository;

@Repository("appointDAO")
//指定特定的BEAN ID 方便setUserDao注入
public class MySQLAppointDAO implements Serializable, AppointDAO {

	private JdbcDataSource dataSource;

	public MySQLAppointDAO() {
	}

	public JdbcDataSource getDataSource() {
		return dataSource;
	}

	@Inject
	public void setDataSource(@Named("jdbcDataSource") JdbcDataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	@Override
	public void appoint(String content, String usename, String name) {
			String sql = "INSERT INTO yuyue (name,number,content)VALUES(?,?,?);";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, usename);
				pstmt.setString(3, content);
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			} finally {
				dataSource.close(conn);
			}
	}
	

}
