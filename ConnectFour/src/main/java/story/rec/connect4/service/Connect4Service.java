/**
 * Connect4 game service package
 */
package story.rec.connect4.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import story.rec.connect4.dao.GameManager;
import story.rec.connect4.model.Move;

/**
 * rest servic for connect 4 game
 * 
 * @author Admin
 *
 */
@Path("/Connect4")
public class Connect4Service {

	private static final int WON = 1;
	private static final int DRAW = 0;
	private static final int OPEN = -1;
	/**  for managing game instance */
	private GameManager gameManager;

	/***
	 * create a new game
	 * 
	 * @return id of game
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{gameId}")
	public Response startGame(@PathParam("gameId") String gameId) {
		return Response.ok(gameManager.getConnect4Game(gameId)).build();
	}

	

	/***
	 * get all slots so that player can see current status of matrix
	 * 
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{gameId}")
	public Response getSlotsDisplay(@PathParam("gameId") String gameId) {
		int[][] slots = gameManager.getConnect4Game(gameId).getSlots();
		return Response.ok(slots).build();
	}

	/***
	 * current columns available to play
	 * 
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{gameId}/columns")
	public Response getAvailableColums(@PathParam("gameId") String gameId) {
		List<Integer> avblSlots = gameManager.getConnect4Game(gameId).getAvailableColumns();
		return Response.ok(avblSlots).build();
	}
	
	/**
	 * place a move
	 * 
	 * @param column,
	 *            which column to place
	 * @param coin,
	 *            the coin of player (colour)
	 * @return result of move, win, draw, or un-finished.
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{gameId}")
	public int play(@PathParam("gameId") String gameId, Move move) {
		Connect4Game game = gameManager.getConnect4Game(gameId);
		game.place(move.getColumn(), move.getColour());
		if (game.isWin(move.getColour())) {
			return WON;
		}
		if (game.isDraw()) {
			return DRAW;
		} else {
			return OPEN;
		}
	}
}
