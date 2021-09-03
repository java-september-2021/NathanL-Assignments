public class PuzzleJavaTest {

    public static void main(String[] args) {
        PuzzleJava tester = new PuzzleJava();
        System.out.println(tester.getTenRolls());
        System.out.println(tester.getRandomLetter());
        System.out.println(tester.generatePassword());
        System.out.println(tester.getNewPasswordSet(7));
    }
}
