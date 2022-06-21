package lab8_home;

import lab8_home.AltString;

public class AltString {
		private char[] string;

	    public AltString(char[] arr) {
	        this.string = arr;
	    }

	    public char[] getArray() {
	        return string;
	    }

	    public int length() {
	        return string.length;
	    }
}
