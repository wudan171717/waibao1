package dao;

import entity.User;

public interface UserDAO {
	public User findByName(String username);
	public void register(String username,String pwd,String name, String gender, String classes, String major, String photo);
	public void appoint(String gender, int number, String major, int classes,String email, int photo);
}
