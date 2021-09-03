public class FizzBuzz {
    public String fizzBuzz(int number) {
        String result;
        String str1;
            if ( number%5 == 0 && number%3 ==0){
                result = "FizzBuzz";
            }else if (number%5 == 0){
                result = "Buzz";
            }else if (number%3 ==0){
                result = "Fizz";
            } else{
                result =  Integer.toString(number);
            }
            str1 = String.format("The result is %s",result);
        return str1;
    }

    public String fizzBuzz(int number,String multOf3Word, String multOf5Word,String multOf15Word) {
        String result;
        String str1;
            if ( number%5 == 0 && number%3 ==0){
                result = multOf15Word;
            }else if (number%5 == 0){
                result = multOf5Word;
            }else if (number%3 ==0){
                result = multOf3Word;
            } else{
                result =  Integer.toString(number);
            }
            str1 = String.format("The result is %s",result);
        return str1;
    }

}
