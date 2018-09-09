package edu.iastate.cs228.hw2;

import java.util.Comparator;

/**
 * An implementation of {@link Sorter} that performs insertion sort to sort the
 * list.
 * 
 * @author Richa Patel
 */
public class InsertionSorter extends Sorter {
	@Override
	public void sort(WordList toSort, Comparator<String> comp) throws NullPointerException {
		// TODO
		
		//set the value to the new one you give it
		//get returns the value
		
		
		int n = toSort.length();
		for(int i = 1; i < n; i++) {
			String word = toSort.get(i);
			int j = i - 1;
			//while (j >= 0 && comp.compare(toSort.get(j), word)>0) {
			while (j >= 0 && comp.compare(toSort.get(j), word)>=0) {

				//if (comp.compare(toSort.get(j), toSort.get(minIndex)) < 0) {
				//while(comp.compare(toSort.get(j), word) >= 0)
				//toSort.set(j+1) = toSort.set(j);
				toSort.swap(j+1, j);
				j = j - 1;
				
			}
			toSort.set(j+1, word);
			
			
	     

	}
}



}


    
    
    
    
    