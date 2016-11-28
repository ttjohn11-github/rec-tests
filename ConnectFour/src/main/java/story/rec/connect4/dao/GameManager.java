/***
 * 
 */
package story.rec.connect4.dao;

import java.util.HashMap;
import java.util.Map;

import story.rec.connect4.service.Connect4Game;
/** 
 * Temporary persistence implementation of games, not documented
 * @author Admin
 *
 */
public class GameManager {
	private static final Map<String, Connect4Game> games = new HashMap<String, Connect4Game>();
	
	public Connect4Game getConnect4Game(String gameId){
		
		//if game exists, return it, else create one and return
		if(games.containsKey(gameId)){
			return games.get(gameId);
		}
		Connect4Game matrix = new Connect4Game();	
		matrix.setGameId(gameId);
		games.put(gameId, matrix);
		return matrix;
	}
	
}
