import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * GameController class represent the controller of the farming game
 *
 */
public class GameController implements ActionListener{
    private GameModel gameModel = new GameModel();
    private GameView gameView;
    private Tools toolSelect;
    private Seed seedSelect;
    private FarmerType farmerSelect;
    private int select = 0;
    private int selectFarmer = 0;
    private int latestFarmer = 0;
    
    
    
    /**
     * Updates the player status on the GUI
     * @param player - player of the game
     */
    public void updatePlayer(Player player) {
    	var level = gameView.getLevelUpdate();
    	var coins = gameView.getCoinpUpdate();
    	var exp = gameView.getExpUpdate();
    	var day = gameView.getDayUpdate();
    	
    	int playerLvl = (int) player.getExp() / 100;
    	player.setLevel(playerLvl);
  
    	
    	level.setText("Level: " + player.getLevel());
    	coins.setText("Coins: " + String.format("%.2f", player.getCoins()));
    	exp.setText("Exp: " +  String.format("%.2f", player.getExp()));
    	day.setText("Day: " + player.getDayCount());
    	
    	gameView.setLevelUpdate(level);
    	gameView.setCoinUpdate(coins);
    	gameView.setExpUpdate(exp);
    	gameView.setDayUpdate(day);
    	
    	if(latestFarmer > 0) {
    		var farmerIcon = gameView.getFarmerType();
    		if(latestFarmer == 1) {
    			farmerIcon.setIcon(gameView.registeredFarmer1);
    		}
    		else if(latestFarmer == 2) {
    			farmerIcon.setIcon(gameView.distinguishedFarmer1);
    		}
    		else if(latestFarmer == 3) {
    			farmerIcon.setIcon(gameView.legendaryFarmer1);
    		}
    		
    		gameView.setFarmerType(farmerIcon);
    	}
    	updateLot();
    }
    
    /**
     * Checks if the lot is harvestable or has withered
     * @param lot - lot of the game
     * @param i - index of lot
     */
    public void checkLots(Lot lot, int i) {
    	var crop = lot.getCrop();
    	if(crop.getAge() == crop.getHarvestTime() && crop.getWater() >= crop.getWaterMin() 
    			&& crop.getFertilizer() >= crop.getFertilizerMin()) {
    		lot.setHarvestable(true);
    	} else if(lot.isHarvestable() && crop.getAge() > crop.getHarvestTime() || (crop.getAge() == crop.getHarvestTime()
    			&& (crop.getWater() < crop.getWaterMin() || crop.getFertilizer() < crop.getFertilizerMin()))) {
    		lot.setHarvestable(false);
    		lot.setHasWithered(true);
        gameView.getTiles()[i].setIcon(gameView.withered);
        
    	}
    }
    
