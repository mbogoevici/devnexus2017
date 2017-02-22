package ca.mbg.demo.devoxx2016;

/**
 * @author Marius Bogoevici
 */
public class Accumulator {

	private int count;

	private double totalValue;

	public Accumulator(int count, double totalValue) {
		this.count = count;
		this.totalValue = totalValue;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return "Accumulator{" +
					   "count=" + count +
					   ", totalValue=" + totalValue +
					   '}';
	}
}
