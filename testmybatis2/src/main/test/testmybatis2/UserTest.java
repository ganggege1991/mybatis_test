package testmybatis2;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.testmybatis.dao.UserMapper;
import com.testmybatis.model.User;
import com.testmybatis.model.UserExample;
import com.testmybatis.model.UserExample.Criteria;


public class UserTest {

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

	/**
	 * 
	 * @param userName
	 */
	public static void getUserList(String userName) {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			//
			UserMapper userOperation = session.getMapper(UserMapper.class);
			
			UserExample userExample = new UserExample();
			Criteria c = userExample.createCriteria();
			c.andUsernameEqualTo("·ÉÄñ");
			List<User> users = userOperation.selectByExample(userExample);
			for (User user : users) {
				System.out.println(user.getId() + ":" + user.getUsername() + ":" + user.getUseraddress());
			}

		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		getUserList("%");
	}
}
