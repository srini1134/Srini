package com.srinivas.mytest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Srinivas
 *
 */
public class ZipRange {

	// create an arrayList of range type
	private static ArrayList<Range> ZipRangeList = new ArrayList<Range>();

	public static void main(String[] args) {

		Range a = new Range(94133, 94133);
		Range b = new Range(94200, 94299);
		Range c = new Range(94600, 94699);
		Range d = new Range(94200, 94299);
		Range e = new Range(94600, 94699);
		
		// Add ranges
		ZipRange.AddRange(a);
		ZipRange.AddRange(b);
		ZipRange.AddRange(c);
		ZipRange.AddRange(d);
		ZipRange.AddRange(e);

		showRange();

	}

	public static void AddRange(Range toAdd) {
		if (ZipRangeList.size() == 0)
			ZipRangeList.add(toAdd);
		else {
			// Add new Range, if the range overlaps with existing range, merge
			// them
			ListIterator<Range> iter = ZipRangeList.listIterator();

			boolean isAdd = true; 
			
			while (iter.hasNext()) {
				Range range = iter.next();

				// new range within existing range, no need to add
				if (range.getLower() <= toAdd.getLower() && range.getUpper() >= toAdd.getUpper()) {
					isAdd = false;
				}

				// new range is out of existing range, add it
				else if (range.getLower() > toAdd.getUpper() || range.getUpper() < toAdd.getLower()) {
					isAdd = true;
				}

				// Range overlaps, remove existing, update toAdd
				else {
					if (range.getLower() < toAdd.getLower())
						toAdd.setLower(range.getLower());
					if (range.getUpper() > toAdd.getUpper())
						toAdd.setUpper(range.getUpper());
					iter.remove();
					isAdd = true;
				}
			}
			if (isAdd)
				ZipRangeList.add(toAdd);
		}

	}

	public static void showRange() {
		if (ZipRangeList.size() > 0) {
			for (Range range : ZipRangeList) {
				System.out.println(range.toString());
			}
		}

	}

	public static int size() {
		return ZipRangeList.size();
	}

	public static List<Range> getZipRanges() {
		return ZipRangeList;
	}

	public static void clear() {
		ZipRangeList.clear();
	}

}
