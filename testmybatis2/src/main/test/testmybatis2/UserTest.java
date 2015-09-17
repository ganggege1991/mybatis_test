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

	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

	/**
	 * 测试添加，注意添加之后commit
	 */
	public static void addUser() {
		SqlSession sqlSession = getSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = new User();
			user.setUseraddress("成都");
			user.setUsername("LT");
			user.setUserage(100);
			userMapper.insert(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 测试删除，注意添加之后commit
	 */
	public static void delUser(int id) {
		SqlSession sqlSession = getSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.deleteByPrimaryKey(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 测试修改，注意添加之后commit
	 */
	public static void updateUser() {
		SqlSession sqlSession = getSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			User user = userMapper.selectByPrimaryKey(1);// 取出id为1的记录

			user.setUseraddress("重庆");// 修改地址

			userMapper.updateByPrimaryKey(user);// update

			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 查询列表
	 * 
	 * @param userName
	 */
	public static void getUserList() {
		// sqlSession
		SqlSession session = getSession();
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);

			UserExample userExample = new UserExample();
			Criteria c = userExample.createCriteria();
			//c.andUsernameEqualTo("summer");// 拼接条件
			List<User> users = userMapper.selectByExample(userExample);
			for (User user : users) {
				System.out.println(user.getId() + ":" + user.getUsername() + ":" + user.getUseraddress());
			}

		} finally {
			session.close();
		}
	}

	/**
	 * 测试表连接
	 */
	public static void tableJoin() {
		SqlSession sqlSession = getSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//
			System.out.println(userMapper.getUserArticles(1).size());
		} finally {
			sqlSession.close();
		}
	}

	public static void main(String[] args) {
//		 addUser();
		getUserList();
//		delUser(5);
//		updateUser();
//		getUserList();
		tableJoin();
	}
}
