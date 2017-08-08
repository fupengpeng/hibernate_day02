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
 * Description: ʹ��hibernate�����api��Query��Criteria��SQLQuery������ʵ��crud����
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: hibernate_day02
 * @author fupengpeng
 * @date 2017��8��8�� ����10:26:20
 */
public class HibernateQueryData {
	
	//ʹ��SQLQuery����ʵ��crud����
	@Test
	public void testSQLQuery(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.��ʹ��SessionFactory����Session����
			//��⣺������jdbc���������ݿ�
			session = HibernateUtils.getSessionObject();
			//2.����������
			transaction = session.beginTransaction();
			//3.��д�����crud����
			
			//01.����SQLQuery����
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");//�ں���ͨsql���
		    //02.���÷���ֵ��listÿ�����Ƕ�����ʽ
			sqlQuery.addEntity(User.class);
			//03.����SQLQuery�еķ���ʵ��crud����
			//���ص�������
			List<User> list = sqlQuery.list();//�õ�user��������û�����
			for (User user : list) {
				System.out.println(user);
			}
			
//			//01.����SQLQuery����
//			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");//�ں���ͨsql���
//			//02.����SQLQuery�еķ���ʵ��crud����
//			//���ص�������
//			List<Object[]> list = sqlQuery.list();//�õ�user��������û�����
//			for (Object[] objects : list) {
//				System.out.println(Arrays.toString(objects));
//			}
			
			
			//4.���ύ����
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.�ع�����
			transaction.rollback();
		} finally {
			//6.���ر���Դ     ��ʹ�����뱾���̰߳󶨵�session����֮�󣬾Ͳ���Ҫ�ֶ��ر�session��
//			session.close();
		}
	}

	
	//ʹ��Criteria����ʵ��crud����
	@Test
	public void testCriteria(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.��ʹ��SessionFactory����Session����
			//��⣺������jdbc���������ݿ�
			session = HibernateUtils.getSessionObject();
			//2.����������
			transaction = session.beginTransaction();
			//3.��д�����crud����
			//01.����Criteria����
			Criteria criteria = session.createCriteria(User.class);
			//02.����Criteria�еķ���ʵ��crud����
			List<User> list = criteria.list();//�õ�user��������û�����
			for (User user : list) {
				System.out.println(user);
			}
			
			//4.���ύ����
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.�ع�����
			transaction.rollback();
		} finally {
			//6.���ر���Դ     ��ʹ�����뱾���̰߳󶨵�session����֮�󣬾Ͳ���Ҫ�ֶ��ر�session��
//			session.close();
		}
	}


	//ʹ��query����ʵ��crud����
	@Test
	public void testQuery(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.��ʹ��SessionFactory����Session����
			//��⣺������jdbc���������ݿ�
			session = HibernateUtils.getSessionObject();
			//2.����������
			transaction = session.beginTransaction();
			//3.��д�����crud����
			//01.����Query����
			Query query = session.createQuery("from User");
			//02.����Query�еķ���ʵ��crud����
			List<User> list = query.list();//�õ�user��������û�����
			for (User user : list) {
				System.out.println(user);
			}
			
			//4.���ύ����
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.�ع�����
			transaction.rollback();
		} finally {
			//6.���ر���Դ     ��ʹ�����뱾���̰߳󶨵�session����֮�󣬾Ͳ���Ҫ�ֶ��ر�session��
//			session.close();
		}
	}

	
	
}
