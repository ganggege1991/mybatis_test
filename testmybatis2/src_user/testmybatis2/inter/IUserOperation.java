package testmybatis2.inter;

import java.util.List;

import testmybatis2.model.Article;
import testmybatis2.model.User;

/**
 * mybatis 接口方式
 * 
 * @author hegang
 *
 */
public interface IUserOperation {
	/**
	 * 根据id查询用户
	 * 
	 * @param id
	 *            user表中的id
	 * @return
	 */
	User selectUserByID(int id);

	/**
	 *
	 * 更具用户名查询用户
	 * 
	 * @param userName
	 *            用户名
	 * @return
	 */
	List<User> selectUsers(String userName);
	/**
	 * 添加用户
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 修改用户
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 删除User
	 * @param id 主键
	 */
	void deleteUser(int id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<Article> getUserArticles(int id);
}
