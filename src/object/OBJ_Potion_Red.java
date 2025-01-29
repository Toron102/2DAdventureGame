package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion_Red extends Entity{

	GamePanel gp;
	
	public OBJ_Potion_Red(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		value = 5;
		name = "Red Potion";
		down1 = setup("/objects/potion_red", gp.tileSize, gp.tileSize);
		description = "[" + name + "]\n" + "Heals you by up to" + value +" HP.";
		price = 25;
		stackable = true;
		
		setDialogue();
	}
	
	public void setDialogue() {
		
		dialogues[0][0] = "You drink the " + name + "!\n"
				+ "Your life has been recovered by " + value + ".";
		
		dialogues[1][0] = "You drink the " + name + "!\n"
				+ "Your life has been recovered by " + (gp.player.maxLife-gp.player.life) + ".";
	}
	
	public boolean use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		
		int playerMissingHealth = gp.player.maxLife-gp.player.life;
		
		if(playerMissingHealth > value) {
			startDialogue(this, 0);
			gp.player.life += value;
		}
		else {
			startDialogue(this, 1);
			gp.player.life += value;
		}

		gp.playSE(2);
		
		return true;
	}

}
