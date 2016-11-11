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
		//�������ö���
		Configuration configuration = new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		//�����Ự����
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//�����Ự
		session = sessionFactory.openSession();
		//��������
		transaction = session.beginTransaction();
//		//��������
//		Users users = new Users(1,"����","zhangsan");
//		Students students = new Students(1,"����","��",new Date(),"�䵱ɽ���������");
//		//�������
//		session.save(students);
//		session.save(users);
//		//�ύ����
//		transaction.commit();
//		//�رջỰ
//		session.close();
		
		//���� SchemaExport����
		SchemaExport schemaExport = new SchemaExport(configuration);
		
		schemaExport.create(true,true);
	}
}
