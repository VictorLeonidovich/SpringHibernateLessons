package configuration.lesson18p183.kindergarten;

import java.util.ArrayList;
import java.util.List;

import configuration.lesson18p183.Food;
import configuration.lesson18p183.FoodProviderService;

public class FoodProviderServiceImpl implements FoodProviderService {

	@Override
	public List<Food> provideLunchSet() {
		List<Food> lunchSet = new ArrayList<>();
		lunchSet.add(new Food("Milk"));
		lunchSet.add(new Food("Biscuits"));
		return lunchSet;
	}

}
