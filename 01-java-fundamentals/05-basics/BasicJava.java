import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
    public void twofivefive(){
        for(int i = 0; i <256;i++){
            System.out.println(i);
        }
    }

    public void oddtwofivefive(){
        for(int i = 0; i <256;i++){
            if (i%2!=0){
                System.out.println(i);
            }
        }
    }

    public int sumtwofivefive(){
        Integer total = 0;
        for(int i = 0; i <256;i++){
            total += i;
        }
        return total;
    }

    public void iterate(){
        int[] myarr = {1,3,5,7,9,13};
        for(int i : myarr){
            System.out.println(i);
        }
    }

    public void max(){
        int[] myarr = {1,-3,52,7,-9,-13};
        int max = myarr[0];
        for(int i = 0; i < myarr.length; i++)
            if ( myarr[i] > max){
                max = myarr[i];
            }
            System.out.println(max);
        }
    public ArrayList<Integer> oddarr(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i = 0; i <256;i++){
            if (i%2!=0){
                y.add(i);
            }
        }
    return y;
    }

    public void getavg(int [] array){
        float avg = 0;
        for(int i = 0; i < array.length; i++){
            avg += array[i];
            }
        float divisor = array.length;
        float average = avg/divisor;
        System.out.println(average);
    }

    public void greaterthan(int val, int [] array){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > val){
                count +=1;
            }
        }
        System.out.println(count);
    }

    public int [] square(int [] array){
        for(int i = 0; i < array.length; i++){
            int tmp = array[i] *2;
            array[i] = tmp;
            }
        return array;
        }
}

