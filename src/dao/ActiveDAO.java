package dao;

import java.util.List;

import entity.Community;

public interface ActiveDAO {

	public List<Community> activeFindAll();

	public List<Community> activeFindByType(String type);

	public List<Community> activeFindByStatue(String statue);

	public List<Community> activeFindByWriter(String writer);

	public Community ActiveFindById(String id);
}
