package configuration.lesson18p183.highschool;

import java.util.ArrayList;
import java.util.List;

import configuration.lesson18p183.Food;
import configuration.lesson18p183.FoodProviderService;

public class FoodProviderServiceImpl implements FoodProviderService {

	@Override
	public List<Food> provideLunchSet() {
		List<Food> lunchSet = new ArrayList<>();
		lunchSet.add(new Food("Coke"));
		lunchSet.add(new Food("Hamburger"));
		lunchSet.add(new Food("French Fries"));
		return lunchSet;
	}

}
