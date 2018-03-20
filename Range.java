package com.srinivas.mytest;

/**
 * @author Srinivas
 *
 */
public class Range {
	
	private int lower;
	private int upper;
	
	// Constructor
	Range(int lower, int upper){
		if(lower <= upper) {
			this.lower = lower;
			this.upper = upper;
		} else {
			this.lower = upper;
			this.upper = upper;	
		}
	}

	/**
	 * @return the lower
	 */
	public int getLower() {
		return lower;
	}

	/**
	 * @param lower the lower to set
	 */
	public void setLower(int lower) {
		this.lower = lower;
	}

	/**
	 * @return the upper
	 */
	public int getUpper() {
		return upper;
	}

	/**
	 * @param upper the upper to set
	 */
	public void setUpper(int upper) {
		this.upper = upper;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("['%d','%d']", lower, upper);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
        if (obj instanceof Range) {
            Range that = (Range) obj;
            result = (this.getLower()==that.getLower() && this.getUpper() ==that.getLower() );
        }
        return result;
	}
}
