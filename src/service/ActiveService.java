package service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ActiveDAO;
import entity.Community;

@Service("activeService")//默认的ID为activeService
public class ActiveService implements Serializable{
	private ActiveDAO activeDAO;

	public ActiveDAO getActiveDAO() {
		return activeDAO;
	}
@Resource//自动匹配ActiveDAO对象并注入
	public void setActiveDAO(ActiveDAO activeDAO) {
		this.activeDAO = activeDAO;
	}

public List<Community> activeFindAll() {
	List <Community> communities=activeDAO.activeFindAll();
	return communities;
}
public List<Community> activeFindByType(String type) {
	List <Community> communities=activeDAO.activeFindByType(type);
	return communities;
}
public List<Community> activeFindByStatue(String statue) {
	List <Community> communities=activeDAO.activeFindByStatue(statue);
	return communities;
}
public List<Community> activeFindByWriter(String writer) {
	List <Community> communities=activeDAO.activeFindByWriter(writer);
	return communities;
}
public Community ActiveFindById(String id) {
	Community community=activeDAO.ActiveFindById(id);
	return community;
}
}
