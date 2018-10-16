package scheduling.lesson03p523;

import java.util.concurrent.Future;

public interface AsyncService {
	public void asyncTask();

	public Future<String> asyncWithReturn(String name);
}
