package aop.lesson03p211;

public class SecurityManager {
	private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

	public void login(String userName, String password) {
		threadLocal.set(new UserInfo(userName, password));
	}

	public void logout() {
		threadLocal.set(null);
	}

	public UserInfo getLoggerOnUser() {
		return threadLocal.get();
	}
}
