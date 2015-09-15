package testmybatis2;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import testmybatis2.inter.IUserOperation;
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
	
	public static void getUserList(String userName){
		
	       SqlSession session = sqlSessionFactory.openSession();
	       try {
	    	   //
	           IUserOperation userOperation=session.getMapper(IUserOperation.class);
	           //
	           List<User> users = userOperation.selectUsers(userName);
	           for(User user:users){
	               System.out.println(user.getId()+":"+user.getUserName()+":"+user.getUserAddress());
	           }
	           
	       } finally {
	           session.close();
	       }
	   }

	/**
	    * 测试增加,增加后，必须提交事务，否则不会写入到数据库.
	    */
	   public static void addUser(){
	       User user=new User();
	       user.setUserAddress("开普勒524B");
	       user.setUserName("哈哈");
	       user.setUserAge(80);
	       SqlSession session = sqlSessionFactory.openSession();
	       try {
	           IUserOperation userOperation=session.getMapper(IUserOperation.class);
	           userOperation.addUser(user);
	           session.commit();
	           
	           System.out.println("当前增加的用户 id为:"+user.getId());//这里返回id
	       } finally {
	           session.close();
	       }
	   }
	public static void main(String[] args) {
		
//		addUser();
		
		getUserList("%");
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(1);
//			User user = (User) session.selectOne("testmybatis2.model.User.selectUserByID", 1);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		} finally {
			session.close();
		}
	}
}
