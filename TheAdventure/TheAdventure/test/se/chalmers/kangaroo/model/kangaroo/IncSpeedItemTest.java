package se.chalmers.kangaroo.model.kangaroo;

import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.kangaroo.model.utils.Position;

public class IncSpeedItemTest {

	@Test
	public void testOnUse() {
		IncSpeedItem isi = new IncSpeedItem(37, 2, 2);
		Kangaroo k = new Kangaroo(new Position(2, 2));
		isi.onUse(k);
		float f = 0.0f;
		for (int i = 0; i < 3000; i++) {
			f = f + 0.1f;
			k.setVerticalSpeed(f);
		}
		System.out.println(k.getVerticalSpeed());
		assertTrue(k.getVerticalSpeed() > 14.0f);

	}
}
