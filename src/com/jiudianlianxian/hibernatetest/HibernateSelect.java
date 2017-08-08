package com.jiudianlianxian.hibernatetest;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.jiudianlianxian.entity.User;
import com.jiudianlianxian.utils.HibernateUtils;


/**
 * 
 * Title: HibernateSelect
 * Description: 验证一级缓存的存在
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: hibernate_day02
 * @author fupengpeng
 * @date 2017年8月8日 上午8:39:52
 */
public class HibernateSelect {

	//事务规范代码结构和使用与本地线程绑定的session对象
	@Test
	public void testTx(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.：使用SessionFactory创建Session对象
			//理解：类似于jdbc的连接数据库
			session = HibernateUtils.getSessionObject();
			//2.：开启事务
			transaction = session.beginTransaction();
			//3.：写具体的crud操作
			
			/*
			 * 查询：
			 *     参数1：所要查询的实体类class
			 *     参数2：id值
			 */
			User user = session.get(User.class, 2);
			
			System.out.println(user);
			
			//4.：提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.回滚事务
			transaction.rollback();
		} finally {
			//6.：关闭资源     在使用了与本地线程绑定的session对象之后，就不需要手动关闭session了
//			session.close();
		}
	}
	
	
	//演示一级缓存的特性
	@Test
	public void testDemo(){
		//1.调用工具类获取SessionFactory对象
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.：使用SessionFactory创建Session对象
		//理解：类似于jdbc的连接数据库
		Session session = sessionFactory.openSession();
		//3.：开启事务
		Transaction transaction = session.beginTransaction();
		//4.：写具体的crud操作
		
		/*
		 * 查询：
		 *     参数1：所要查询的实体类class
		 *     参数2：id值
		 */
		User user = session.get(User.class, 2);
		
		System.out.println(user);

		//第二次查询时，不再去数据库查询，而是在一级缓存中查询，
		User user2 = session.get(User.class, 2);
		
		System.out.println("user2="+user2);
		//5.：提交事务
		transaction.commit();
		//6.：关闭资源
		session.close();
		sessionFactory.close();
		
		
		
		
		
	}
	
	
	//验证一级缓存的存在
	@Test
	public void testCasch(){
		//1.调用工具类获取SessionFactory对象
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.：使用SessionFactory创建Session对象
		//理解：类似于jdbc的连接数据库
		Session session = sessionFactory.openSession();
		//3.：开启事务
		Transaction transaction = session.beginTransaction();
		//4.：写具体的crud操作
		
		/*
		 * 查询：
		 *     参数1：所要查询的实体类class
		 *     参数2：id值
		 */
		User user = session.get(User.class, 2);
		
		System.out.println(user);

		//第二次查询时，不再去数据库查询，而是在一级缓存中查询，
		User user2 = session.get(User.class, 2);
		
		System.out.println("user2="+user2);
		//5.：提交事务
		transaction.commit();
		//6.：关闭资源
		session.close();
		sessionFactory.close();
		
		
		
		
		
	}
	
	
}
