package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component//使默认id为jdbcDataSource
public class JdbcDataSource implements Serializable{
	
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	private Connection connection;
	
	private String driver;
	@Value("#{jdbcProps.url}")
	private String url;
	@Value("#{jdbcProps.user}")
	private String user;
	@Value("#{jdbcProps.pwd}")
	private String pwd;
	public String getDriver() {
		return driver;
	}
	
	//必须使用Bean属性输入，否则不能进行JDBC Driver注册
	@Value("#{jdbcProps.driver}")
	public void setDriver(String driver) {
		//注册数据库驱动
		try {
			Class.forName(driver);
			this.driver = driver;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	public Connection getConnection() throws SQLException{
		Connection conn=DriverManager.getConnection(url, user, pwd);
		return conn;
	}
	
	public void close(Connection conn){
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public List<Map<String, Object>> findResult(String sql, List<?> params)
			throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int index = 1;
		pstmt = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		return list;
	}

}
