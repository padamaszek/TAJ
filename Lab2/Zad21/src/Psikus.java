import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Hunter on 2015-03-10.
 */
public class Psikus implements PsikusImp {

    @Override
    public Integer cyfrokrad(Integer liczba) {
        //Split of Integer to string
        String number = String.valueOf(liczba);
        //List<Integer> digits = new ArrayList<Integer>(); easier way
        String[] digits = number.split("(?<=.)");
        //return null if only 1 element
        if (digits.length <= 1) {
            return null;
        }

        Random random = new Random();

        int randomize = random.nextInt(digits.length);
        //loop to delete an element(Array list would be easier ArrayList got .remove method)
        for (int i = 0; i < digits.length; i++) {
            if (digits[i].equals(randomize)) {
                digits[i] = null;
                break;
            }
        }
        //adding array to new integer
        int i;
        int num = 0;
        for (i = 0; i < digits.length; i++) {
            num = 10 * num + Integer.parseInt(digits[i]);
        }
        return num;
    }

    @Override
    public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
        //Split of Integer to string
        String number = String.valueOf(liczba);
        //List<Integer> digits = new ArrayList<Integer>(); easier way
        String[] digits = number.split("(?<=.)");

        Random random = new Random();
        int randomize = random.nextInt(digits.length);
        int randomize2 = random.nextInt(digits.length);

        String pom, pom2;
        try {
            if (digits.length <= 1) {
                throw new NieudanyPsikusException("Wrong Length (it should be above 1)");
            }
            //switch
            pom = digits[randomize];
            pom2 = digits[randomize2];
            digits[randomize] = pom2;
            digits[randomize2] = pom;

        } catch (NieudanyPsikusException e) {
            System.out.println(e.getMessage());
        }
        //adding array to new integer
        int i;
        int num = 0;
        for (i = 0; i < digits.length; i++) {
            num = 10 * num + Integer.parseInt(digits[i]);
        }
        return num;
    }

    @Override
    public Integer nieksztaltek(Integer liczba) {
        //Split of Integer to string
        String number = String.valueOf(liczba);
        //List<Integer> digits = new ArrayList<Integer>(); easier way
        String[] digits = number.split("(?<=.)");

        int i;
        List<Integer> three = new ArrayList<Integer>();
        List<Integer> six = new ArrayList<Integer>();
        List<Integer> seven = new ArrayList<Integer>();
        for (i = 0; i < digits.length; i++) {
            if (digits[i] == "3") {
                three.add(i);
            }
            if (digits[i] == "6") {
                six.add(i);
            }
            if (digits[i] == "7") {
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
            digits[randomize] = "8";
        }
        if (six.size() != 0) {
            randomize = random.nextInt(six.size());
            digits[randomize] = "9";
        }
        if (seven.size() != 0) {
            randomize = random.nextInt(seven.size());
            digits[randomize] = "1";
        }
        //adding array to new integer
        int num = 0;
        for (i = 0; i < digits.length; i++) {
            num = 10 * num + Integer.parseInt(digits[i]);
        }

        return num;
    }
}
