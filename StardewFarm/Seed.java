
/**
 * Seed class represents the seed that are going to be planted in the game
 */
public class Seed {
	private String name;
	private String type;
	private int age;
	private int harvestTime;
	private int fertilizer;
	private int fertilizerMin;
	private int fertilizerMax;
	private int water;
	private int waterMin;
	private int waterMax;
	private int min;
	private int max;
	private double exp;
	private double cost;
	private double sellingPrice;
	
	/**
	 * This the constructor for the Seed class
	 * @param name -  name of the seed
	 * @param type -  type of the seed
	 * @param harvestTime - numbers of days before it get harvested
	 * @param fertilizerMin - minimum number of times it should be fertilized
	 * @param fertilizerMax - maximum number of times it should be fertilized
	 * @param waterMin - minimum number of times it should be watered
	 * @param waterMax - maximum number of times it should be watered
	 * @param min - minimum number of plants to be harvested
	 * @param max - maximum number of plants to be harvested
	 * @param exp - experience gained from harvesting
	 * @param cost - cost of the seed being planted
	 * @param sellingPrice - selling price of harvested plant
	 */
	public Seed(String name, String type, int harvestTime, int fertilizerMin, int fertilizerMax, 
				int waterMin, int waterMax, int min, int max, double exp, double cost, double sellingPrice) {
		this.name = name;
		this.type = type;
		this.age =  0;
		this.harvestTime = harvestTime;
		this.fertilizer = 0;
		this.fertilizerMin = fertilizerMin;
		this.fertilizerMax = fertilizerMax;
		this.water = 0;
		this.waterMin = waterMin;
		this.waterMax = waterMax;
		this.min = min;
		this.max = max;
		this.exp = exp;
		this.cost = cost;
		this.sellingPrice = sellingPrice;
	}
	
	/**
	 * Initializes the attributes from the seed prompted from the game
	 * @param seed - seed to be planted
	 */
	public Seed(Seed seed) {
		// TODO Auto-generated constructor stub
		this.name = seed.getName();
		this.type = seed.getType();
		this.age =  0;
		this.harvestTime = seed.getHarvestTime();
		this.fertilizer = 0;
		this.fertilizerMin = seed.getFertilizerMin();
		this.fertilizerMax = seed.getFertilizerMax();
		this.water = 0;
		this.waterMin = seed.getWaterMin();
		this.waterMax = seed.getWaterMax();
		this.min = seed.getMin();
		this.max = seed.getMax();
		this.exp = seed.getExp();
		this.cost = seed.getCost();
		this.sellingPrice = seed.getSellingPrice();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHarvestTime() {
		return harvestTime;
	}
	public void setHarvestTime(int harvestTime) {
		this.harvestTime = harvestTime;
	}
	public int getFertilizer() {
		return fertilizer;
	}
	public void setFertilizer(int fertilizer) {
		this.fertilizer = fertilizer;
	}
	public int getFertilizerMin() {
		return fertilizerMin;
	}
	public void setFertilizerMin(int fertilizerMin) {
		this.fertilizerMin = fertilizerMin;
	}
	public int getFertilizerMax() {
		return fertilizerMax;
	}
	public void setFertilizerMax(int fertilizerMax) {
		this.fertilizerMax = fertilizerMax;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public int getWaterMin() {
		return waterMin;
	}
	public void setWaterMin(int waterMin) {
		this.waterMin = waterMin;
	}
	public int getWaterMax() {
		return waterMax;
	}
	public void setWaterMax(int waterMax) {
		this.waterMax = waterMax;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
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
	
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	
}
