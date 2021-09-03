import java.util.Arrays;
public class BasicJavaTest {

    public static void main(String[] args) {
        BasicJava tester = new BasicJava();
        //tester.twofivefive();
        //tester.oddtwofivefive();
        //System.out.println(tester.sumtwofivefive());
        //tester.iterate();
        //tester.max();
        //System.out.println(tester.oddarr());
        int[] myArray = {4, 8, 9};
        //tester.getavg(myArray);
        //tester.greaterthan(5,myArray);
        System.out.println(Arrays.toString((tester.square(myArray))));
    }
}
