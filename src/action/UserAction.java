package action;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDao;
import serviceImpl.UsersDaoImpl;

/**
 * @author k570
 * �û�������
 *
 */
public class UserAction extends SuperAction implements ModelDriven<Users> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Users users = new Users(); 
	
	public String login() {
		UsersDao usersDao = new UsersDaoImpl();
		System.out.println("===============�����Ƿ�ִ��????=========");
		if (usersDao.usersLogin(users)) {
			return "login_success";
		}else {
			return "login_failure";
		}		
	}
	@Override
	public Users getModel() {
		
		return this.users;
	}

}
