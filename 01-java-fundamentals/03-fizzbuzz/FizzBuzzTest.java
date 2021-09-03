public class FizzBuzzTest {

    public static void main(String[] args) {
        FizzBuzz tester = new FizzBuzz();

        System.out.println(tester.fizzBuzz(9));
        System.out.println(tester.fizzBuzz(10));
        System.out.println(tester.fizzBuzz(15));
        System.out.println(tester.fizzBuzz(16));
        System.out.println(tester.fizzBuzz(2));

        for (int i = 1; i <= 50; i++) {
            System.out.println(tester.fizzBuzz(i));
        }

        System.out.println(tester.fizzBuzz(9,"three","five","fifteen"));
    }
}

