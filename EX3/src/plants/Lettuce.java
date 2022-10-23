package plants;

import graphics.ZooFrame;
import graphics.ZooPanel;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {
	public Lettuce(ZooFrame f) {
		super(f);
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}
}
