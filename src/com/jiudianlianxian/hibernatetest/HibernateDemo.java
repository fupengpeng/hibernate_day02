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
 * Title: HibernateDemo
 * Description: 使用hibernate配置好的环境进行增删改查数据库数据
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: hibernate_day01
 * @author fupengpeng
 * @date 2017年8月7日 上午11:24:09
 */
public class HibernateDemo {

	
	@Test
	public void testSaveOrUpdate(){
		//1.调用工具类获取SessionFactory对象
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.：使用SessionFactory创建Session对象
		//理解：类似于jdbc的连接数据库
		Session session = sessionFactory.openSession();
		//3.：开启事务
		Transaction transaction = session.beginTransaction();
		//4.：写具体的crud操作
		
		/*
		 * 修改：
		 *     1.查询
		 *         参数1：所要查询的实体类class
		 *         参数2：id值
		 *     2.修改：向返回的user对象里面设置修改后的值
		 *     3.更新数据
		 *         
		 */
		User user = session.get(User.class, 2);
		user.setUsername("东方不变");
		//3.更新数据
		session.update(user);
		//3.保存数据
		session.save(user);
		
		System.out.println(user);

		
		//5.：提交事务
		transaction.commit();
		//6.：关闭资源
		session.close();
		sessionFactory.close();
	
	}
	
	
	@Test
	public void testDelete(){
		//1.调用工具类获取SessionFactory对象
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.：使用SessionFactory创建Session对象
		//理解：类似于jdbc的连接数据库
		Session session = sessionFactory.openSession();
		//3.：开启事务
		Transaction transaction = session.beginTransaction();
		//4.：写具体的crud操作
		
		/*
		 * 删除方式1：
		 *     1.查询
		 *         参数1：所要查询的实体类class
		 *         参数2：id值
		 *     2.删除
		 *         
		 */
		User user = session.get(User.class, 2);
		//3.删除数据
		session.delete(user);
		
		//删除方式2
		User user2 = new User();
		user2.setUid(2);
		session.delete(user2);
		
		System.out.println(user);

		
		//5.：提交事务
		transaction.commit();
		//6.：关闭资源
		session.close();
		sessionFactory.close();
	
	}
	
	@Test
	public void testUpdate(){
		//1.调用工具类获取SessionFactory对象
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.：使用SessionFactory创建Session对象
		//理解：类似于jdbc的连接数据库
		Session session = sessionFactory.openSession();
		//3.：开启事务
		Transaction transaction = session.beginTransaction();
		//4.：写具体的crud操作
		
		/*
		 * 修改：
		 *     1.查询
		 *         参数1：所要查询的实体类class
		 *         参数2：id值
		 *     2.修改：向返回的user对象里面设置修改后的值
		 *     3.更新数据
		 *         
		 */
		User user = session.get(User.class, 2);
		user.setUsername("东方不变");
		//3.更新数据
		session.update(user);
		//3.保存数据
		session.save(user);
		
		System.out.println(user);

		
		//5.：提交事务
		transaction.commit();
		//6.：关闭资源
		session.close();
		sessionFactory.close();
	
	}
	
	
	@Test
	public void testGet(){
		//1.调用工具类获取SessionFactory对象
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.：使用SessionFactory创建Session对象
		//理解：类似于jdbc的连接数据库
		Session session = sessionFactory.openSession();
		//3.：开启事务
		Transaction transaction = session.beginTransaction();
		//4.：写具体的crud操作
//		User user = new User();
//		user.setUsername("子虚");
//		user.setPassword("85");
//		user.setAddress("续航");
//		//调用session方法实现添加
//		session.save(user);
		
		/*
		 * 查询：
		 *     参数1：所要查询的实体类class
		 *     参数2：id值
		 */
		User user = session.get(User.class, 2);
		
		System.out.println(user);

		
		//5.：提交事务
		transaction.commit();
		//6.：关闭资源
		session.close();
		sessionFactory.close();
		
		
		
		
		
	}
	
	
}
