package com.example.maven;

/**
 * Created by Hunter on 2015-06-10.
 */
    public class LiczbaRzymska {
        private int liczba;

        public LiczbaRzymska(int liczba){

            this.liczba = liczba;
        }
        public static String ToRom(int arabska){
            String roman = "";
            if(arabska < 1 || arabska > 3999){
                return "Insert Integer between 1 and 9999";
            }
            for(;arabska>=1000;arabska=arabska-1000) {
                roman = roman + "M";
            }
            for(;arabska>=900;arabska=arabska-900) {
                roman = roman + "CM";
            }
            for(;arabska>=500;arabska=arabska-500) {
                roman = roman + "D";
            }
            for(;arabska>=400;arabska=arabska-400) {
                roman = roman + "CD";
            }
            for(;arabska>=100;arabska=arabska-100) {
                roman = roman + "C";
            }
            for(;arabska>=90;arabska=arabska-90) {
                roman = roman + "XC";
            }
            for(;arabska>=50;arabska=arabska-50) {
                roman = roman + "L";
            }
            for(;arabska>=40;arabska=arabska-40) {
                roman = roman + "XL";
            }
            for(;arabska>=10;arabska=arabska-10) {
                roman = roman + "X";
            }
            for(;arabska>=9;arabska=arabska-9) {
                roman = roman + "IX";
            }
            for(;arabska>=5;arabska=arabska-5) {
                roman = roman + "V";
            }
            for(;arabska>=4;arabska=arabska-4) {
                roman = roman + "IV";
            }
            for(;arabska>=1;arabska=arabska-1) {
                roman = roman + "I";
            }

            return roman;
        }

        @Override
        public String toString() {
            return ToRom(liczba);
        }

    }
