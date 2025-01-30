package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Wood extends Entity{
	
	public static final String objName = "Wooden Shield";

	public OBJ_Shield_Wood(GamePanel gp) {
		super(gp);

		type = type_shield;
		name = objName;
		down1 = setup("/objects/shield_wood", gp.tileSize, gp.tileSize);
		defenseValue = 2;
		description = "[" + name + "]\nA wooden shield.";
		price = 35;
	}

}
