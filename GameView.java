import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * GameView class represent the graphic user interface of the farming game
 *
 */
public class GameView extends JFrame{
	private JFrame mainFrame, farmerWindow, regWindow, gameOverWindow;
	private JLabel farmer, level, coins, currentDay, farmBackground, infoBackground, exp, infoBackground1, textUpdate;
	private JButton tools[], tiles[], plants[], farmers[], advanceDay, farmerInfo, register, purchase;
	private JPanel toolsPanel, tilesPanel, plantsPanel, farmerPanel, advanceDayPanel, farmerInfoPanel, regPanel, farmersPanel, purchasePanel;

	private JPopupMenu seedPopupMenu[], toolPopupMenu[];
    private JPopupMenu popupMenu; //popup menu for each tile

	Font playerFont = new Font("Stencil", Font.PLAIN, 20);
	Font font = new Font("Stencil", Font.PLAIN, 15);
	Font smallfont = new Font("Courier", Font.BOLD, 13);
	Font gameOverFont = new Font("Stencil", Font.BOLD, 50);
	

	ImageIcon tile = new ImageIcon(new ImageIcon("tile.jpg").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));
	
    ImageIcon plowedTile = new ImageIcon(new ImageIcon("plowed_tile.jpg").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon smallSunflower = new ImageIcon(new ImageIcon("smallsunflower.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));
	
	ImageIcon smallTurnip = new ImageIcon(new ImageIcon("smallturnip.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon smallCarrot = new ImageIcon(new ImageIcon("smallcarrot.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon smallPotato = new ImageIcon(new ImageIcon("smallpotato.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon smallRose = new ImageIcon(new ImageIcon("smallrose.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon smallTulip = new ImageIcon(new ImageIcon("smalltulipPNG.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon smallMango = new ImageIcon(new ImageIcon("smallmango.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon smallApple = new ImageIcon(new ImageIcon("smallapple.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));
	
	ImageIcon sunflower = new ImageIcon(new ImageIcon("sunflower.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));
	
	ImageIcon turnip = new ImageIcon(new ImageIcon("turnip.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon carrot = new ImageIcon(new ImageIcon("carrot.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon potato = new ImageIcon(new ImageIcon("potato.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon rose = new ImageIcon(new ImageIcon("rose.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon tulip = new ImageIcon(new ImageIcon("tulip.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon mango = new ImageIcon(new ImageIcon("mango.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon apple = new ImageIcon(new ImageIcon("apple.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));
	
	ImageIcon stones = new ImageIcon(new ImageIcon("Stones.png").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));

	ImageIcon withered = new ImageIcon(new ImageIcon("deadplant.PNG").getImage().getScaledInstance(60,54, Image.SCALE_DEFAULT));


	
	ImageIcon background = new ImageIcon(new ImageIcon("Farm.JPG").getImage().getScaledInstance(1285,820, Image.SCALE_DEFAULT));

	ImageIcon farmerImage = new ImageIcon(new ImageIcon("farmer.png").getImage().getScaledInstance(90,90, Image.SCALE_DEFAULT));

	
	
	ImageIcon infoBox = new ImageIcon(new ImageIcon("infobox.png").getImage().getScaledInstance(500,90, Image.SCALE_DEFAULT));

	ImageIcon infoBox1 = new ImageIcon(new ImageIcon("infobox.png").getImage().getScaledInstance(250,90, Image.SCALE_DEFAULT));
	
	ImageIcon infoBox2 = new ImageIcon(new ImageIcon("infobox.png").getImage().getScaledInstance(118,50, Image.SCALE_DEFAULT));

	
	ImageIcon buttonImage = new ImageIcon(new ImageIcon("button.png").getImage().getScaledInstance(198,92, Image.SCALE_DEFAULT));

	ImageIcon buttonImage1 = new ImageIcon(new ImageIcon("button.png").getImage().getScaledInstance(199,64, Image.SCALE_DEFAULT));

	ImageIcon buttonImage2 = new ImageIcon(new ImageIcon("button.png").getImage().getScaledInstance(225,50, Image.SCALE_DEFAULT));

	ImageIcon buttonImage3 = new ImageIcon(new ImageIcon("button.png").getImage().getScaledInstance(118,50, Image.SCALE_DEFAULT));
	
	ImageIcon scroll = new ImageIcon(new ImageIcon("Scroll.png").getImage().getScaledInstance(1290,550, Image.SCALE_DEFAULT));

	ImageIcon scrollGameOver = new ImageIcon(new ImageIcon("gameOver.jpg").getImage().getScaledInstance(450,250, Image.SCALE_DEFAULT));
	
	
	ImageIcon legendaryFarmer1 = new ImageIcon(new ImageIcon("legendaryFarmer.png").getImage().getScaledInstance(90,90, Image.SCALE_DEFAULT));

	ImageIcon legendaryFarmer = new ImageIcon(new ImageIcon("legendaryFarmer.png").getImage().getScaledInstance(125,125, Image.SCALE_DEFAULT));

	ImageIcon distinguishedFarmer1 = new ImageIcon(new ImageIcon("distinguishedFarmer.png").getImage().getScaledInstance(90,90, Image.SCALE_DEFAULT));
	
	ImageIcon distinguishedFarmer = new ImageIcon(new ImageIcon("distinguishedFarmer.png").getImage().getScaledInstance(125,125, Image.SCALE_DEFAULT));

	ImageIcon registeredFarmer1 = new ImageIcon(new ImageIcon("registeredFarmer.png").getImage().getScaledInstance(90,90, Image.SCALE_DEFAULT));

	ImageIcon registeredFarmer = new ImageIcon(new ImageIcon("registeredFarmer.png").getImage().getScaledInstance(125,125, Image.SCALE_DEFAULT));

	/**
	 * This is the constructor for the GameView class
	 */
	public GameView() {
		this.mainFrame = new JFrame("Stardew Farm");

		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLayout(null);
		this.mainFrame.setSize(1265, 850);
		this.mainFrame.setResizable(false);
		

		this.farmer = new JLabel(farmerImage);
		this.farmer.setMinimumSize(new Dimension (50, 50));
		this.farmer.setMaximumSize(new Dimension (50, 50));
		this.farmer.setBorder(BorderFactory.createLineBorder(Color.black));
		this.farmer.setBounds(325, 10, 90, 90);
		this.mainFrame.add(this.farmer);

	

		this.farmerPanel = new JPanel(new GridLayout(2, 2));
		this.farmerPanel.setBounds(455, 10, 300, 90);
		this.farmerPanel.setMinimumSize(new Dimension (100, 50));
		this.farmerPanel.setMaximumSize(new Dimension (100, 50));

		this.farmerPanel.setBackground(new Color(0, 0, 0, 0)); 
		
		this.mainFrame.add(this.farmerPanel);
		this.farmer.validate();



		this.toolsPanel = new JPanel(new GridLayout(6, 0, 10, 10));
		this.toolsPanel.setBounds(50, 100, 200, 600);
		this.toolsPanel.setBackground(new Color(0, 0, 0, 0)); //sets the background of jpanel to transparent
		
		this.mainFrame.add(this.toolsPanel);		
		
		this.tools = new JButton[6];
		this.tools[0] = new JButton("Plow", buttonImage);
		this.tools[1] = new JButton("Watering Can", buttonImage);
		this.tools[2] = new JButton("Fertilizer", buttonImage);
		this.tools[3] = new JButton("Pickaxe", buttonImage);
		this.tools[4] = new JButton("Shovel", buttonImage);
		this.tools[5] = new JButton("Harvest", buttonImage);


		
		for(int j = 0; j < this.tools.length; j++) {
			this.tools[j].setFont(font);
			this.tools[j].setHorizontalTextPosition(JButton.CENTER);
			this.tools[j].setVerticalTextPosition(JButton.CENTER);
			this.tools[j].setBackground(new Color(0, 0, 0, 0));
			this.toolsPanel.add(this.tools[j]);
		}



		this.tilesPanel = new JPanel(new GridLayout(5,10, 0, 0));
		this.tilesPanel.setBounds(325, 430, 600, 270);
	
		this.tilesPanel.setBackground(new Color(0, 0, 0, 0)); //sets the background of jpanel to transparent
	


		this.tiles = new JButton[50];

		tile = new ImageIcon(new ImageIcon("tile.JPG").getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT));

		

        //TILES
		for(int i = 0; i < this.tiles.length; i++) {
			this.tiles[i] = new JButton(tile);
			this.tiles[i].setPreferredSize(new Dimension(40, 40));
			this.tilesPanel.add(this.tiles[i]);
		}
		


        //Plant Buttons
		this.plants = new JButton[8];
		this.plants[0] = new JButton("Turnip", buttonImage1);
		this.plants[1] = new JButton("Carrot", buttonImage1);
		this.plants[2] = new JButton("Potato", buttonImage1);
		this.plants[3] = new JButton("Rose", buttonImage1);
		this.plants[4] = new JButton("Tulip", buttonImage1);
		this.plants[5] = new JButton("Sunflower", buttonImage1);
		this.plants[6] = new JButton("Mango", buttonImage1);
		this.plants[7] = new JButton("Apple", buttonImage1);

		this.plantsPanel = new JPanel(new GridLayout(8, 0, 10, 10));
		this.plantsPanel.setBounds(1000, 100, 200, 600);
		this.plantsPanel.setBackground(new Color(0, 0, 0, 0)); //sets the background of jpanel to transparent

		this.mainFrame.add(this.plantsPanel);

		for(int j = 0; j < this.plants.length; j++) {
			this.plants[j].setFont(font);
			this.plants[j].setHorizontalTextPosition(JButton.CENTER);
			this.plants[j].setVerticalTextPosition(JButton.CENTER);
			this.plants[j].setBackground(new Color(0, 0, 0, 0));
			this.plantsPanel.add(this.plants[j]);
		}

        //Panel that contains Advance Day Button
		this.advanceDayPanel = new JPanel(new GridLayout(1,0));
		this.advanceDayPanel.setBounds(700, 750, 225, 50);

		this.advanceDay = new JButton("Advance Day", buttonImage2);
		this.advanceDay.setFont(font);
		this.advanceDay.setHorizontalTextPosition(JButton.CENTER);
		this.advanceDay.setVerticalTextPosition(JButton.CENTER);
		this.advanceDay.setBackground(new Color(0, 0, 0, 0));
		this.advanceDayPanel.add(this.advanceDay);
		this.mainFrame.add(this.advanceDayPanel);
		
        //Farmer Info Panel contains Farmer Info Button that opens up another JFrame containing Farmer Info
		this.farmerInfoPanel = new JPanel(new GridLayout(1,0));
		this.farmerInfoPanel.setBounds(325, 750, 225, 50);

		this.farmerInfo = new JButton("Farmer Info", buttonImage2);
		this.farmerInfo.setFont(font);
		this.farmerInfo.setHorizontalTextPosition(JButton.CENTER);
		this.farmerInfo.setVerticalTextPosition(JButton.CENTER);
		this.farmerInfo.setBackground(new Color(0, 0, 0, 0));
		
		this.mainFrame.add(this.farmerInfoPanel);
		this.farmerInfoPanel.add(this.farmerInfo);



		//consists of all Pop Up Menus containing Seed Information
		this.seedPopupMenu = new JPopupMenu[8];
		for(int i = 0 ; i < this.seedPopupMenu.length; i++) {
			this.seedPopupMenu[i] = new JPopupMenu();
		}

		

		this.seedPopupMenu[0].add(new JMenuItem("Seed Name: Turnip"));
		this.seedPopupMenu[0].add(new JMenuItem("Crop Type: Root Crop"));
		this.seedPopupMenu[0].add(new JMenuItem("Harvest Time: 2"));
		this.seedPopupMenu[0].add(new JMenuItem("Water Needs: 1"));
		this.seedPopupMenu[0].add(new JMenuItem("Fertilizer Needs: 0"));
		this.seedPopupMenu[0].add(new JMenuItem("Product Produced: 1-2"));
		this.seedPopupMenu[0].add(new JMenuItem("Selling Price Per Piece: 6"));
		this.seedPopupMenu[0].add(new JMenuItem("Experience Yield: 5"));
		this.seedPopupMenu[0].add(new JMenuItem("Seed Cost: 5"));


		this.seedPopupMenu[1].add(new JMenuItem("Seed Name: Carrot"));
		this.seedPopupMenu[1].add(new JMenuItem("Crop Type: Root Crop"));
		this.seedPopupMenu[1].add(new JMenuItem("Harvest Time: 3"));
		this.seedPopupMenu[1].add(new JMenuItem("Water Needs: 1"));
		this.seedPopupMenu[1].add(new JMenuItem("Fertilizer Needs: 0"));
		this.seedPopupMenu[1].add(new JMenuItem("Product Produced: 1-2"));
		this.seedPopupMenu[1].add(new JMenuItem("Selling Price Per Piece: 9"));
		this.seedPopupMenu[1].add(new JMenuItem("Experience Yield: 7.5"));
		this.seedPopupMenu[1].add(new JMenuItem("Seed Cost: 10"));

		this.seedPopupMenu[2].add(new JMenuItem("Seed Name: Potato"));
		this.seedPopupMenu[2].add(new JMenuItem("Crop Type: Root Crop"));
		this.seedPopupMenu[2].add(new JMenuItem("Harvest Time: 5"));
		this.seedPopupMenu[2].add(new JMenuItem("Water Needs: 3"));
		this.seedPopupMenu[2].add(new JMenuItem("Fertilizer Needs: 1"));
		this.seedPopupMenu[2].add(new JMenuItem("Product Produced: 1-10"));
		this.seedPopupMenu[2].add(new JMenuItem("Selling Price Per Piece: 33"));
		this.seedPopupMenu[2].add(new JMenuItem("Experience Yield: 12.5"));
		this.seedPopupMenu[2].add(new JMenuItem("Seed Cost: 20"));

		this.seedPopupMenu[3].add(new JMenuItem("Seed Name: Rose"));
		this.seedPopupMenu[3].add(new JMenuItem("Crop Type: Flower"));
		this.seedPopupMenu[3].add(new JMenuItem("Harvest Time: 1"));
		this.seedPopupMenu[3].add( new JMenuItem("Water Needs: 1"));
		this.seedPopupMenu[3].add(new JMenuItem("Fertilizer Needs: 0"));
		this.seedPopupMenu[3].add(new JMenuItem("Product Produced: 1"));
		this.seedPopupMenu[3].add(new JMenuItem("Selling Price Per Piece: 5"));
		this.seedPopupMenu[3].add(new JMenuItem("Experience Yield: 2.5"));
		this.seedPopupMenu[3].add(new JMenuItem("Seed Cost: 5"));


		this.seedPopupMenu[4].add(new JMenuItem("Seed Name: Tulips"));
		this.seedPopupMenu[4].add(new JMenuItem("Crop Type: Flower"));
		this.seedPopupMenu[4].add(new JMenuItem("Harvest Time: 2"));
		this.seedPopupMenu[4].add(new JMenuItem("Water Needs: 2"));
		this.seedPopupMenu[4].add(new JMenuItem("Fertilizer Needs: 0"));
		this.seedPopupMenu[4].add(new JMenuItem("Product Produced: 1"));
		this.seedPopupMenu[4].add(new JMenuItem("Selling Price Per Piece: 9"));
		this.seedPopupMenu[4].add(new JMenuItem("Experience Yield: 5"));
		this.seedPopupMenu[4].add(new JMenuItem("Seed Cost: 10"));

		this.seedPopupMenu[5].add(new JMenuItem("Seed Name: Sunflower"));
		this.seedPopupMenu[5].add(new JMenuItem("Crop Type: Flower"));
		this.seedPopupMenu[5].add(new JMenuItem("Harvest Time: 3"));
		this.seedPopupMenu[5].add(new JMenuItem("Water Needs: 2"));
		this.seedPopupMenu[5].add(new JMenuItem("Fertilizer Needs: 1"));
		this.seedPopupMenu[5].add(new JMenuItem("Product Produced: 1"));
		this.seedPopupMenu[5].add(new JMenuItem("Selling Price Per Piece: 19"));
		this.seedPopupMenu[5].add(new JMenuItem("Experience Yield: 7.5"));
		this.seedPopupMenu[5].add(new JMenuItem("Seed Cost: 20"));

		this.seedPopupMenu[6].add(new JMenuItem("Seed Name: Mango"));
		this.seedPopupMenu[6].add(new JMenuItem("Crop Type: Fruit Tree"));
		this.seedPopupMenu[6].add(new JMenuItem("Harvest Time: 10"));
		this.seedPopupMenu[6].add(new JMenuItem("Water Needs: 7"));
		this.seedPopupMenu[6].add( new JMenuItem("Fertilizer Needs: 4"));
		this.seedPopupMenu[6].add(new JMenuItem("Product Produced: 5-15"));
		this.seedPopupMenu[6].add(new JMenuItem("Selling Price Per Piece: 8"));
		this.seedPopupMenu[6].add(new JMenuItem("Experience Yield: 25"));
		this.seedPopupMenu[6].add(new JMenuItem("Seed Cost: 100"));


		this.seedPopupMenu[7].add(new JMenuItem("Seed Name: Apple"));
		this.seedPopupMenu[7].add(new JMenuItem("Crop Type: Fruit Tree"));
		this.seedPopupMenu[7].add(new JMenuItem("Harvest Time: 10"));
		this.seedPopupMenu[7].add(new JMenuItem("Water Needs: 7"));
		this.seedPopupMenu[7].add(new JMenuItem("Fertilizer Needs: 5"));
		this.seedPopupMenu[7].add(new JMenuItem("Product Produced: 10-15"));
		this.seedPopupMenu[7].add(new JMenuItem("Selling Price Per Piece: 5"));
		this.seedPopupMenu[7].add(new JMenuItem("Experience Yield: 25"));
		this.seedPopupMenu[7].add(new JMenuItem("Seed Cost: 200"));


        //consists of all Pop Up Menus containing Tool Information
        this.toolPopupMenu = new JPopupMenu[6];
		for(int i = 0; i<toolPopupMenu.length; i++){
			this.toolPopupMenu[i] = new JPopupMenu();
		}

		this.toolPopupMenu[0].add(new JMenuItem("Converts an unplowed tile to a plowed tile."));
		this.toolPopupMenu[0].add(new JMenuItem("Can only be performed on an unplowed tile."));
		this.toolPopupMenu[0].add(new JMenuItem("Cost: 0"));
		this.toolPopupMenu[0].add(new JMenuItem("Experience Yield: 0.5"));

		this.toolPopupMenu[1].add(new JMenuItem("Adds to the total number of tiles"));
		this.toolPopupMenu[1].add(new JMenuItem("a tile/crop has been watered. Can only be"));
		this.toolPopupMenu[1].add(new JMenuItem("performed on a plowed tile with a crop."));
		this.toolPopupMenu[1].add(new JMenuItem("Cost: 0"));
		this.toolPopupMenu[1].add(new JMenuItem("Experience Yield: 0.5"));

		this.toolPopupMenu[2].add(new JMenuItem("Adds to the total number of tiles"));
		this.toolPopupMenu[2].add(new JMenuItem("a tile/crop has been fertilized. Can only be"));
		this.toolPopupMenu[2].add(new JMenuItem("performed on a plowed tile with a crop."));
		this.toolPopupMenu[2].add(new JMenuItem("Cost: 10"));
		this.toolPopupMenu[2].add(new JMenuItem("Experience Yield: 4"));

		this.toolPopupMenu[3].add(new JMenuItem("Removes a rock from a tile."));
		this.toolPopupMenu[3].add(new JMenuItem("Can only be applied to tiles with a rock."));
		this.toolPopupMenu[3].add(new JMenuItem("Cost: 50"));
		this.toolPopupMenu[3].add(new JMenuItem("Experience Yield: 15"));

		this.toolPopupMenu[4].add(new JMenuItem("Removes a withered plant from a tile."));
		this.toolPopupMenu[4].add(new JMenuItem("Can be used on any tile/crop with varying "));
		this.toolPopupMenu[4].add(new JMenuItem("effects, as described above."));
		this.toolPopupMenu[4].add(new JMenuItem("Cost: 7"));
		this.toolPopupMenu[4].add(new JMenuItem("Experience Yield: 2"));
		
		this.mainFrame.add(this.toolsPanel);
		this.mainFrame.add(this.tilesPanel);
		this.mainFrame.add(this.plantsPanel);
		this.mainFrame.add(this.farmerPanel);
		this.mainFrame.add(this.advanceDayPanel);

		// this.infoBackground = new JLabel(infoBox);
		// this.infoBackground.setBounds(425, 10, 500, 90);
		// this.mainFrame.add(this.infoBackground);

	


		this.currentDay = new JLabel();
		this.currentDay.setFont(playerFont);
		this.currentDay.setBounds(825, 10, 500, 90);
		this.mainFrame.add(this.currentDay);
		
		
		this.level = new JLabel();
		this.coins = new JLabel();
		this.exp = new JLabel();
		this.level.setBounds(455, 0, 500, 90);
		this.coins.setBounds(600, 0, 500, 90);
		this.exp.setBounds(455, 35, 500, 90);
		this.exp.setFont(playerFont);
		this.level.setFont(playerFont);
		this.coins.setFont(playerFont);
		this.mainFrame.add(this.level);
		this.mainFrame.add(this.coins);
		this.mainFrame.add(this.exp);


		this.textUpdate = new JLabel();
		this.textUpdate.setText("Welcome to Farmville!!");
		this.textUpdate.setBounds(970, 5, 500, 90);
		this.mainFrame.add(this.textUpdate);


		this.infoBackground = new JLabel(infoBox);
		this.infoBackground.setBounds(425, 10, 500, 90);
		this.mainFrame.add(this.infoBackground);

		this.infoBackground1 = new JLabel(infoBox1);
		this.infoBackground1.setBounds(955, 10, 250, 90);
		this.mainFrame.add(this.infoBackground1);


		farmBackground = new JLabel(background);
		farmBackground.setBounds(-10, -20 , 1265, 850);
		this.mainFrame.add(farmBackground);

		

		this.mainFrame.setVisible(true);
	}

	
	/**
	 * Initializes the game over view window
	 */
	public void gameOverView() {

		JFrame gameOverFrame = new JFrame();

		gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameOverFrame.setLayout(null);
		gameOverFrame.setSize(460, 320);
		gameOverFrame.setLocationRelativeTo(null);
		gameOverFrame.setVisible(true);
		gameOverFrame.setResizable(false);

		JLabel gameOver = new JLabel("Game Over");
		gameOverFrame.add(gameOver);

		JLabel farmBackground = new JLabel(scrollGameOver);
		farmBackground.setBounds(0, 0, 450, 300);
		gameOverFrame.add(farmBackground);
			
	


	}
	
	
	/**
	 * Initializes the register requirements window
	 */
	public void registerRequirements() {
		this.farmerWindow = new JFrame();
		this.farmerWindow.setSize(1300, 600);
		this.farmerWindow.setLocationRelativeTo(null);
		this.farmerWindow.setVisible(true);
		this.farmerWindow.setResizable(false);


		JLabel farmerType[] = new JLabel[5];
		
		farmerType[0] = new JLabel("Farmer Type");
		farmerType[1] = new JLabel("Farmer (default)");
		farmerType[2] = new JLabel("Registered Farmer");
		farmerType[3] = new JLabel("Distinguished Farmer");
		farmerType[4] = new JLabel("Legendary Farmer");
		
		JLabel level[] = new JLabel[5];
		
		level[0] = new JLabel("Level Requirement");
		level[1] = new JLabel("0");
		level[2] = new JLabel("5");
		level[3] = new JLabel("10");
		level[4] = new JLabel("15");


		JLabel bonus[] = new JLabel[5];
	
		bonus[0] = new JLabel("Bonus Earnings per Produce");
		bonus[1] = new JLabel("+0");
		bonus[2] = new JLabel("+1");
		bonus[3] = new JLabel("+2");
		bonus[4] = new JLabel("+4");

		JLabel seedCost[] = new JLabel[5];
		
		seedCost[0] = new JLabel("Seed Cost Reduction");
		seedCost[1] = new JLabel("-0");
		seedCost[2] = new JLabel("-1");
		seedCost[3] = new JLabel("-2");
		seedCost[4] = new JLabel("-4");

		JLabel waterBonus[] = new JLabel[5];
		
		waterBonus[0] = new JLabel("Water Bonus Limit Increase");
		waterBonus[1] = new JLabel("+0");
		waterBonus[2] = new JLabel("+1");
		waterBonus[3] = new JLabel("+2");
		waterBonus[4] = new JLabel("+4");

		JLabel fertiBonus[] = new JLabel[5];
		
		fertiBonus[0] = new JLabel("Fertilizer Bonus Limit Increase");
		fertiBonus[1] = new JLabel("+0");
		fertiBonus[2] = new JLabel("+0");
		fertiBonus[3] = new JLabel("+0");
		fertiBonus[4] = new JLabel("+1");

		JLabel regFee[] = new JLabel[5];
		
		regFee[0] = new JLabel("Registration Fee");
		regFee[1] = new JLabel("N/A");
		regFee[2] = new JLabel("200");
		regFee[3] = new JLabel("300");
		regFee[4] = new JLabel("400");

		this.regPanel = new JPanel(new GridLayout(1,0));
		this.regPanel.setBounds(530, 490, 225, 50);
		

		this.register = new JButton("Register", buttonImage2);
		this.register.setFont(font);
		this.register.setHorizontalTextPosition(JButton.CENTER);
		this.register.setVerticalTextPosition(JButton.CENTER);
		this.register.setBackground(new Color(0, 0, 0, 0));
		this.regPanel.add(register);
		
		
		JPanel farmerPanel = new JPanel(new GridLayout(5, 7, 5, 5));
		farmerPanel.setBounds(18, 60,1250, 425);

		farmerPanel.setBackground(new Color(0, 0, 0, 0)); 
	

		for(int j = 0; j < farmerType.length; j++) {
			farmerType[j].setBorder(BorderFactory.createLineBorder(Color.black));
			farmerType[j].setFont(smallfont);
			farmerPanel.add(farmerType[j]);
			
	
			level[j].setHorizontalAlignment(JLabel.CENTER);
			level[j].setFont(smallfont);
			level[j].setBorder(BorderFactory.createLineBorder(Color.black));
			farmerPanel.add(level[j]);

			bonus[j].setHorizontalAlignment(JLabel.CENTER);
			bonus[j].setFont(smallfont);
			bonus[j].setBorder(BorderFactory.createLineBorder(Color.black));
			farmerPanel.add(bonus[j]);

			seedCost[j].setHorizontalAlignment(JLabel.CENTER);
			seedCost[j].setFont(smallfont);
			seedCost[j].setBorder(BorderFactory.createLineBorder(Color.black));
			farmerPanel.add(seedCost[j]);

			waterBonus[j].setHorizontalAlignment(JLabel.CENTER);
			waterBonus[j].setFont(smallfont);
			waterBonus[j].setBorder(BorderFactory.createLineBorder(Color.black));
			farmerPanel.add(waterBonus[j]);

			fertiBonus[j].setHorizontalAlignment(JLabel.CENTER);
			fertiBonus[j].setFont(smallfont);
			fertiBonus[j].setBorder(BorderFactory.createLineBorder(Color.black));
			farmerPanel.add(fertiBonus[j]);

			regFee[j].setHorizontalAlignment(JLabel.CENTER);
			regFee[j].setFont(smallfont);
			regFee[j].setBorder(BorderFactory.createLineBorder(Color.black));
			farmerPanel.add(regFee[j]);

		}


		this.farmerWindow.add(farmerPanel);
		this.farmerWindow.add(regPanel);


		farmBackground = new JLabel(scroll);
		farmBackground.setBounds(0, 0, 1265, 850);
		this.farmerWindow.add(farmBackground);
	}
	
	/**
	 * Initializes the promotion window
	 */
	public void upgradeList() {
		this.regWindow = new JFrame();
		this.regWindow.setLayout(null);
		this.regWindow.setSize(450, 300);
		this.regWindow.setLocationRelativeTo(null);
		this.regWindow.setVisible(true);
		this.regWindow.setResizable(false);
		

		this.farmersPanel = new JPanel(new GridLayout(1, 3, 7, 5));
		this.farmersPanel.setBounds(15, 10, 400, 125);

		this.regWindow.add(this.farmersPanel);

        //Panel containing choices of farmers
		JPanel infoPanel = new JPanel(new GridLayout(0, 3, 15, 5));
		infoPanel.setBounds(18, 130, 400, 70);
	
		this.regWindow.add(infoPanel);
		

		this.farmers = new JButton[3];
		this.farmers[0] = new JButton(registeredFarmer);
		this.farmers[1] = new JButton(distinguishedFarmer);
		this.farmers[2] = new JButton(legendaryFarmer);

		JLabel farmerTypes[] = new JLabel[3];
		farmerTypes[0] = new JLabel("Registered");
		farmerTypes[1] = new JLabel("Distinguished");
		farmerTypes[2] = new JLabel("Legendary");


		for(int j = 0; j < this.farmers.length; j++) {
			this.farmers[j].setBackground(new Color(0, 0, 0, 0));
			this.farmersPanel.add(this.farmers[j]);
		}

		for(int j = 0; j < this.farmers.length; j++) {
			farmerTypes[j].setBackground(new Color(0, 0, 0, 0));
			farmerTypes[j].setHorizontalTextPosition(JLabel.CENTER);
			farmerTypes[j].setFont(smallfont);
			farmerTypes[j].setIcon(infoBox2);

			infoPanel.add(farmerTypes[j]);
		}

		this.purchasePanel = new JPanel(new GridLayout(0, 1, 15, 5));
		this.purchasePanel.setBounds(165, 200, 100, 50);

		this.purchase = new JButton("Register", buttonImage3);
		this.purchase.setBackground(new Color(0, 0, 0, 0));
		this.purchase.setHorizontalTextPosition(JButton.CENTER);
		this.purchase.setFont(smallfont);
		this.purchasePanel.add(this.purchase);


		this.regWindow.add(this.farmersPanel);
		this.regWindow.add(this.purchasePanel);
	}
	
	/**
	 * Initializes the game over window
	 */
	public void gameOverWindow(){
		this.gameOverWindow = new JFrame();
		this.gameOverWindow.setLayout(null);
		this.gameOverWindow.setSize(450, 300);
		this.gameOverWindow.setLocationRelativeTo(null);
		this.gameOverWindow.setVisible(true);
		this.gameOverWindow.setResizable(false);


		
		JLabel scrolll = new JLabel(scroll);
		scrolll.setBounds(0, 0, 450, 300);
		this.gameOverWindow.add(scrolll);

		JLabel gameOver = new JLabel("Game Over");
		gameOver.setBounds(0, 0, 450, 300);
		gameOver.setFont(gameOverFont);
		this.gameOverWindow.add(gameOver);
	}
	
	
	public JButton getRegister() {
		return register;
	}


	public JButton getPurchase() {
		return purchase;
	}

	public JButton getFarmerInfo() {
		return farmerInfo;
	}

	
	public JFrame getFarmerWindow() {
		return farmerWindow;
	}

	public JFrame getRegWindow() {
		return regWindow;
	}

    public JLabel getTextUpdate() {
		return textUpdate;
	}

	public void setTextUpdate(JLabel textUpdate) {
		this.textUpdate = textUpdate;
	}

	public JLabel getExpUpdate() {
		return exp;
	}

	public void setExpUpdate(JLabel exp) {
		this.exp = exp;
	}

	public JLabel getLevelUpdate() {
		return level;
	}

	public void setLevelUpdate(JLabel level) {
		this.level = level;
	}

	public JLabel getCoinpUpdate() {
		return coins;
	}

	public void setCoinUpdate(JLabel coins) {
		this.coins = coins;
	}

	public JLabel getDayUpdate() {
		return currentDay;
	}

	public void setDayUpdate(JLabel currentDay) {
		this.currentDay = currentDay;
	}

	public JLabel getFarmerType() {
		return this.farmer;
	}

	public JFrame getMainFrame() {
		return this.mainFrame;
	}

	public void setFarmerType(JLabel farmer) {
		this.farmer = farmer;
	}


	


	public JButton[] getTiles() {
		return this.tiles;
	}

    public JButton[] getTools() {
		return this.tools;
	}

    public JButton[] getPlants() {
		return this.plants;
	}

	public JButton getPlowed() {
		return this.tools[0];
	}

	public JButton getWater() {
		return this.tools[1];
	}

	public JButton getFert() {
		return this.tools[2];
	}
	public JButton getDay(){
		return this.advanceDay;
	}

	public JButton[] getFarmers(){
		return this.farmers;
	}
	
	public void setActionListenerForFarmerInfo(ActionListener action) {
		this.farmerInfo.addActionListener(action);
	}
	
	public void setActionListenerForRegister(ActionListener action) {
		this.register.addActionListener(action);
	}
	
	public void setActionListenerForUpgrade(ActionListener action) {
		for(int j = 0; j < this.farmers.length; j++) {
			this.farmers[j].addActionListener(action);
		}
		this.purchase.addActionListener(action);
	}

	public void addActionListeneronTiles(int i, MouseListener mouseListener) {
        this.tiles[i].addMouseListener(mouseListener);
	}

	public void addActionListenerAdvanceDay(MouseListener mouseListener){
		this.advanceDay.addMouseListener(mouseListener);
	}


	public void addActionListenerRegister(MouseListener mouseListener){
		this.purchase.addMouseListener(mouseListener);
	}

    public void addActionListeneronTools(int i, MouseListener mouseListener) {
        this.tools[i].addMouseListener(mouseListener);
	}

    public void addActionListeneronPlants(int i, MouseListener mouseListener) {
        this.plants[i].addMouseListener(mouseListener);
	}

	public void setAddTileBtnListener(ActionListener listener){
        for(int i = 0; i < this.tiles.length; i++){
          this.tiles[i].addActionListener(listener);
        }
      }

	public int rightClickIndex(JButton b) {
        for (int i = 0; i < this.tiles.length; i++) {
          if (b == this.tiles[i]) {
            return i;
          }
        }
        return -1;
      }
	
	public int leftClickIndex(JButton b) {
        for (int i = 0; i < this.tiles.length; i++) {
          if (b == this.tiles[i]) {
            return i;
          }
        }
        return -1;
      }


      public int rightClickIndexTools(JButton b) {
        for (int i = 0; i < this.tools.length; i++) {
          if (b == this.tools[i]) {
            return i;
          }
        }
        return -1;
      }
      
      public int leftClickIndexTools(JButton b) {
          for (int i = 0; i < this.tools.length; i++) {
            if (b == this.tools[i]) {
              return i;
            }
          }
          return -1;
        }

      public int rightClickIndexPlants(JButton b) {
        for (int i = 0; i < this.plants.length; i++) {
          if (b == this.plants[i]) {
            return i;
          }
        }
        return -1;
      }
      
      public int leftClickIndexPlants(JButton b) {
          for (int i = 0; i < this.plants.length; i++) {
            if (b == this.plants[i]) {
              return i;
            }
          }
          return -1;
        }

		public int leftClickIndexFarmers(JButton b) {
			for (int i = 0; i < this.farmers.length; i++) {
			  if (b == this.farmers[i]) {
				return i;
			  }
			}
			return -1;
		  }


    public void setPopupMenu(JPopupMenu popupMenu, int i, int x, int y){
        this.popupMenu = popupMenu;
        this.popupMenu.show(tiles[i], x, y);
    }

    public void setPopupMenuTools(JPopupMenu popupMenu, int i, int x, int y){
        this.toolPopupMenu[i].show(tools[i], x, y);
    }

    public void setPopupMenuPlants(JPopupMenu popupMenu, int i, int x, int y){
        this.seedPopupMenu[i].show(plants[i], x, y);
    }
}