package linkedList;

import java.util.*;

public class LinkedListTest
{
    public static void main(String[] args)
    {
     List<String> a = new LinkedList<>();
     a.add("Amy");
     a.add("Carl");
     a.add("Erica");

     List<String> b = new LinkedList<>();
     a.add("Bob");
     a.add("Doug");
     a.add("Frances");
     a.add("Gloria");

     // merge the words from b into a

     ListIterator<String> aIter = a.listIterator();
     Iterator<String> bIter = b.iterator();

     while(bIter.hasNext())
     {
         if(aIter.hasNext()) aIter.next();
         aIter.add(bIter.next());
     }

     System.out.println(a);

     // remove every second word from b

     bIter = b.iterator();
     while (bIter.hasNext())
     {
         bIter.next();
         if (bIter.hasNext())
         {
             bIter.next();
             bIter.remove();
         }
     }

        System.out.println(b);

     //  bulk operation: remove all words in b from a

     a.removeAll(b);

     System.out.println(a);
    }

}
