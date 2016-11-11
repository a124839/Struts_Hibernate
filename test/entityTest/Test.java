package entityTest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import entity.Students;
import entity.Users;

public class Test {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@org.junit.Test
	public void testSchemaExport(){
		//创建配置对象
		Configuration configuration = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		//创建会话工厂
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//创建会话
		session = sessionFactory.openSession();
		//创建事物
		transaction = session.beginTransaction();
//		//创建对象
//		Users users = new Users(1,"张三","zhangsan");
//		Students students = new Students(1,"王五","男",new Date(),"武当山，著名神棍");
//		//保存对象
//		session.save(students);
//		session.save(users);
//		//提交事务
//		transaction.commit();
//		//关闭会话
//		session.close();
		
		//创建 SchemaExport对象
		SchemaExport schemaExport = new SchemaExport(configuration);
		
		schemaExport.create(true,true);
	}
}
