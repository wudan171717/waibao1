package service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDAO;
import entity.User;

@Service("userService")//Ĭ�ϵ�IDΪuserService
public class UserService implements Serializable{
	private UserDAO userDao;

	public UserDAO getUserDao() {
		return userDao;
	}
@Resource//�Զ�ƥ��userDao����ע��
	public void setUserDAO(UserDAO userDao) {
		this.userDao = userDao;
	}

	public User login(String username, String pwd) throws NullParamException,NameOrPwdException{
		if(username==null||pwd.equals("")||pwd==null||username.equals("")){
			throw new NullParamException("��¼��������Ϊ��");
		}
		User user=userDao.findByName(username);
		if(username!=null&&pwd.equals(user.getPwd()))
		{return user;}
		throw new NameOrPwdException("�û��������������");
	}
	public void register(String username, String pwd, String name, String gender, String classes, String major, String email) {
		userDao.register(username, pwd,name,gender,classes,major,email);
		
	}
	public User checkname(String username) {
		User user=userDao.findByName(username);
		return user;
	}
	public void appoint(String gender, int number, String major, int classes,
			String email, int photo) {
		userDao.appoint(gender, number,major,classes,email,photo);
		
	}}






