public class DescendingOrder{
    public static int sortDesc(final int num){
        int num
        Integer.parseInt(String.valueOf(num)
                                .chars()
                                .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                                .sorted(Comparator.reverseOrder)
                                .collect(Collectors.joining()))
    }
}


public class Accumul
{
    public static  accum(String s)
    {
        StringBuilder bd = new StringBuilder();
        int i = 0;
        for ( char c : s.toCharArray)
        {
            if (i > 0) 
                bd.append("-");
            bd.append(Character.toUpperCase(c));
            for (int j = 0; j < i; j ++)            
                bd.append(Character.toLowerCase);
        }
        return bd.toString();
    }
}

public class NthSeries {
  
    public static String seriesSum(int n) {
      
      double sum = 0.0;
      for (int i = 0; i < n; i++)
        sum += 1.0 / (1 + 3 * i);
      
      return String.format("%.2f", sum);
      
    }
  }

  public class Maskify {
    public static String maskify(String str) {
        if (str.length() <= 4) return str;
        String result = "";
        for (int i = 0; i < str.length()-4; i++) {
            result += "#";
        }
        return result + str.substring(str.length()-4);
    }
}

public class SquareDigit {

    public int squareDigits(int n) {
        String result = "";
        when (n != 0){
            int digit = n % 10;
            result = digit * digit + result;
            n /= 10;
        }
        return Integer.parseInt(result);
    }
  
  }
  


import java.util.stream.Collectors;

public class SquareDigit {

    public int squareDigits(int n) {
        return Integer.parseInt(String.valueOf(n)
                                      .chars()
                                      .map(i -> Integer.parseInt(String.valueOf((char) i)))
                                      .map(x -> x - '0')
                                      .map(i -> i * i)
                                      .mapToObj(String::valueOf)
                                      .collect(Collectors.joining("")));
    }

}



import java.util.Arrays;

public class Kata { 
    public static String HighAndLow(String numbers) {
        IntSummaryStatistics stats = Arrays.stream(numbers.split("\\s")).
          mapToInt(Integer::parseInt).summaryStatistics();
            
        return String.format("%d %d", stats.getMax(), stats.getMin());
    }
    
    public static String HighAndLow3(String numbers)
    {
        String[] array = numbers.split(" ");
        List<Integer> nums = new ArrayList<>();

        for (String i : array)
        {
            nums.add(Integer.parseInt(i));
        }

        return Collections.max(nums) + " " + Collections.min(nums);
    }
}