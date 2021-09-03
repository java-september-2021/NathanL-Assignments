import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class PuzzleJava {
    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> myArr = new ArrayList<Integer>();
        for(int i =0; i <10;i++){
            myArr.add(randMachine.nextInt(20));
        }
        return myArr;



    }

    public char getRandomLetter(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int ind =randMachine.nextInt(25);
        char result = alphabet[ind];
        return result;
    }

    public char [] generatePassword(){
        char[] myArr =  new char[8];
        for(int i =0;i<8;i++){
            myArr[i] = getRandomLetter();
        }

        return myArr;
    }

    public ArrayList<String> getNewPasswordSet(int num){
        ArrayList<String> myArr = new ArrayList<String>();
        for(int i =0; i <num;i++){
            char[] chararr = generatePassword();
            String str = String.valueOf(chararr);
            myArr.add(str);
        }
        return myArr;
    }
}
