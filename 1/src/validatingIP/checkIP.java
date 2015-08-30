package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        System.out.println(ss("(65/0 5/X55-1234"));
    }
    
    public static String ss(String pn){
        HashSet<Character> valid = new HashSet<Character>();
        valid.add('.');
        valid.add('(');
        valid.add(')');
        valid.add('-');
        valid.add('/');
        valid.add('\\');
        valid.add(' ');
        HashSet<Character> number = new HashSet<Character>();
        for(int i = 0; i < 10; i++){
            number.add(String.valueOf(i).charAt(0));
        }
        
        char[] result = new char[12];
        int index = 0;
        for(char c: pn.toCharArray()){
            if(!valid.contains(c) && !number.contains(c))
                return "invalid";
            if(index > 11){
                if(valid.contains(c))
                    continue;
                else return "invalid";
            }
            if(index == 3 || index == 7){
                result[index++] = '-';
                continue;
            }
            if(valid.contains(c))
                continue;
            if(number.contains(c)){
                System.out.println(index + ":" + c);
                result[index++] = c;
            }
        }
        if(index < 11)
            return "invalid";
        String s = "";
        for(int i = 0; i < result.length; i++){
            s += result[i];
        }
        return s;
    } 
}

















im
