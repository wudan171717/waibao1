package service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.AppointDAO;
import dao.UserDAO;

@Service("appointService")//默认的ID为userService
public class AppointService implements Serializable{
	private AppointDAO appointDAO;

	public AppointDAO getAppointDAO() {
		return appointDAO;
	}
@Resource//自动匹配userDao对象并注入
	public void setAppointDAO(AppointDAO appointDAO) {
		this.appointDAO = appointDAO;
	}

public void appoint(String content, String usename, String name) {
	appointDAO.appoint(content,usename,name);
}
}
