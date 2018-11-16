import java.util.*;

public class BinarySearchLibrary {
	
	public static <T>
	    int firstIndexSlow(List<T> list, 
	    		           T target, Comparator<T> comp) {
		int index = Collections.binarySearch(list, target,comp);
		
		if (index < 0) return index;
		
		while (0 <= index && comp.compare(list.get(index),target) == 0) {
			index -= 1;
		}
		return index+1;
	}
	
	/**
	 * Uses binary search to find the index of the first object in parameter
	 * list -- the first object o such that comp.compare(o,target) == 0.
	 * 
	 * This method should not call comparator.compare() more than 1+log n times
	 * @param list is the list of objects being searched
	 * @param target is the object being searched for
	 * @param comp is how comparisons are made
	 * @return index i such that comp.compare(list.get(i),target) == 0
	 * and there is no index < i such that this is true. Return -1
	 * if there is no such object in list.
	 */
	
	public static <T>
    	int firstIndex(List<T> list, 
	               	T target, Comparator<T> comp) {
		
		if(list == null)
			return -1;
		
		int lo = -1;
		int hi = list.size() - 1;
		
		while(hi - lo > 1){
			
			int mid = (lo + hi)/2;
			
			if(comp.compare(target, list.get(mid)) <= 0){
				hi = mid;
			} 
			
			else {
				lo = mid;
			}
			
		}
		
		if(comp.compare(target, list.get(hi)) == 0)
			return hi;
		
		return -1;
	}

	/**
	 * Uses binary search to find the index of the last object in parameter
	 * list -- the first object o such that comp.compare(o,target) == 0.
	 * 
	 * This method should not call comparator.compare() more than 1+log n times
	 * @param list is the list of objects being searched
	 * @param target is the object being searched for
	 * @param comp is how comparisons are made
	 * @return index i such that comp.compare(list.get(i),target) == 0
	 * and there is no index > i such that this is true. Return -1
	 * if there is no such object in list.
	 */
	public static <T>
	int lastIndex(List<T> list, 
               	  T target, Comparator<T> comp) {
		
		if(list == null)
			return -1;
		
		int lo = 0;
		int hi = list.size();
		
		while(hi - lo > 1){
			
			int mid = (lo + hi)/2;
			
			if(comp.compare(target, list.get(mid)) < 0){
				hi = mid;
			} 
			
			else {
				lo = mid;
			}
		}
		if(comp.compare(target, list.get(lo)) == 0)
			return lo;
		
		return -1;
		
	}
	
}