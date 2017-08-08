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
 * Description: ʹ��hibernate���úõĻ���������ɾ�Ĳ����ݿ�����
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: hibernate_day01
 * @author fupengpeng
 * @date 2017��8��7�� ����11:24:09
 */
public class HibernateDemo {

	
	@Test
	public void testSaveOrUpdate(){
		//1.���ù������ȡSessionFactory����
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.��ʹ��SessionFactory����Session����
		//��⣺������jdbc���������ݿ�
		Session session = sessionFactory.openSession();
		//3.����������
		Transaction transaction = session.beginTransaction();
		//4.��д�����crud����
		
		/*
		 * �޸ģ�
		 *     1.��ѯ
		 *         ����1����Ҫ��ѯ��ʵ����class
		 *         ����2��idֵ
		 *     2.�޸ģ��򷵻ص�user�������������޸ĺ��ֵ
		 *     3.��������
		 *         
		 */
		User user = session.get(User.class, 2);
		user.setUsername("��������");
		//3.��������
		session.update(user);
		//3.��������
		session.save(user);
		
		System.out.println(user);

		
		//5.���ύ����
		transaction.commit();
		//6.���ر���Դ
		session.close();
		sessionFactory.close();
	
	}
	
	
	@Test
	public void testDelete(){
		//1.���ù������ȡSessionFactory����
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.��ʹ��SessionFactory����Session����
		//��⣺������jdbc���������ݿ�
		Session session = sessionFactory.openSession();
		//3.����������
		Transaction transaction = session.beginTransaction();
		//4.��д�����crud����
		
		/*
		 * ɾ����ʽ1��
		 *     1.��ѯ
		 *         ����1����Ҫ��ѯ��ʵ����class
		 *         ����2��idֵ
		 *     2.ɾ��
		 *         
		 */
		User user = session.get(User.class, 2);
		//3.ɾ������
		session.delete(user);
		
		//ɾ����ʽ2
		User user2 = new User();
		user2.setUid(2);
		session.delete(user2);
		
		System.out.println(user);

		
		//5.���ύ����
		transaction.commit();
		//6.���ر���Դ
		session.close();
		sessionFactory.close();
	
	}
	
	@Test
	public void testUpdate(){
		//1.���ù������ȡSessionFactory����
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.��ʹ��SessionFactory����Session����
		//��⣺������jdbc���������ݿ�
		Session session = sessionFactory.openSession();
		//3.����������
		Transaction transaction = session.beginTransaction();
		//4.��д�����crud����
		
		/*
		 * �޸ģ�
		 *     1.��ѯ
		 *         ����1����Ҫ��ѯ��ʵ����class
		 *         ����2��idֵ
		 *     2.�޸ģ��򷵻ص�user�������������޸ĺ��ֵ
		 *     3.��������
		 *         
		 */
		User user = session.get(User.class, 2);
		user.setUsername("��������");
		//3.��������
		session.update(user);
		//3.��������
		session.save(user);
		
		System.out.println(user);

		
		//5.���ύ����
		transaction.commit();
		//6.���ر���Դ
		session.close();
		sessionFactory.close();
	
	}
	
	
	@Test
	public void testGet(){
		//1.���ù������ȡSessionFactory����
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.��ʹ��SessionFactory����Session����
		//��⣺������jdbc���������ݿ�
		Session session = sessionFactory.openSession();
		//3.����������
		Transaction transaction = session.beginTransaction();
		//4.��д�����crud����
//		User user = new User();
//		user.setUsername("����");
//		user.setPassword("85");
//		user.setAddress("����");
//		//����session����ʵ�����
//		session.save(user);
		
		/*
		 * ��ѯ��
		 *     ����1����Ҫ��ѯ��ʵ����class
		 *     ����2��idֵ
		 */
		User user = session.get(User.class, 2);
		
		System.out.println(user);

		
		//5.���ύ����
		transaction.commit();
		//6.���ر���Դ
		session.close();
		sessionFactory.close();
		
		
		
		
		
	}
	
	
}
