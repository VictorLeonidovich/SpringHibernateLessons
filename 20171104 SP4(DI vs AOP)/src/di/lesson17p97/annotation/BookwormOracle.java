package di.lesson17p97.annotation;

import org.springframework.stereotype.Service;

@Service("oracle")
public class BookwormOracle implements Oracle {

	@Override
	public String defineMeaningOfLife() {
		return "Encyclopedias are � waste of money - use the Internet";
	}

}
