package springboot.rollingdice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import springboot.rollingdice.exception.InvalidNumberOfRollsException;
import springboot.rollingdice.service.RollingDiceService;

@RestController("/")
public class MainController {

	
	RollingDiceService service;
	
	@Autowired
	public void setService(RollingDiceService service) {
		this.service = service;
	}

	
	@GetMapping
	public ResponseEntity<String> guideMessage() {
		return ResponseEntity.status(HttpStatus.OK).body(""
				+ "Hi there ! "
				+ "This a counting rolling dice game. "
				+ "You choose how many times ( from 1 to 100 ) will the dice roll and try to guess which dice value was in the above part for the most part. "
				+ "Type the number of rolls the dice should be flipped in this address:  /rolling-dice/  <- type the number here ");
	}
	
	@GetMapping("/rolling-dice/")
	public ResponseEntity<String> rollingDicePage() {
		return ResponseEntity.status(HttpStatus.OK).body("How many times will the dice be rolled ?");
	}

	Map<Integer, Integer> storeDiceValue = new HashMap<>();
	
	@GetMapping("/rolling-dice/{numOfRolls}")
	public ResponseEntity<?> rollDice(@PathVariable("numOfRolls") Integer numOfRolls) {
		if (numOfRolls < 1 || numOfRolls > 100 ) {
			throw new InvalidNumberOfRollsException(" It can only roll from 1 to 100 times.");
		}
		storeDiceValue = service.rollDice(numOfRolls);
		Map<String, String> mapNumOfDiceValuesInserted = service.countDiceValuesInserted(storeDiceValue);
		return ResponseEntity.status(HttpStatus.OK).body(mapNumOfDiceValuesInserted);
	}
	
	@GetMapping("/rolling-dice/dice-roll-order")
	public ResponseEntity<?> checkDiceRollOrder() {
		return ResponseEntity.status(HttpStatus.OK).body(storeDiceValue);
	}
	
}
