package testmybatis2.model;

import java.util.List;

import testmybatis2.model.User;

/**
 * mybatis ��ڷ�ʽ
 * 
 * @author hegang
 *
 */
public interface IUserOperation {
	/**
	 * ����id��ѯ�û�
	 * @param id user���е�id
	 * @return
	 */
	User selectUserByID(int id);

	/**
	 *
	 * �����û�����ѯ�û�
	 * @param userName �û���
	 * @return
	 */
	
	List<User> selectUsers(String userName);
}
