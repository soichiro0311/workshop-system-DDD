package workshop.domain.user.model;

/**
 * ユーザ名のValueObject
 * @author seike0311
 *
 */
public class UserName {

	private String username;

	private UserName(String username) {
		this.username = username;
	}

	public static UserName of(String username) {
		return new UserName(username);
	}

	public String name() {
		return this.username;
	}

	public String userNumber() {
		return this.username.replaceAll("[^0-9]","");
	}

}
