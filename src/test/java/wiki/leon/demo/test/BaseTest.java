package wiki.leon.demo.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wiki.leon.demo.ibatis.dao.UserDao;
import wiki.leon.demo.ibatis.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations={"classpath:application.xml"}) //加载配置文件   
//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例    
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！    
//@Transactional    
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！    
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)    
public class BaseTest {
	
	@Autowired
	UserDao<User> UserDao;
	
	@Test
	public void insert(){
		User user = new User();
		Date date = new Date();
		user.setCreateTime(date);
		user.setEmail("l@qq.com");
		user.setHeadImg("我的头像。jpg");
		user.setLoginTime(date);
		user.setCreateTime(date);
		user.setPassword("+++++****");
		user.setUpdateTime(date);
		user.setName("Leon");
		System.out.println(UserDao.insert(user));
		System.out.println("_______________________________________");
	}
	
	@Test
	public void selectOne() {
		
		System.out.println(UserDao.selectOne(2));
		System.out.println("_________________________________________");
		
	}

	
	@Test
	public void selectAll() {
		List<User> list = UserDao.selectAll();
		for(User u : list) {
			System.out.println(u);
		}
		System.out.println("_________________________________________");
		
	}
	
	@Test
	public void delectById() {
		System.out.println(UserDao.deleteById(1));
	}
}
