package scheduling.lesson01p516;

import java.util.List;

public interface CarService {
	public List<Car> findAll();

	public Car save(Car car);

	public void updateCarAgeJob();
}
