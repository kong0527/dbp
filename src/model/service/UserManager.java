package model.service;

import java.sql.SQLException;
import java.util.List;

import model.User;
import model.dao.UserDAO;

/**
 * 占쏙옙占쏙옙占� 占쏙옙占쏙옙 API占쏙옙 占쏙옙占쏙옙求占� 占쏙옙占쏙옙占쌘듸옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싹곤옙 占실댐옙 클占쏙옙占쏙옙.
 * UserDAO占쏙옙 占싱울옙占싹울옙 占쏙옙占쏙옙占싶븝옙占싱쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쌜억옙占쏙옙 占쏙옙占쏙옙占싹듸옙占쏙옙 占싹몌옙,
 * 占쏙옙占쏙옙占싶븝옙占싱쏙옙占쏙옙 占쏙옙占쏙옙占싶듸옙占쏙옙 占싱울옙占싹울옙 占쏙옙占쏙옙占싹쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占쏙옙占쏙옙 占싼댐옙.
 * 占쏙옙占쏙옙占싹쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙荑∽옙占� 占쏙옙占쏙옙占싹쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싹댐옙 클占쏙옙占쏙옙占쏙옙 
 * 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙 占쌍댐옙.
 */
public class UserManager {
	private static UserManager userMan = new UserManager();
	private UserDAO userDAO;

	private UserManager() {
		try {
			userDAO = new UserDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	public int create(User user) throws SQLException, ExistingUserException {
		if (userDAO.isExisting(user.getId()) == true) {
			throw new ExistingUserException(user.getId() + "占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占싱듸옙占쌉니댐옙.");
		}
		return userDAO.create(user);
	}

	public User findUser(String userId)
		throws SQLException, UserNotFoundException {
		User user = userDAO.findUser(userId);
		
		if (user == null) {
			throw new UserNotFoundException(userId + "占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占십댐옙 占쏙옙占싱듸옙占쌉니댐옙.");
		}		
		return user;
	}

	public List<User> findUserList() throws SQLException {
			return userDAO.findUserList();
	}
	
	public List<User> findUserList(int currentPage, int countPerPage)
		throws SQLException {
		return userDAO.findUserList(currentPage, countPerPage);
	}

	public boolean login(String userId, String password)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		User user = findUser(userId);

		if (!user.matchPassword(password)) {
			throw new PasswordMismatchException("占쏙옙橘占싫ｏ옙占� 占쏙옙치占쏙옙占쏙옙 占십쏙옙占싹댐옙.");
		}
		return true;
	}

	public UserDAO getUserDAO() {
		return this.userDAO;
	}

}
