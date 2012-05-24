package se.chalmers.kangaroo.utils;

import java.awt.event.KeyEvent;

/**
 * 
 * @author pavlov
 *
 */
public class KeyList {
	public KeyList(){
		
	}
	/**
	 * @pre check if e.getKeyCode() <= 48 && e.getKeyCode() >= 90, return number/letter
	 * @param keyId
	 * @return
	 */
	public String getKeyName(KeyEvent keyEvent){
		int keyId = keyEvent.getKeyCode();
		if(keyId >= 48 && keyId <= 90){
			return Character.toString(keyEvent.getKeyChar());
		}
		//If numpad
		if(keyId >= 96 && keyId <= 105){
			return "Numpad " + (keyId-96);
		}
		
		//If F1-15
		if(keyId >= 112 && keyId <= 126){
			return "F" + (keyId-111);
		}
		
		//If rest
		switch(keyId){
		case 106:
			return "Numpad *";
		case 107:
			return "Numpad +";
		case 109:
			return "Numpad -";
		case 110:
			return "Numpad ,";
		case 111:
			return "Numpad /";
		case 8:
			return "Backspace";
		case 9:
			return "Tab";
		case 13:
			return "Enter";
		case 16:
			return "Shift";
		case 17:
			return "Ctrl";
		case 20:
			return "Caps Lock";
		case 32:
			return "Spacebar";
		case 33:
			return "Page up";
		case 34:
			return "Page Down";
		case 35:
			return "End";
		case 36:
			return "Home";
		case 37:
			return "Left Arrow";
		case 38:
			return "Up Arrow";
		case 39:
			return "Right Arrow";
		case 40:
			return "Down Arrow";
		case 45:
			return "Insert";
		case 46:
			return "Delete";
		case 144:
			return "Num Lock";
		case 145:
			return "Scroll Lock";
		case 19:
			return "Pause or Break";
		//TODO Check if those are necessary
//		case 186:
//			return "; or :";
//		case 187:
//			return "= or +";
//		case 189:
//			return "- or _";
//		case 191:
//			return "/ or ?";
//		case 192:
//			return "` or ~";
//		case 219:
//			return "[ or {";
//		case 220:
//			return "\\ or |";
//		case 221:
//			return "] or }";
//		case 222:
//			return '" or ' + "'";
//		case 188:
//			return ",";
//		case 190:
//			return ".";
//		case 191:
//			return "/";
		default:
			return "Error, can't find key";
			
		}
	}

}
