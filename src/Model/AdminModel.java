package Model;

public class AdminModel {
       private String account,password;

	public AdminModel(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public AdminModel() {
		super();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
       
}
