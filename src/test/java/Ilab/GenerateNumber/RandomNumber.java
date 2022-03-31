package Ilab.GenerateNumber;

import java.util.Random;

public class RandomNumber {
    public  String RandomGenerator(){
        Random generator = new Random();
        int num1, num2, num3; //first three numbers
        int set2, set3;
        int[] rand= {1,2,3,4,6};
        int index = generator.nextInt(rand.length);
        num1 = 0;
        num2 = generator.nextInt(3) + 6;
        num3 = rand[index];
        set2 = generator.nextInt(643) + 100;
        set3 = generator.nextInt(8999) + 1000;
        String PhoneNumbers = ( "(" + num1 + "" + num2 + "" + num3 + ")" + "-" + set2 + "-" + set3 );
        return PhoneNumbers;
    }



    }