    /**
     * Checks the nearby lots if its occupied or not
     * @param lot - lot of the game
     * @param lotNum - index of the lot
     * @return true if its occupied
     */
    public boolean checkNearby(Lot[] lot, int lotNum) {
    	if(lot[lotNum].isHasStones() || lot[lotNum].getCrop()!= null) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * Checks if the tree to be planted has nearby occupied lots
     * @param lot - lot of the game
     * @param lotNum - index number of the lot
     * @param seed - seed to be planted
     * @return false if the tree seed can't be planted
     */
    public boolean checkTrees(Lot[] lot, int lotNum , Seed seed) {
    	if(seed.getType().equals("Fruit Tree")) {
    		int sides = lotNum % 10;
    		if(lotNum > 39 || lotNum < 10 || sides == 0 || sides == 9) {
    			return false;
    		} else {
    			if(checkNearby(lot, lotNum - 10) || checkNearby(lot, lotNum - 9) || checkNearby(lot, lotNum - 11)
    				|| checkNearby(lot, lotNum - 1) || checkNearby(lot, lotNum + 1) || checkNearby(lot, lotNum + 10)
    				|| checkNearby(lot, lotNum + 9) || checkNearby(lot, lotNum + 11)) {
    				return false;
    			}
    		}
    	}
    	return true;
    }

    
    
    /**
     * Updates the lot icon depending on the seed planted if it became harvestable
     */
    public void updateLot() {
      for(int i = 0; i < gameModel.getLot().length; i++) {
        if(gameModel.getLot()[i].isHarvestable()){
          if(gameModel.getLot()[i].getCrop().getName().equals("Turnip")){
            gameView.getTiles()[i].setIcon(gameView.turnip);
          }
          else if(gameModel.getLot()[i].getCrop().getName().equals("Rose")){
            gameView.getTiles()[i].setIcon(gameView.rose);
          }
          else if(gameModel.getLot()[i].getCrop().getName().equals("Potato")){
            gameView.getTiles()[i].setIcon(gameView.potato);
          }
          else if(gameModel.getLot()[i].getCrop().getName().equals("Carrot")){
            gameView.getTiles()[i].setIcon(gameView.carrot);
          }
          else if(gameModel.getLot()[i].getCrop().getName().equals("Tulip")){
            gameView.getTiles()[i].setIcon(gameView.tulip);
          }
          else if(gameModel.getLot()[i].getCrop().getName().equals("Sunflower")){
            gameView.getTiles()[i].setIcon(gameView.sunflower);
          }
          else if(gameModel.getLot()[i].getCrop().getName().equals("Mango")){
            gameView.getTiles()[i].setIcon(gameView.mango);
          }
          else if(gameModel.getLot()[i].getCrop().getName().equals("Apple")){
            gameView.getTiles()[i].setIcon(gameView.apple);
          }      
          
        }
      }

    }
    

    


	/**
	 * This is the initiator for the controller of the game
	 * @param gameView - GUI of the game
	 */
	public GameController(GameView gameView) {
 
        this.gameView = gameView;
        gameModel.initialize();
        gameView.setActionListenerForFarmerInfo(this);
        updatePlayer(gameModel.getPlayer());
        //setLot(gameModel.getLot());
        for(int i = 0; i < gameModel.getLot().length; i++) {
          if(gameModel.getLot()[i].isHasStones()){
            gameView.getTiles()[i].setIcon(gameView.stones);
          }
        }


        for (int i = 0; i < gameView.getTiles().length; i++) {
          gameView.addActionListeneronTiles(i, new MouseListener()
          {
    
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
              // TODO Auto-generated method stub
            	if(SwingUtilities.isLeftMouseButton(e)){
            		JLabel update = new JLabel();
                	update = gameView.getTextUpdate();
                	int i = gameView.leftClickIndex((JButton) e.getSource());
                  if(select == 1) {
                	  if(toolSelect.getType().equals("Plow")) {
                		  var status = gameModel.getLot()[i].plow(toolSelect, gameModel.getPlayer());                      
                    	  if(status == true) {
                          gameView.getTiles()[i].setIcon(gameView.plowedTile);
                        	  update.setText("You plowed Tile No. " + (i + 1));
                    	  } else {
                    		  update.setText("You can't plow this tile!");
                    	  }
                    	  
                    	  gameView.setTextUpdate(update);
                	  }  
                    else if (toolSelect.getType().equals("Pickaxe")) {
                		  var status = gameModel.getLot()[i].pick(toolSelect, gameModel.getPlayer());
                    	  if(status == true) {
                          gameView.getTiles()[i].setIcon(gameView.tile);
                    		  update.setText("You pickaxed Tile No. " + (i + 1));
                    	  } else {
                    		  update.setText("You don't have enough coins/This is not a rock!");
                    	  }
                    	  gameView.setTextUpdate(update);
                	  }
                	  else if (toolSelect.getType().equals("Shovel")) {
                		  var status = gameModel.getLot()[i].dig(toolSelect, gameModel.getPlayer());
                    	  if(status == true) {
                          gameView.getTiles()[i].setIcon(gameView.tile);
                    		  update.setText("You dug Tile No. " + (i + 1));
                    	  } else {
                    		  update.setText("You don't have enough coins to use shovel!");
                    	  }
                    	  gameView.setTextUpdate(update);
                	  }
                	  else if(toolSelect.getType().equals("Watering Can")) {
                		  var status = gameModel.getLot()[i].water(toolSelect, gameModel.getPlayer());                   	  
                    	  if(status == true) {
                        	  update.setText("You watered Tile No. " + (i + 1));
                    	  } else if (gameModel.getLot()[i].isHasWithered()) {
                    		  update.setText("Crop has withered at Tile No. " + (i + 1));
                    	  }
                    	  else {
                    		  update.setText("There's no crop at Tile No. " + (i + 1));
                    	  }
                	  }
                	  else if(toolSelect.getType().equals("Fertilizer")) {
                		  var status = gameModel.getLot()[i].fertilize(toolSelect, gameModel.getPlayer());                   	  
                    	  if(status == true) {
                        	  update.setText("You fertilized Tile No. " + (i + 1));
                    	  }	else if (gameModel.getLot()[i].isHasWithered()) {
                    		  update.setText("Crop has withered at Tile No. " + (i + 1));
                    	  }else {
                    		  update.setText("Not enought coins / There's no crop to fertilize at Tile No. " + (i + 1));
                    	  }
                	  }
                	  else if(toolSelect.getType().equals("Harvest")) {
                		  if(gameModel.getLot()[i].isHarvestable()) {
                			  var results = gameModel.getLot()[i].harvest(gameModel.getPlayer());
                			  update.setText(results);
                			  gameModel.getLot()[i].setCrop(null);
                			  gameView.getTiles()[i].setIcon(gameView.tile);
                		  } else {
                			  update.setText("You can't harvest Tile No. " + (i + 1));
                		  }
                	  }
                  } else if(select == 2) {
                	  Seed crop = new Seed(seedSelect);
                	  if(checkTrees(gameModel.getLot(), i, crop)) {
                		  var status = gameModel.getLot()[i].plant(crop, gameModel.getPlayer());
                    	  if(status == true) {
                    		  update.setText("You planted " + seedSelect.getName() + " on Tile No. " + (i + 1));
                            if(seedSelect.getName().equals("Turnip")){
                              gameView.getTiles()[i].setIcon(gameView.smallTurnip);
                            }
                            else if(seedSelect.getName().equals("Rose")){
                              gameView.getTiles()[i].setIcon(gameView.smallRose);
                            }
                            else if(seedSelect.getName().equals("Potato")){
                              gameView.getTiles()[i].setIcon(gameView.smallPotato);
                            }
                            else if(seedSelect.getName().equals("Carrot")){
                              gameView.getTiles()[i].setIcon(gameView.smallCarrot);
                            }
                            else if(seedSelect.getName().equals("Tulip")){
                              gameView.getTiles()[i].setIcon(gameView.smallTulip);
                            }
                            else if(seedSelect.getName().equals("Sunflower")){
                              gameView.getTiles()[i].setIcon(gameView.smallSunflower);
                            }
                            else if(seedSelect.getName().equals("Mango")){
                              gameView.getTiles()[i].setIcon(gameView.smallMango);
                            }
                            else if(seedSelect.getName().equals("Apple")){
                              gameView.getTiles()[i].setIcon(gameView.smallApple);
                            }
                    	  } else if (!gameModel.getLot()[i].isPlowed()) {
                      	    update.setText("You haven't plowed Tile No. " + (i + 1));
                    	  } else if(gameModel.getLot()[i].getCrop() != null) {
                    		  update.setText("There's a crop on Tile No. " + (i + 1));
                    	  } 
                	  } else if(!checkTrees(gameModel.getLot(), i, crop)) {
                		  update.setText("You can't plant Trees on Tile No. " + (i + 1));
                	  }
                	  else {
                		  update.setText("You don't have enough coins to plant " + seedSelect.getName());
                	  }
                	  gameView.setTextUpdate(update);
                  }
                  updatePlayer(gameModel.getPlayer());
            	}
            }
    
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
              // TODO Auto-generated method stub
              if(SwingUtilities.isRightMouseButton(e)){
                JPopupMenu popup = new JPopupMenu();
                int i = gameView.rightClickIndex((JButton) e.getSource());
                //setLot(gameModel.getLot());
                if(gameModel.getLot()[i].getCrop() != null && !gameModel.getLot()[i].isHasWithered()) {
                	popup.add(new JLabel("Crop Name: " + gameModel.getLot()[i].getCrop().getName()));
                    popup.add(new JLabel("Times Watered: " + gameModel.getLot()[i].getCrop().getWater()));
                    popup.add(new JLabel("Needed Water: " + gameModel.getLot()[i].getCrop().getWaterMin()));
                    popup.add(new JLabel("Times Fertilized: " + gameModel.getLot()[i].getCrop().getFertilizer()));
                    popup.add(new JLabel("Needed Fertilizer: " + gameModel.getLot()[i].getCrop().getFertilizerMin()));
                    popup.add(new JLabel("Days until harvest: " + (gameModel.getLot()[i].getCrop().getHarvestTime() - gameModel.getLot()[i].getCrop().getAge())));
                    gameView.setPopupMenu(popup, gameView.rightClickIndex((JButton) e.getSource()), e.getX(), e.getY());
                } else if(gameModel.getLot()[i].isHasWithered()) {
                	popup.add(new JLabel("This tile has withered!"));
                    gameView.setPopupMenu(popup, gameView.rightClickIndex((JButton) e.getSource()), e.getX(), e.getY());
                }
              }
            }
    
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
              // TODO Auto-generated method stub
              
            }
    
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
              // TODO Auto-generated method stub
              
            }
    
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
              // TODO Auto-generated method stub
              
            }
          });
      }


      for (int i = 0; i < gameView.getTools().length; i++) {
        gameView.addActionListeneronTools(i, new MouseListener()
        {
  
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
        	  JLabel update = new JLabel();
        	  select = 1;
        	  int i = gameView.leftClickIndexTools((JButton) e.getSource());
        	  toolSelect = gameModel.getToolList()[i];
        	  update = gameView.getTextUpdate();
        	  update.setText("You selected " + toolSelect.getType());
        	  gameView.setTextUpdate(update);
            
          }
  
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            if(SwingUtilities.isRightMouseButton(e)){
              JPopupMenu popup = new JPopupMenu();
              
              // popup.add(new JLabel("Plowed: "  ));
              // popup.add(new JLabel("Times Watered: "));
              // popup.add(new JLabel("Times Fertilized: "));
              // popup.add(new JLabel("Days until harvest: " ));
              gameView.setPopupMenuTools(popup, gameView.rightClickIndexTools((JButton) e.getSource()), e.getX(), e.getY());
            }
          }
  
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
          }
  
          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
          }
  
          @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
          }
          });
        }



    for (int i = 0; i < gameView.getPlants().length; i++) {
      gameView.addActionListeneronPlants(i, new MouseListener()
      {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          JLabel update = new JLabel();
          select = 2;
      	  int i = gameView.leftClickIndexPlants((JButton) e.getSource());
      	  seedSelect = gameModel.getSeedList()[i];
      	  update = gameView.getTextUpdate();
      	  update.setText("You selected " + seedSelect.getName());
      	  gameView.setTextUpdate(update);
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          if(SwingUtilities.isRightMouseButton(e)){
            JPopupMenu popup = new JPopupMenu();
            
            // popup.add(new JLabel("Plowed: "  ));
            // popup.add(new JLabel("Times Watered: "));
            // popup.add(new JLabel("Times Fertilized: "));
            // popup.add(new JLabel("Days until harvest: " ));
            gameView.setPopupMenuPlants(popup, gameView.rightClickIndexPlants((JButton) e.getSource()), e.getX(), e.getY());
          }
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          
        }
      });
    }

    for (int i = 0; i < gameView.getPlants().length; i++) {
      gameView.addActionListeneronPlants(i, new MouseListener()
      {
    
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel update = new JLabel();
        select = 2;
          int i = gameView.leftClickIndexPlants((JButton) e.getSource());
          seedSelect = gameModel.getSeedList()[i];
          update = gameView.getTextUpdate();
          update.setText("You selected " + seedSelect.getName());
          gameView.setTextUpdate(update);
        }
    
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        if(SwingUtilities.isRightMouseButton(e)){
          JPopupMenu popup = new JPopupMenu();
          
          // gameModel.getSeedList()[i].show(gameView.seeds, e.getX(), e.getY());
          gameView.setPopupMenuPlants(popup, gameView.rightClickIndexPlants((JButton) e.getSource()), e.getX(), e.getY());
          
        }
        }
    
        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
        }
    
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
        }
    
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
        }
      });
    }


      gameView.addActionListenerAdvanceDay(new MouseListener()
      {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
        	if(SwingUtilities.isLeftMouseButton(e)){
            if(!gameModel.checkGameOver()){
              select = 3;
            	var player = gameModel.getPlayer();
            	player.setDayCount(player.getDayCount() + 1);
            	
            	for(int i = 0; i < 50; i++) {
            		if(gameModel.getLot()[i].getCrop() != null) {
            			var crop = gameModel.getLot()[i].getCrop();
            			crop.setAge(crop.getAge() + 1);
            			checkLots(gameModel.getLot()[i], i);
            		}
            	}
            	updatePlayer(gameModel.getPlayer());
            	JLabel update = new JLabel();
            	update = gameView.getTextUpdate();
            	update.setText("You clicked Next Day!");}
            else {
              JLabel update = new JLabel();
              update = gameView.getTextUpdate();
              update.setText("GAME OVER");
              gameView.gameOverView();
              gameView.getMainFrame().dispose();
                    
            }
        	}
        }

          @Override
          public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
          }

          @Override
          public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
          }

          @Override
          public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
          }

          @Override
          public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
          }
            });

  }  
	@Override
	public void actionPerformed(ActionEvent e) {
		
        //Opens another JFrame containing information about the farmer
		if(e.getSource() == gameView.getFarmerInfo()){
			gameView.registerRequirements();
			gameView.setActionListenerForRegister(this);
		}
        //Opens another JFrame when the register button is clicked
		if(e.getSource() == gameView.getRegister()){
			gameView.upgradeList();
			gameView.setActionListenerForUpgrade(this);
		}
		
		if(e.getSource() == gameView.getPurchase()){
			var upgrade = gameModel.promoteFarmer(selectFarmer, latestFarmer);
			JLabel update = new JLabel();
			update = gameView.getTextUpdate();
			if(upgrade == true) {
	      	  	update.setText("You upgraded to " + gameModel.getPlayer().getFarmerType().getName());
	      	  	latestFarmer = selectFarmer;
				updatePlayer(gameModel.getPlayer());
				gameModel.applyPromotion();
			} else if (selectFarmer <= latestFarmer && selectFarmer > 0) {
				update.setText("You can't promote as " + farmerSelect.getName() + " anymore!");
			} else if(gameModel.getPlayer().getCoins() < farmerSelect.getRegistrationFee()) {
				update.setText("You don't have enough money to promote!");
			} else if(gameModel.getPlayer().getLevel() < farmerSelect.getLevel()) {
				update.setText("You don't have enough level to promote!");
			} else {
				update.setText("You have not selected any promotion!");
			} 
			gameView.setTextUpdate(update);
			gameView.getFarmerWindow().dispose();
			gameView.getRegWindow().dispose();
			selectFarmer = 0;
		}
		
		if(gameView.getFarmers() != null) {
			if(e.getSource() == gameView.getFarmers()[0]) {
				JLabel update = new JLabel();
	      	  	farmerSelect = gameModel.getFarmerType()[1];
	      	  	selectFarmer = 1;
	      	  	update = gameView.getTextUpdate();
	      	  	update.setText("You selected " + farmerSelect.getName());
	      	  	gameView.setTextUpdate(update);  
			}
			
			if(e.getSource() == gameView.getFarmers()[1]) {
				JLabel update = new JLabel();
	      	  	farmerSelect = gameModel.getFarmerType()[2];
	      	    selectFarmer = 2;
	      	  	update = gameView.getTextUpdate();
	      	  	update.setText("You selected " + farmerSelect.getName());
	      	  	gameView.setTextUpdate(update);  
			}
			
			if(e.getSource() == gameView.getFarmers()[2]) {
				JLabel update = new JLabel();
	      	  	farmerSelect = gameModel.getFarmerType()[3];
	      	    selectFarmer = 3;
	      	  	update = gameView.getTextUpdate();
	      	  	update.setText("You selected " + farmerSelect.getName());
	      	  	gameView.setTextUpdate(update);  
			}
		}
	}
}