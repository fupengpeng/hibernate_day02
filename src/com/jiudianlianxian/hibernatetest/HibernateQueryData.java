package com.jiudianlianxian.hibernatetest;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.jiudianlianxian.entity.User;
import com.jiudianlianxian.utils.HibernateUtils;


/**
 * 
 * Title: HibernateQueryData
 * Description: 使用hibernate中相关api（Query、Criteria、SQLQuery）对象实现crud操作
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: hibernate_day02
 * @author fupengpeng
 * @date 2017年8月8日 上午10:26:20
 */
public class HibernateQueryData {
	
	//使用SQLQuery对象实现crud操作
	@Test
	public void testSQLQuery(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.：使用SessionFactory创建Session对象
			//理解：类似于jdbc的连接数据库
			session = HibernateUtils.getSessionObject();
			//2.：开启事务
			transaction = session.beginTransaction();
			//3.：写具体的crud操作
			
			//01.创建SQLQuery对象
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");//内含普通sql语句
		    //02.设置返回值中list每部分是对象形式
			sqlQuery.addEntity(User.class);
			//03.调用SQLQuery中的方法实现crud操作
			//返回的是数组
			List<User> list = sqlQuery.list();//得到user表的所有用户数据
			for (User user : list) {
				System.out.println(user);
			}
			
//			//01.创建SQLQuery对象
//			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");//内含普通sql语句
//			//02.调用SQLQuery中的方法实现crud操作
//			//返回的是数组
//			List<Object[]> list = sqlQuery.list();//得到user表的所有用户数据
//			for (Object[] objects : list) {
//				System.out.println(Arrays.toString(objects));
//			}
			
			
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

	
	//使用Criteria对象实现crud操作
	@Test
	public void testCriteria(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.：使用SessionFactory创建Session对象
			//理解：类似于jdbc的连接数据库
			session = HibernateUtils.getSessionObject();
			//2.：开启事务
			transaction = session.beginTransaction();
			//3.：写具体的crud操作
			//01.创建Criteria对象
			Criteria criteria = session.createCriteria(User.class);
			//02.调用Criteria中的方法实现crud操作
			List<User> list = criteria.list();//得到user表的所有用户数据
			for (User user : list) {
				System.out.println(user);
			}
			
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


	//使用query对象实现crud操作
	@Test
	public void testQuery(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.：使用SessionFactory创建Session对象
			//理解：类似于jdbc的连接数据库
			session = HibernateUtils.getSessionObject();
			//2.：开启事务
			transaction = session.beginTransaction();
			//3.：写具体的crud操作
			//01.创建Query对象
			Query query = session.createQuery("from User");
			//02.调用Query中的方法实现crud操作
			List<User> list = query.list();//得到user表的所有用户数据
			for (User user : list) {
				System.out.println(user);
			}
			
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

	
	
}
