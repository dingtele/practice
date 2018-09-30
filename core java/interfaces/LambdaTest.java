package lambda;

import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class LambdaTest
{
    public static void main(String[] args)
    {
        String[] planets = new String[]{ "Mercury", "Venus", "Earth",
                "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
        System.out.println(Arrays.toString(planets);
        System.out.println("Sorted in dictionary order:");
        Array.sort(planets);
        System.out.println(Array.toString(planets));
        System.out.println("Sorted by length:");
        Array.sort(planets,(first,second) -> first.length() -
                second.length());
        System.out.println(Array.toString(planets));

        Timer t = new Timer(1000, event ->
                System.out.println("the time is" + new Date()));
        t.start();

        JOptionPane.showMessagedialog(null, "quit program?");
        System.exit(0);

    }
}
