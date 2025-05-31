/**
 * Main class is where the main function is found
 * @author Alexi Kyna M. Dela Cruz
 * @author Mary Joselle Cabungcal
 *
 */
public class Main {
	public static void main(String[] args) {
		GameView gameView = new GameView();
		new GameController(gameView);
	}
}