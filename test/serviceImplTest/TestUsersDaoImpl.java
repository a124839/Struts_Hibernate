package serviceImplTest;

import org.junit.Assert;
import org.junit.Test;

import entity.Users;
import service.UsersDao;
import serviceImpl.UsersDaoImpl;

public class TestUsersDaoImpl {
	
	@Test
	public void testUsersDaoImpl(){
		Users users = new Users(1,"уехЩ","123456789");
		UsersDao usersDao = new UsersDaoImpl();
		Assert.assertEquals(true,usersDao.usersLogin(users));
		
	}
	
}
