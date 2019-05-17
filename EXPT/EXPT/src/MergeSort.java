
public class MergeSort {
	public static Comparable[] aux;
	
	public static void sort(Comparable[] a)
	{
		for (int k = 0; k < a.length-1; k++)
			aux = new Comparable[a.length-1];
		sort(a, 0, a.length-1);
		
	}
	
	public static void sortBU(Comparable[] a)
	{
		aux = new Comparable[a.length];
		for (int sz = 1; sz < a.length; sz = sz+sz)
		{
			for (int lo = 0; lo < a.length; lo = lo + sz)
			{
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz+1, a.length-1));
			}
		}
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		if (lo > hi) return;
		int mid = (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	// Top-down
	// abstract in-place merge
	public static Comparable[] merge(Comparable[] a, int lo, int mid, int hi)
	{
		int i = lo;
		int j = mid+1;

		for (int k = lo; k < hi; k++)
		{
			aux[k] = a[k];
		}
		
		for (int k = 0; k < a.length-1; k++)
		{
			if (i > mid) 					a[k] = aux[j++];
			else if (j > hi)				a[k] = aux[i++];
			else if (less(aux[j], aux[i])) 	a[k] = aux[j++]; 
			else							a[k] = aux[i++];
		}
		return a;
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		return (v.compareTo(w) < 0);
	}
}
