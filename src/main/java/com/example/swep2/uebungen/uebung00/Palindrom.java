package com.example.swep2.uebungen.uebung00;

import com.example.swep2.InputTools;

public class Palindrom {
    public static void main(String[] args) {
        String input = InputTools.readString("Ist es ein Palindrom? ");
        char [] stringCharArray = input.toCharArray();
        String reversedInput = "";

        for (int i = stringCharArray.length -1; i >=0; i--){
            reversedInput += stringCharArray[i];
        }

        System.out.println(reversedInput);

        if(input.equalsIgnoreCase(reversedInput)){
            System.out.println("Es handelt sich um ein Palindrom! " + reversedInput);
        }else {
            System.out.println("Es handelt sich nicht um ein Palindrom!");
        }
    }
}
