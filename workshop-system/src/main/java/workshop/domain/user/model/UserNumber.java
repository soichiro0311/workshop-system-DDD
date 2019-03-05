package workshop.domain.user.model;

/**
 * ユーザ番号のValueObject
 * @author seike0311
 *
 */
public class UserNumber {

	private String userNumber;

	private UserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public static UserNumber of(String userNumber) {
		return new UserNumber(userNumber);
	}

	public String number() {
		return this.userNumber;
	}
	

}
