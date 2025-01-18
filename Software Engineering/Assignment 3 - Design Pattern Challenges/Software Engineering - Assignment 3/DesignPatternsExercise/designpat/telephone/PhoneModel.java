package designpat.telephone;

import java.util.ArrayList;
import java.util.List;

/**
 * Store a phone number, digit-by-digit
 * @author Pavel Detvan & Martin Popov
 */
public class PhoneModel{
    private List<Integer> digits = new ArrayList<>();
    private List<PhoneObserver> observer = new ArrayList<>();

    public void addDigit(int newDigit) {
        digits.add(newDigit);
        notify(newDigit);
    }

    public List<Integer> getDigits() {
        return digits;
    }

    public void addObserver(PhoneObserver o){
        this.observer.add(o);
    }

    public void deleteObserver(PhoneObserver o){
        this.observer.remove(o);
    }

    public void notify(int digit) {
        for (PhoneObserver o : observer) {
            o.update(digit);
        }
    }
}
