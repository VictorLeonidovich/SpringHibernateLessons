package scheduling.lesson02p522annotation;

import java.util.List;

public interface CarService {
	public List<Car> findAll();

	public Car save(Car car);

	public void updateCarAgeJob();
}
