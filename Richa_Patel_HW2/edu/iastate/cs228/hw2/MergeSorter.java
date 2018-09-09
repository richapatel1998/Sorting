package edu.iastate.cs228.hw2;

import java.util.Comparator;
import java.util.Random;

/**
 * An implementation of {@link Sorter} that performs merge sort to sort the
 * list.
 * 
 * @author Richa Patel
 */
public class MergeSorter extends Sorter {
	@Override
	public void sort(WordList toSort, Comparator<String> comp) throws NullPointerException {

		mergeSortRec(toSort, comp, 0, toSort.length() - 1);
	}
/*
	private void mergeSortRec(WordList list, Comparator<String> comp, WordList start, WordList end) {
		int s = start.length();
		int e = end.length();
		if(start < end) {
			int m = (start+end)/2;
			mergeSortRec(list, comp, start, m);
			mergeSortRec(list, comp, m+1, end);
			merge(list, comp, start, m, end);
		}
	}
*/

	private void mergeSortRec(WordList list, Comparator<String> comp, int start, int end) {

		if(start < end) {
			int m = (start+end)/2;
			mergeSortRec(list, comp, start, m);
			mergeSortRec(list, comp, m+1, end);
			merge(list, comp, start, m, end);
		}
			//merge(comp,list.getArray(), start, m, end);
		}
	
		/*
		if (start >= end) {
			return;
		}

		int middle = (start + end) / 2;

		mergeSortRec(list, comp, start, middle);

		mergeSortRec(list, comp, middle + 1, end);

		merge(list, comp, start, middle, end);

		// TODO

	}
*/
	private void merge(WordList list, Comparator<String> comp, int start, int middle, int end) {

		
		int n1, n2;
		n1 = middle - start + 1;
		n2 = end - middle;

		
		String left[] = new String[n1];
		String right[] = new String[n2];

		String orgList[] = list.getArray();
		int i, j;
		for (i = 0; i < n1; i++) {
			left[i] = orgList[i + start];
		}
		for (i = 0; i < n2; i++) {
			String temp = orgList[1 + middle + i];
			right[i] = temp;

		}

		i = 0;
		j = 0;

		// Initial index of merged subarry array
		int k = start;
		while (i < n1 && j < n2) {
			if (comp.compare(left[i], right[j]) <= 0)
			// if (L[i] <= R[j])
			{
				list.set(k, left[i]);
				// arr[k] = L[i];
				i++;
			} else {
				list.set(k, right[j]);
				// arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any 
		while (i < n1) {
			list.set(k, left[i]);
			// arr[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any 
		while (j < n2) {
			list.set(k, right[j]);
			// arr[k] = R[j];
			j++;
			k++;
		}
	

	}
}
