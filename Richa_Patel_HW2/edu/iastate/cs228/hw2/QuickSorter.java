package edu.iastate.cs228.hw2;

import java.util.Comparator;
import java.util.Random;

/**
 * An implementation of {@link Sorter} that performs quick sort to sort the
 * list.
 * 
 * @author Richa Patel
 */
public class QuickSorter extends Sorter {
	@Override
	public void sort(WordList toSort, Comparator<String> comp) throws NullPointerException {
		// TODO
		quickSortRec(toSort, comp, 0, toSort.length() - 1);
		/*
		 
		for (int i = 0; i < toSort.length() - 1; ++i) {
			int minIndex = i;
			for (int j = i + 1; j < toSort.length(); ++j) {
				if (comp.compare(toSort.get(j), toSort.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			toSort.swap(i, minIndex);
		}
		*/
	}
	// this one is quicksort

	// set(index, i, temp)

	// a sort is sort is stable if equals elements main their order
	private void quickSortRec(WordList list, Comparator<String> comp, int start, int end) {
		// TODO
		// find the pivot rightmost value
		// partition the array
		// recursively sort the left side of the pivot
		
		//recursively sort the right side of the pivot
		//this one is quick sort with recursion

		if (start >= end) {
			return;
		}
		int partition = partition(list, comp, start, end);
		quickSortRec(list, comp, start, partition-1);
		quickSortRec(list, comp, partition + 1, end);

	}

	private int partition(WordList list, Comparator<String> comp, int start, int end) {
		// TODO
		String pivot = list.get(end);
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (comp.compare(list.get(j), pivot) < 1) { // points[j] <= pivot
				i++;
				list.swap(i, j); 
				//swaps point i and j
			}
		}
		list.swap(i + 1, end); 
		// swap [i+1] and end
		return i + 1;
	}

}
