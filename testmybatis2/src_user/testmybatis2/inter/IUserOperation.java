package testmybatis2.inter;

import java.util.List;

import testmybatis2.model.Article;
import testmybatis2.model.User;

/**
 * mybatis �ӿڷ�ʽ
 * 
 * @author hegang
 *
 */
public interface IUserOperation {
	/**
	 * ����id��ѯ�û�
	 * 
	 * @param id
	 *            user���е�id
	 * @return
	 */
	User selectUserByID(int id);

	/**
	 *
	 * �����û�����ѯ�û�
	 * 
	 * @param userName
	 *            �û���
	 * @return
	 */
	List<User> selectUsers(String userName);
	/**
	 * ����û�
	 * @param user
	 */
	void addUser(User user);
	/**
	 * �޸��û�
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * ɾ��User
	 * @param id ����
	 */
	void deleteUser(int id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<Article> getUserArticles(int id);
}
