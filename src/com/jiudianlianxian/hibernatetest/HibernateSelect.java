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
 * Description: ��֤һ������Ĵ���
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: hibernate_day02
 * @author fupengpeng
 * @date 2017��8��8�� ����8:39:52
 */
public class HibernateSelect {

	//����淶����ṹ��ʹ���뱾���̰߳󶨵�session����
	@Test
	public void testTx(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.��ʹ��SessionFactory����Session����
			//��⣺������jdbc���������ݿ�
			session = HibernateUtils.getSessionObject();
			//2.����������
			transaction = session.beginTransaction();
			//3.��д�����crud����
			
			/*
			 * ��ѯ��
			 *     ����1����Ҫ��ѯ��ʵ����class
			 *     ����2��idֵ
			 */
			User user = session.get(User.class, 2);
			
			System.out.println(user);
			
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
	
	
	//��ʾһ�����������
	@Test
	public void testDemo(){
		//1.���ù������ȡSessionFactory����
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.��ʹ��SessionFactory����Session����
		//��⣺������jdbc���������ݿ�
		Session session = sessionFactory.openSession();
		//3.����������
		Transaction transaction = session.beginTransaction();
		//4.��д�����crud����
		
		/*
		 * ��ѯ��
		 *     ����1����Ҫ��ѯ��ʵ����class
		 *     ����2��idֵ
		 */
		User user = session.get(User.class, 2);
		
		System.out.println(user);

		//�ڶ��β�ѯʱ������ȥ���ݿ��ѯ��������һ�������в�ѯ��
		User user2 = session.get(User.class, 2);
		
		System.out.println("user2="+user2);
		//5.���ύ����
		transaction.commit();
		//6.���ر���Դ
		session.close();
		sessionFactory.close();
		
		
		
		
		
	}
	
	
	//��֤һ������Ĵ���
	@Test
	public void testCasch(){
		//1.���ù������ȡSessionFactory����
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//2.��ʹ��SessionFactory����Session����
		//��⣺������jdbc���������ݿ�
		Session session = sessionFactory.openSession();
		//3.����������
		Transaction transaction = session.beginTransaction();
		//4.��д�����crud����
		
		/*
		 * ��ѯ��
		 *     ����1����Ҫ��ѯ��ʵ����class
		 *     ����2��idֵ
		 */
		User user = session.get(User.class, 2);
		
		System.out.println(user);

		//�ڶ��β�ѯʱ������ȥ���ݿ��ѯ��������һ�������в�ѯ��
		User user2 = session.get(User.class, 2);
		
		System.out.println("user2="+user2);
		//5.���ύ����
		transaction.commit();
		//6.���ر���Դ
		session.close();
		sessionFactory.close();
		
		
		
		
		
	}
	
	
}
