package workshop.domain.user.model;
/**
 * ユーザエンティティの一意な識別子のValueObject
 * @author seike0311
 *
 */
public class UserId {

	private String id;

	private UserId(String id) {
		this.id=id;
	}

	public static UserId of(UserName userName) {
		return new UserId(userName.userNumber());
	}

	public String id() {
		return id;
	}

}
