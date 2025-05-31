import java.util.Random;

/**
 * Lot class represents the lot used in the game wherein the player can plow, plant, water, fertilize, dig, pick, and harvest.
 *
 */
public class Lot {
	private Seed crop = null;
	private boolean hasStones = false;
	private boolean isPlowed = false;
	private boolean hasWithered = false;
	private boolean harvestable = false;
	
	private static final Random randomizer = new Random();
	
	
	
	/**
	 * Plows the lot
	 * @param tools - tool to be used
	 * @param player -  player of the game
	 * @return true if successful
	 */
	public boolean plow(Tools tools, Player player) {
		if(crop == null && isPlowed == false && hasStones == false) {
			setPlowed(true);
			player.setExp(player.getExp() + tools.getExp());
			return true; // return true if successful
		}
		return false; //return false if unsuccessful
	}
	
	/**
	 * Plants the selected seed to the lot
	 * @param seed - seed to be planted
	 * @param player -  player of the game
	 * @return true if successful
	 */
	public boolean plant(Seed seed, Player player) {
		if(crop == null) {
			if(seed.getCost() <= player.getCoins() && isPlowed) {
				crop = seed;
				player.setCoins(player.getCoins() - seed.getCost());
				return true; // return true if successful
			}
		}
		return false;  //return false if unsuccessful
	}
	
	/**
	 * Waters the lot
	 * @param tools - tool to be used
	 * @param player -  player of the game
	 * @return true if successful
	 */
	public boolean water(Tools tools, Player player) {
		if(crop != null) {
			crop.setWater(crop.getWater() + 1);
			player.setExp(player.getExp() + tools.getExp());
			return true; // return true if successful
		}
		return false; //return false if unsuccessful
	}
	
	/**
	 * Fertilizes the lot
	 * @param tools - tool to be used
	 * @param player -  player of the game
	 * @return true if successful
	 */
	public boolean fertilize(Tools tools, Player player) {
		if(crop != null) {
			if(tools.getCost() <= player.getCoins()) {
				crop.setFertilizer(crop.getFertilizer() + 1);
				player.setCoins(player.getCoins() - tools.getCost());
				player.setExp(player.getExp() + tools.getExp());
				return true; // return true if successful
			}
			
		}
		return false; //return false if unsuccessful
	}
	
	/**
	 * Digs the lot
	 * @param tools - tool to be used
	 * @param player -  player of the game
	 * @return true if successful
	 */
	public boolean dig(Tools tools, Player player) {
		if(tools.getCost() <= player.getCoins() && hasStones == false) {
			if(crop != null) {
				crop = null;
				setHarvestable(false);
				setHasWithered(false);
			}
			player.setCoins(player.getCoins() - tools.getCost());
			player.setExp(player.getExp() + tools.getExp());
			setPlowed(false);
			return true;
		}
		return false;
	}
	
	/**
	 * Picks the lot
	 * @param tools - tool to be used
	 * @param player -  player of the game
	 * @return true if successful
	 */
	public boolean pick(Tools tools, Player player) {
		if(tools.getCost() <= player.getCoins()) {
			if(hasStones == true) {
				setHasStones(false);
				player.setCoins(player.getCoins() - tools.getCost());
				player.setExp(player.getExp() + tools.getExp());
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method harvest the crop on the lot and return the outcome of the harvest
	 * @param player is the player of the game
	 * @return harvest outcome
	 */
	public String harvest(Player player) {
		int range = crop.getMax() - crop.getMin() + 1;
		int productsProduced = randomizer.nextInt(range) + crop.getMin();
		double harvestTotal = crop.getSellingPrice() * productsProduced;
		int water = crop.getWater();
		if(crop.getWaterMax() <= water) {
			water = crop.getWaterMax();
		}
		
		int fertilizer = crop.getFertilizer();
		if(crop.getFertilizerMax() <= fertilizer) {
			water = crop.getFertilizerMax();
		}
		
		double waterbonus = harvestTotal * 0.2 * (water - 1);
		double fertilizerbonus = harvestTotal * 0.5 * fertilizer;
		double finalSell = harvestTotal + waterbonus + fertilizerbonus;
		if(crop.getType().equals("Flower")) {
			finalSell = finalSell * 1.1;
		}
		
		player.setCoins(player.getCoins() + finalSell);
		player.setExp(player.getExp() + crop.getExp());
		
		setPlowed(false);
		setHarvestable(false);
		
		return "You have gained " + String.format("%.2f", finalSell) + " coins from harvesting " + productsProduced + " " + crop.getName() + "!";
	}
	
	public Seed getCrop() {
		return crop;
	}

	public void setCrop(Seed crop) {
		this.crop = crop;
	}

	public boolean isHasStones() {
		return hasStones;
	}

	public void setHasStones(boolean hasStones) {
		this.hasStones = hasStones;
	}

	public boolean isPlowed() {
		return isPlowed;
	}

	public void setPlowed(boolean isPlowed) {
		this.isPlowed = isPlowed;
	}

	public boolean isHasWithered() {
		return hasWithered;
	}

	public void setHasWithered(boolean hasWithered) {
		this.hasWithered = hasWithered;
	}

	public boolean isHarvestable() {
		return harvestable;
	}

	public void setHarvestable(boolean harvestable) {
		this.harvestable = harvestable;
	}
	
}
