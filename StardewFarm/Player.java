
/**
 * Player class represent the player who plays in the game and has level, coins, experience points, farmer type and day count
 * which represents the number of days the player farms in the game
 *
 */
public class Player {
	private int level;
	private double coins;
	private double exp;
	private FarmerType farmerType;
	private int dayCount;
	

	/**
	 * This the constructor for the Player class
	 * @param level - level of the player
	 * @param coins - coins of the player
	 * @param exp = experience points of the player
	 * @param farmerType - farmer type of the player
	 */
	public Player(int level, double coins, double exp, FarmerType farmerType) {
		this.level = 0;
		this.coins =  100;
		this.exp = 0;
		this.farmerType = farmerType;
		this.dayCount = 1;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getCoins() {
		return coins;
	}
	public void setCoins(double coins) {
		this.coins = coins;
	}
	public double getExp() {
		return exp;
	}
	public void setExp(double exp) {
		this.exp = exp;
	}
	public FarmerType getFarmerType() {
		return farmerType;
	}
	public void setFarmerType(FarmerType farmerType) {
		this.farmerType = farmerType;
	}
	public int getDayCount() {
		return dayCount;
	}
	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}
	
}
