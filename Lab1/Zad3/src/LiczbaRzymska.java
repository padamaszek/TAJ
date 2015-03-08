/**
 * Created by Hunter on 2015-03-08.
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
/**
        while (arabska >= 1000) {
            roman = roman + "M";
            arabska = arabska - 1000; }
        while (arabska >= 900) {
            roman = roman + "CM";
            arabska = arabska - 900; }
        while (arabska >= 500) {
            roman = roman + "D";
            arabska = arabska - 500; }
        while (arabska >= 400) {
            roman = roman + "CD";
            arabska = arabska - 400; }
        while (arabska >= 100) {
            roman = roman + "C";
            arabska = arabska - 100; }
        while (arabska >= 90) {
            roman = roman + "XC";
            arabska = arabska - 90; }
        while (arabska >= 50) {
            roman = roman + "L";
            arabska = arabska - 50; }
        while (arabska >= 40) {
            roman = roman + "XL";
            arabska = arabska - 40; }
        while (arabska >= 10) {
            roman = roman + "X";
            arabska = arabska - 10; }
        while (arabska >= 9) {
            roman = roman + "IX";
            arabska = arabska - 9; }
        while (arabska >= 5) {
            roman = roman + "V";
            arabska = arabska - 5; }
        while (arabska >= 4) {
            roman = roman + "IV";
            arabska = arabska - 4; }
        while (arabska >= 1) {
            roman = roman + "I";
            arabska = arabska - 1; }*/
        return roman;
    }

    @Override
    public String toString() {
        return ToRom(liczba);
    }

    }

