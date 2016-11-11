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
 * 用户业务逻辑实现类
 *
 */
public class UsersDaoImpl implements UsersDao{
	
	
	//用户登录方法
	@Override
	public boolean usersLogin(Users users) {
		//创建事物对象
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
				System.out.println("======查询集合不为空=======");
				return true;
			}else {
				System.out.println("============查询集合为空=========");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("=============用户登录查询这里出异常了===========");
			return false;
		}finally {			
			transaction = null;		
		}
	}
	
}
