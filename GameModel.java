import java.io.File;
import java.util.Scanner;

/**
 * GameModel class represents the model of the whole game which composed of player, lot, seeds, tools and farmer type 
 *
 */
public class GameModel {
	private Lot[] lot = new Lot[50];
	private Seed[] seedList = new Seed[8];
	private FarmerType[] farmerType = new FarmerType[4];
	private Tools[] toolList = new Tools[6];
	private Player player = new Player(0, 0, 0, farmerType[0]);
	
	/**
	 * Initializes the seed list of the game model
	 * @param seedList - seed list of the game model
	 */
	public void initSeedList(Seed[] seedList) {
		// name, type, harvestTime, fertMin, fertMax, watMin, watMax, min, max, exp, cost, sellingPrice
		seedList[0] = new Seed("Turnip", "Root Crop", 2, 0, 1, 1, 2, 1, 2, 5, 5, 6);
		seedList[1] = new Seed("Carrot", "Root Crop", 3, 0, 1, 1, 2, 1, 2, 7.5, 10, 9);
		seedList[2] = new Seed("Potato", "Root Crop", 5, 1, 2, 3, 4, 1, 10, 12.5, 20, 3);
		seedList[3] = new Seed("Rose", "Flower", 1, 0, 1, 1, 2, 1, 1, 2.5, 5, 5);
		seedList[4] = new Seed("Tulip", "Flower", 2, 0, 1, 2, 3, 1, 1, 5, 10, 9);
		seedList[5] = new Seed("Sunflower", "Flower", 3, 1, 2, 2, 3, 1, 1, 7.5, 20, 19);
		seedList[6] = new Seed("Mango", "Fruit Tree", 10, 4, 4, 7, 7, 5, 15, 25, 100, 8);
		seedList[7] = new Seed("Apple", "Fruit Tree", 10, 5, 5, 7, 7, 10, 15, 25, 200, 5);
	}
	
	/**
	 * Initializes the farmer type of the game model
	 */
	public void setFarmerType() {
		// name, level, bonusEarnings, seedCostR, waterBonus, fertBonus, regFee
		farmerType[0] = new FarmerType("Farmer", 0, 0, 0, 0, 0, 0);
		farmerType[1] = new FarmerType("Registered Farmer", 5, 1, -1, 0, 0, 200);
		farmerType[2] = new FarmerType("Distinguished Farmer", 10, 2, -2, 1, 0, 300);
		farmerType[3] = new FarmerType("Legendary Farmer", 15, 4, -3, 2, 1, 400);
	} 
	
	/**
	 * Initializes the tool list of the game model
	 */
	public void setToolList() {
		// type, cost, exp
		toolList[0] = new Tools("Plow", 0, 0.5);
		toolList[1] = new Tools("Watering Can", 0, 0.5);
		toolList[2] = new Tools("Fertilizer", 10, 4);
		toolList[3] = new Tools("Pickaxe", 50, 15);
		toolList[4] = new Tools("Shovel", 7, 2);
		toolList[5] = new Tools("Harvest", 0, 0);
	}
	
	/**
	 * Initializes the lots of the game model
	 */
	public void initLot() {
		for(int i = 0; i < 50; i++) {
			lot[i] = new Lot();
		}
	}
	
	/**
	 * Initializes the starting state of the game model
	 */
	public void initialize() {
		initSeedList(seedList);
		setFarmerType();
		setToolList();
		initLot();
		setHasRocks();
	}
	
	/**
	 * Promotes the player to the farmer type it prompted in the game
	 * @param num - index of the farmer type that the player prompted to get promoted
	 * @param numprev - index of the farmer type that had before
	 * @return true if the promotion is successful
	 */
	public boolean promoteFarmer(int num, int numprev){
		if(player.getCoins() >= farmerType[num].getRegistrationFee() && player.getLevel() >= farmerType[num].getLevel() && num > numprev) {
			player.setFarmerType(farmerType[num]); 
			player.setCoins(player.getCoins() - farmerType[num].getRegistrationFee());
			initSeedList(seedList);
			for(int i = 0; i < 8; i++) {
				seedList[i].setCost(seedList[i].getCost() + player.getFarmerType().getSeedCostReduction());
				seedList[i].setFertilizerMax(seedList[i].getFertilizerMax() + player.getFarmerType().getFertilzerBonus());
				seedList[i].setWaterMax(seedList[i].getWaterMax() + player.getFarmerType().getWaterBonus());
				seedList[i].setSellingPrice(seedList[i].getSellingPrice() + player.getFarmerType().getBonusEarnings());
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Applies the bonuses from the promotion 
	 */
	public void applyPromotion() { 
		Seed[] baseSeed = new Seed[8];
		initSeedList(baseSeed);
		for(int i = 0; i < 50; i++) {
			if(lot[i].getCrop() != null) {
				for(int j = 0; j < 8; j++) {
					if(lot[i].getCrop().getName().equals(baseSeed[j].getName())) {
						lot[i].getCrop().setFertilizerMax(baseSeed[j].getFertilizerMax() + player.getFarmerType().getFertilzerBonus());
						lot[i].getCrop().setWaterMax(baseSeed[j].getWaterMax() + player.getFarmerType().getWaterBonus());
						lot[i].getCrop().setSellingPrice(baseSeed[j].getSellingPrice() + player.getFarmerType().getBonusEarnings());
					}
				}
				
				
			}
		}
	}
	
	public Lot[] getLot() {
		return lot;
	}

	public void setLot(Lot[] lot) {
		this.lot = lot;
	}

	public Seed[] getSeedList() {
		return seedList;
	}

	public void setSeedList(Seed[] seedList) {
		this.seedList = seedList;
	}

	public FarmerType[] getFarmerType() {
		return farmerType;
	}

	public void setFarmerType(FarmerType[] farmerType) {
		this.farmerType = farmerType;
	}
	
	public Tools[] getToolList() {
		return toolList;
	}

	public void setToolList(Tools[] toolList) {
		this.toolList = toolList;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}


	/**
	 * Checks if the game met the game over conditions
	 * @return true if the game is over
	 */
	public boolean checkGameOver(){
		boolean allCropsHasWithered = true;
		boolean noGrowingCrops = true;
		int witheredCropCount = 0;

		for(int i = 0; i < 50; i++) {	
			if(lot[i].getCrop()!= null && !getLot()[i].isHasWithered()) {
				noGrowingCrops = false;
			}
			if(getLot()[i].isHasWithered()) {
				witheredCropCount++;
			}
		}
		if(witheredCropCount == 50) {
			allCropsHasWithered = true;
		}
		else
			allCropsHasWithered = false;
		return allCropsHasWithered || noGrowingCrops && player.getCoins() < 5;
	}
	

	/**
	 * Initializes the rock placements in the game model lots
	 */
	public void setHasRocks() {
		try { // initializes the rocks
			Scanner sc = new Scanner(new File("rock.txt"));
			while (sc.hasNext()) {
				int rock = sc.nextInt();
				//System.out.print(rock);
				lot[rock].setHasStones(true);
			}
			sc.close();
		} catch (Exception e) {
		}
	}
}
