package se.chalmers.kangaroo.model.creatures;

import se.chalmers.kangaroo.model.utils.Position;

/**
 * A factory for creating creatures. 
 * @author grubla
 *
 */
public class CreatureFactory {
	/**
	 * Creates different creatures depending on the ID.
	 * 
	 * @param i
	 *            , the id of the creature
	 * @param p, the spawn position of the creature
	 * @return the creature created
	 */
	public static Creature createCreature(int i, Position p) {
		switch (i) {
		case 111:
			return new CrabCreature(p);
		case 112:
			return new TurtleCreature(p);
		case 113:
			return new BlackAndWhiteCreature(p);
		case 114:
			return new BullCreature(p);
		case 115:
			return new SumoCreature(p);
		case 116:
			return new SmurfCreature(p);
		default:
			return null;
		}
	}
}
