
/**
 * FarmerType class represents the farmer type of the player in the game which grants bonus earnings, seed cost reduction, water bonus and fertilizer bonus
 * wherein the player must pay the registration fee for them to get promoted on their desired farmer type
 *
 */
public class FarmerType {
	private String name;
	private int level;
	private double bonusEarnings;
	private double seedCostReduction;
	private int waterBonus;
	private int fertilzerBonus;
	private double registrationFee;
	
	/**
	 * This the constructor for the FarmerType class
	 * @param name - name of the farmer type
	 * @param level - level required for promotion
	 * @param bonusEarnings - bonus earnings granted
	 * @param seedCostReduction - seed cost reduction when buying seeds
	 * @param waterBonus -  water bonus for the crops
	 * @param fertilizerBonus = fertilizer bonus for the crops
	 * @param registrationFee - registration fee needed for promotion
	 */
	public FarmerType(String name, int level, double bonusEarnings, double seedCostReduction, int waterBonus, int fertilizerBonus, double registrationFee) {
		this.name = name;
		this.level = level;
		this.bonusEarnings = bonusEarnings;
		this.seedCostReduction = seedCostReduction;
		this.waterBonus = waterBonus;
		this.fertilzerBonus = fertilizerBonus;
		this.registrationFee = registrationFee;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getBonusEarnings() {
		return bonusEarnings;
	}
	public void setBonusEarnings(double bonusEarnings) {
		this.bonusEarnings = bonusEarnings;
	}
	public double getSeedCostReduction() {
		return seedCostReduction;
	}
	public void setSeedCostReduction(double seedCostReduction) {
		this.seedCostReduction = seedCostReduction;
	}
	public int getWaterBonus() {
		return waterBonus;
	}
	public void setWaterBonus(int waterBonus) {
		this.waterBonus = waterBonus;
	}
	public int getFertilzerBonus() {
		return fertilzerBonus;
	}
	public void setFertilzerBonus(int fertilzerBonus) {
		this.fertilzerBonus = fertilzerBonus;
	}
	public double getRegistrationFee() {
		return registrationFee;
	}
	public void setRegistrationFee(int registrationFee) {
		this.registrationFee = registrationFee;
	}

}
