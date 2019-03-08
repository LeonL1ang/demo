package wiki.leon.demo.ibatis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao<T> extends SqlMapClientDaoSupport {
	
	@Autowired
	private SqlMapClientTemplate sqlTemplate;

	public Object insert(T t) {
		return sqlTemplate.insert("insert", t);
	}
	
	public int deleteById(Integer id) {
		return sqlTemplate.delete("deleteById", id);
	}
	
	public void update(T t) {
		sqlTemplate.update("", t);
	}
	
	public T selectOne(Integer id) {
		return (T) sqlTemplate.queryForObject("userDao.selectOne", id);
	}
	
	public List<T> selectAll(){
		return sqlTemplate.queryForList("selectAll");
	}
}
