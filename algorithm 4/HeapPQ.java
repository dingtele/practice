public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N= 0;

    public MaxPQ(int maxN)
    {  pq= (Key[]) new Comparable[maxN+1]; }

    public boolean isEmpty()
    {  return N==0; }

    public int size()
    {  return N;  }

    public void insert(Key v)
    {
        pq[++N]= v;
        swim(N);
    }

    public Key delMax()
    {
        Key max= pq[1];
        exch(1, N--);
        pq[N+1]= null;
        sink(1);
        return max;
    }
}





public class TopM
{
    public static void main(String[] args)
    {
        int M= Integer.parseInt(args[0]);
        MaxPQ<Transaction> pq= new MaxPQ<Transaction>(M+1);
        while(StdIn.hasNextline())
        {
            pq.insert(new Transaction(StdIn.realdLine()));
            if (pq.size()>M)
                pq.delMax();
        }
        
        Stack<Transaction> stack= new Stack<Transaction>();
        while(!pq.isEmpty()) stack.push(pq.delMax());
        for(Transaction t: stack) StdOut.println(t);
    }
}
