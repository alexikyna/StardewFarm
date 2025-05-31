
/**
 * Tools Class represents the tools that are used in the game which has type, cost and exp gained
 *
 */
public class Tools {
	private String type;
	private double cost;
	private double exp;
	
	/**
	 * This the constructor for the Tools class
	 * @param type -  type of tool
	 * @param cost -  cost of tool usage
	 * @param exp - experience gained from using the tool
	 */
	public Tools(String type, double cost, double exp){
		this.type = type;
		this.cost = cost;
		this.exp = exp;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getExp() {
		return exp;
	}
	public void setExp(double exp) {
		this.exp = exp;
	}
}
