package workshop.domain.user.model;

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

}
