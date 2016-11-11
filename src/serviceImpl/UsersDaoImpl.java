package serviceImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.HSessionFactory;
import entity.Users;
import service.UsersDao;

/**
 * @author k570
 * �û�ҵ���߼�ʵ����
 *
 */
public class UsersDaoImpl implements UsersDao{
	
	
	//�û���¼����
	@Override
	public boolean usersLogin(Users users) {
		//�����������
		Transaction transaction = null;
		String hql="";
		
		try {
			Session session = HSessionFactory.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			hql="from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, users.getUsername());
			query.setParameter(1, users.getPassword());
			List list = query.list();
			transaction.commit();
			if (list.size()>0) {
				System.out.println("======��ѯ���ϲ�Ϊ��=======");
				return true;
			}else {
				System.out.println("============��ѯ����Ϊ��=========");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("=============�û���¼��ѯ������쳣��===========");
			return false;
		}finally {			
			transaction = null;		
		}
	}
	
}
