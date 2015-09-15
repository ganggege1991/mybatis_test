package testmybatis2;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import testmybatis2.inter.IUserOperation;
import testmybatis2.model.Article;
import testmybatis2.model.User;

public class Test {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void getUserList(String userName) {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			//
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			//
			List<User> users = userOperation.selectUsers(userName);
			for (User user : users) {
				System.out.println(user.getId() + ":" + user.getUserName() + ":" + user.getUserAddress());
			}

		} finally {
			session.close();
		}
	}

	/**
	 * ��������,���Ӻ󣬱����ύ���񣬷��򲻻�д�뵽���ݿ�.
	 */
	public static void addUser() {
		User user = new User();
		user.setUserAddress("������524B");
		user.setUserName("����");
		user.setUserAge(80);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			userOperation.addUser(user);
			session.commit();

			System.out.println("��ǰ���ӵ��û� idΪ:" + user.getId());// ���ﷵ��id
		} finally {
			session.close();
		}
	}

	/**
	 * �����޸�
	 */
	public static void updateUser() {
		// �ȵõ��û�,Ȼ���޸ģ��ύ��
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(2);// ȡUser
			user.setUserAddress("�ɶ�");
			userOperation.updateUser(user);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * ɾ�����ݣ�ɾ��һ��Ҫ commit.
	 * 
	 * @param id
	 */
	public static void deleteUser(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			userOperation.deleteUser(id);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * ������ѯ
	 * 
	 * @param userid
	 */
	public static void getUserArticles(int userid) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			List<Article> articles = userOperation.getUserArticles(userid);
			for (Article article : articles) {
				System.out.println(article.getTitle() + ":" + article.getContent() + ":������:"
						+ article.getUser().getUserName() + ":��ַ:" + article.getUser().getUserAddress());
			}
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {

		// addUser();
		// deleteUser(3);
		getUserList("%");
		
		getUserArticles(1);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(1);
			// User user = (User)
			// session.selectOne("testmybatis2.model.User.selectUserByID", 1);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		} finally {
			session.close();
		}
	}
}
