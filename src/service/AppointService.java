package service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.AppointDAO;
import dao.UserDAO;

@Service("appointService")//Ĭ�ϵ�IDΪuserService
public class AppointService implements Serializable{
	private AppointDAO appointDAO;

	public AppointDAO getAppointDAO() {
		return appointDAO;
	}
@Resource//�Զ�ƥ��userDao����ע��
	public void setAppointDAO(AppointDAO appointDAO) {
		this.appointDAO = appointDAO;
	}

public void appoint(String content, String usename, String name) {
	appointDAO.appoint(content,usename,name);
}
}
