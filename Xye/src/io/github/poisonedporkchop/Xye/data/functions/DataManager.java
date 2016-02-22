package io.github.poisonedporkchop.Xye.data.functions;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Month;
import io.github.daschner.Xye.data.types.Trade;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Damien Claessen
 */

public class DataManager {
	
	public List<Trade> sortTradesByDate(List<Trade> trades) {

		List<Trade> sorting = new ArrayList<>();
		
		for(Trade trade : trades) {
			
			sorting.add(trade);
			
		}
		
		List<Trade> sorted = new ArrayList<>();
		
		Trade largest = new Trade("TEST", new Date(0, Month.JANUARY, 0), 0, 0, 0, 0, 0, 0);

		while (sorted.size() < trades.size()) {

			for (int i = 0; i < sorting.size(); i++) {

				if (sorting.get(i).getDate().getYear() > largest.getDate().getYear()) {

					largest = sorting.get(i);

				} else if (sorting.get(i).getDate().getYear() == largest.getDate().getYear()) {

					if (sorting.get(i).getDate().getMonth().ordinal() + 1 > largest.getDate().getMonth().ordinal() + 1) {

						largest = sorting.get(i);

					} else if (sorting.get(i).getDate().getMonth().ordinal() + 1 == largest.getDate().getMonth().ordinal() + 1) {

						if (sorting.get(i).getDate().getDay() > largest.getDate().getDay()) {

							largest = sorting.get(i);

						}

					}

				}

			}
			
			sorting.remove(largest);

			sorted.add(largest);

			largest = new Trade("TEST", new Date(0, Month.JANUARY, 0), 0, 0, 0, 0, 0, 0);

		}

		return sorted;

	}

}
