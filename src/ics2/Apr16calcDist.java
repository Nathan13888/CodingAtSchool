package ics2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * April 16th Stuff for Thursday 16 April -- A FUNCTION YOU COULD CODE -- Call
 * the function calcDist. It will take four input parameters -- the x and y
 * coordinate values of point 1, and the x and y coordinate values of point 2.
 * The function is to calculate and return to the caller the distance between
 * the two points (as you've learned how to calculate in Gd 10 math).
 */
public class Apr16calcDist {

	static class Case {
		public Case(Double d, Double e, Double f, Double g) {
			this.x1 = d;
			this.x2 = e;
			this.y1 = f;
			this.y2 = g;
		}

		public Double x1, x2, y1, y2;

		@Override
		public String toString() {
			return this.x1 + " " + this.y1 + " " + this.x2 + " " + this.y2;
		}
	}

	public static void main(String[] args) throws Exception {
		Apr16calcDist inst = new Apr16calcDist();

		// Test Cases
		Case[] cases = { new Case(0.0, 0.0, 0.0, 4.0), new Case(0.0, 0.0, 0.0, 4.0), new Case(0.0, 1.0, 1.0, 0.0) };
		int i = 1;
		for (Case c : cases) {
			System.out.println("[" + i + "] " + c.toString());
			BigDecimal res = inst.calcDist(c.x1, c.x2, c.y1, c.y2);
			// res.toPlainString() prints the whole BigDecimal number
			System.out.println(round(res, 5));
			i++;
		}
		inst.testPrompt();
	}

	public void testPrompt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Instructions\nEnter \"exit\" to end testPrompt()");

		System.out.println("To input a test case, write four space-separated numbers in this order --> x1, y1, x2, y2");

		String prefix = ">>  ";

		String line = null;
		while (true) {
			System.out.print(prefix);
			line = br.readLine().trim();
			if (line.equals("exit"))
				break;
			String[] args = line.split(" ");
			if (!line.contains("123456789 ") && args.length == 4) {

			} else
				System.out.println("Bad Input");
		}

		System.out.println("Exited testPrompt()");

		br.close();

	}

	private static double round(BigDecimal d, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		d = d.setScale(places, RoundingMode.HALF_UP);
		return d.doubleValue();
	}

	// BigDecimal is 32 Bytes large by default, Double is 8 bytes
	private BigDecimal calcDist(Double x1, Double y1, Double x2, Double y2) {
		// Can't use Math.pow(a, b) because of overflow of edge cases
		// BigDecimal has an ABS function but isn't needed
		BigDecimal xD = BigDecimal.valueOf(Math.abs(x1 - x2));
		xD = xD.multiply(xD);
		BigDecimal yD = BigDecimal.valueOf(Math.abs(y1 - y2));
		yD = yD.multiply(yD);

		BigDecimal d = xD.add(yD);
		d = d.sqrt(MathContext.DECIMAL128);

		return d;
	}
}
