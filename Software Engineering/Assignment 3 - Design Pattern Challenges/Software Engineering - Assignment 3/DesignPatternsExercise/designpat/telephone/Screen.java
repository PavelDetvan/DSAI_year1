package designpat.telephone;

import java.util.List;

/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 * System.out.println("hello");
 * @author Pavel Detvan & Martin Popov
 */
public class Screen implements PhoneObserver{
    private final PhoneModel model;

    public Screen(PhoneModel model) {
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(int digit) {
        List<Integer> digits = model.getDigits();
        System.out.println(digit);
        if(digits.size()==10){
            String number = "";
            for (Integer integer : digits) {
                number = number+integer;
            }
            System.out.println("Now dialing " + number + "...");
        }

    }
}
