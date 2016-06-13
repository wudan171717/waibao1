package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Repository;

import entity.Community;
import entity.Teacher;

@Repository("activeDAO")
//指定特定的BEAN ID 方便setUserDao注入
public class MySQLActiveDAO implements Serializable, ActiveDAO {

	private JdbcDataSource dataSource;

	public MySQLActiveDAO() {
	}

	public JdbcDataSource getDataSource() {
		return dataSource;
	}

	@Inject
	public void setDataSource(@Named("jdbcDataSource") JdbcDataSource dataSource) {
		this.dataSource = dataSource;
	}


	public List<Community> activeFindAll() {
		List<Community> communities=new ArrayList<Community>();
		String sql = "select * from shetuan ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Community community=null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				community = new Community();
				community.setId(rs.getInt("id"));
				community.setName(rs.getString("name"));
				community.setAddress(rs.getString("address"));
				community.setContent(rs.getString("content"));
				community.setTime(rs.getString("time"));
				community.setImg(rs.getString("img"));
				community.setImgs(rs.getString("imgs"));
				community.setWriter(rs.getString("writer"));
				communities.add(community);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
		return communities;
		
	}

	public List<Community> activeFindByType(String type) {
		List<Community> communities=new ArrayList<Community>();
		String sql = "select * from shetuan where type=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Community community=null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				community = new Community();
				community.setId(rs.getInt("id"));
				community.setName(rs.getString("name"));
				community.setAddress(rs.getString("address"));
				community.setContent(rs.getString("content"));
				community.setTime(rs.getString("time"));
				community.setImg(rs.getString("img"));
				community.setImgs(rs.getString("imgs"));
				community.setWriter(rs.getString("writer"));
				communities.add(community);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
		return communities;
		
	}

	public List<Community> activeFindByStatue(String statue) {
		List<Community> communities=new ArrayList<Community>();
		String sql = "select * from shetuan where statue=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Community community=null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, statue);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				community = new Community();
				community.setId(rs.getInt("id"));
				community.setName(rs.getString("name"));
				community.setAddress(rs.getString("address"));
				community.setContent(rs.getString("content"));
				community.setTime(rs.getString("time"));
				community.setImg(rs.getString("img"));
				community.setImgs(rs.getString("imgs"));
				community.setWriter(rs.getString("writer"));
				communities.add(community);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
		return communities;
	}

	public List<Community> activeFindByWriter(String writer) {
		List<Community> communities=new ArrayList<Community>();
		String sql = "select * from shetuan where writer=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Community community=null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				community = new Community();
				community.setId(rs.getInt("id"));
				community.setName(rs.getString("name"));
				community.setAddress(rs.getString("address"));
				community.setContent(rs.getString("content"));
				community.setTime(rs.getString("time"));
				community.setImg(rs.getString("img"));
				community.setImgs(rs.getString("imgs"));
				community.setWriter(rs.getString("writer"));
				communities.add(community);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
		return communities;
	}

	@Override
	public Community ActiveFindById(String id) {
		String sql = "select * from shetuan where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Community community=null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				community = new Community();
				community.setId(rs.getInt("id"));
				community.setName(rs.getString("name"));
				community.setAddress(rs.getString("address"));
				community.setContent(rs.getString("content"));
				community.setTime(rs.getString("time"));
				community.setImg(rs.getString("img"));
				community.setImgs(rs.getString("imgs"));
				community.setWriter(rs.getString("writer"));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
		return community;
		
	}

	}
	

