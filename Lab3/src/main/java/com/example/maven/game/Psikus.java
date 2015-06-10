package com.example.maven.game;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by Hunter on 2015-03-10.
 */
public class Psikus implements Ipsikus {

    @Override
    public Integer cyfrokrad(Integer liczba) {
        //Split of Integer to string
        String number = String.valueOf(liczba);
        List<Integer> digits = new ArrayList<Integer>();
        for(int i=0;i<number.length();i++){
            digits.add(number.charAt(i)-48);
        }
        if (digits.size() <=1 ){
            return null;
        }

        Random rand = new Random();
        int random = digits.get(rand.nextInt(digits.size()));
        digits.remove(random);

        int[] array = new int[digits.size()];
        for(int i=0;i < array.length ;i++){
            array[i] = digits.get(i);
        }
        int res=0;
        for(int i=0;i < array.length ;i++) {
            res = 10 * res + array[i];
        }
        return res;
    }

    @Override
    public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
        String number = String.valueOf(liczba);
        List<Integer> digits = new ArrayList<Integer>();
        for(int i=0;i<number.length();i++){
            digits.add(number.charAt(i)-48);
        }

        Random random = new Random();
        int randomize = random.nextInt(digits.size());
        int randomize2 = random.nextInt(digits.size());

        int pom, pom2;
        try {
            if (digits.size() <= 1) {
                throw new NieudanyPsikusException("Wrong Length (it should be above 1)");
            }
            //switch
            pom = digits.get(randomize);
            pom2 = digits.get(randomize2);
            digits.set(randomize,pom2);
            digits.set(randomize2,pom);

        } catch (NieudanyPsikusException e) {
            System.out.println(e.getMessage());
        }
        //adding array to new integer
        int[] array = new int[digits.size()];
        for(int j=0;j < array.length ;j++){
            array[j] = digits.get(j);
        }
        int res=0;
        for(int j=0;j < array.length ;j++) {
            res = 10 * res + array[j];
        }
        return res;

    }

    @Override
    public Integer nieksztaltek(Integer liczba) {
        //Split of Integer to string
        String number = String.valueOf(liczba);
        List<Integer> digits = new ArrayList<Integer>();
        for(int i=0;i<number.length();i++){
            digits.add(number.charAt(i)-48);
        }

        int i;
        List<Integer> three = new ArrayList<Integer>();
        List<Integer> six = new ArrayList<Integer>();
        List<Integer> seven = new ArrayList<Integer>();
        for (i = 0; i < digits.size(); i++) {
            if (digits.get(i) == 3) {
                three.add(i);
            }
            if (digits.get(i) == 6) {
                six.add(i);
            }
            if (digits.get(i) == 7) {
                seven.add(i);
            }
        }
        //if empty return argument
        if (three.size() == 0 && six.size() == 0 && seven.size() == 0) {
            return liczba;
        }

        int randomize;
        Random random = new Random();
        if (three.size() != 0) {
            randomize = random.nextInt(three.size());
            digits.set(randomize,8);
        }
        if (six.size() != 0) {
            randomize = random.nextInt(six.size());
            digits.set(randomize,9);
        }
        if (seven.size() != 0) {
            randomize = random.nextInt(seven.size());
            digits.set(randomize,1);
        }
        //adding array to new integer
        int[] array = new int[digits.size()];
        for(int j=0;j < array.length ;j++){
            array[j] = digits.get(j);
        }
        int res=0;
        for(int j=0;j < array.length ;j++) {
            res = 10 * res + array[j];
        }
        return res;


    }
}
