package springboot.rollingdice.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RollingDiceService {

	/*
	 * THERE ARE 2 METHODS: 1-For rolling the dice; 2-For storing how many
	 * times values are inserted.
	 */
	
	public  Map<Integer, Integer> rollDice(Integer numOfRolls) {
		
		Map<Integer, Integer> storeDiceValue = new HashMap<>();
		Random random = new Random();
		
		for (int i = 1; i <= numOfRolls; i++) {
			
			int dice = random.nextInt(6)+1;
			
				if (dice == 1) {
					storeDiceValue.put(i, 1);
				}
				else if (dice == 2) {
					storeDiceValue.put(i, 2);
				}
				else if (dice == 3) {
					storeDiceValue.put(i, 3);
				}
				else if (dice == 4) {
					storeDiceValue.put(i, 4);
				}
				else if (dice == 5) {
					storeDiceValue.put(i, 5);
				}else if (dice == 6) {
					storeDiceValue.put(i, 6);
				}
		}
		return storeDiceValue;		
		
	}
	
	public Map<String, String> countDiceValuesInserted(Map<Integer, Integer> storedDiceValues) {
		int countValue1 = 0, countValue2 = 0, countValue3 = 0, countValue4 = 0, countValue5 = 0, countValue6 = 0;
		
		for (Integer i: storedDiceValues.values()) {	
			if (i.equals(1)) {
				countValue1++;
			}
			else if (i.equals(2)) {
				countValue2++;
			}
			else if (i.equals(3)) {
				countValue3++;
			}
			else if (i.equals(4)) {
				countValue4++;
			}
			else if (i.equals(5)) {
				countValue5++;
			}
			else if (i.equals(6)) {
				countValue6++;
			}
		}
		
		Map<String, String> mapNumOfDiceValuesInserted = new LinkedHashMap<>();
		mapNumOfDiceValuesInserted.put("Dice Value 1 ", " " + countValue1 + " time(s)");
		mapNumOfDiceValuesInserted.put("Dice Value 2 ", " " + countValue2 + " time(s)");
		mapNumOfDiceValuesInserted.put("Dice Value 3 ", " " + countValue3 + " time(s)");
		mapNumOfDiceValuesInserted.put("Dice Value 4 ", " " + countValue4 + " time(s)");
		mapNumOfDiceValuesInserted.put("Dice Value 5 ", " " + countValue5 + " time(s)");
		mapNumOfDiceValuesInserted.put("Dice Value 6 ", " " + countValue6 + " time(s)");
		
		return mapNumOfDiceValuesInserted;
	}
	
}
