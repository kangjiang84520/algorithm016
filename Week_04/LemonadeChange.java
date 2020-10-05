package No860;

public class LemonadeChange {
    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        int[] bills = new int[] {5,5,5,10,20};
        System.out.println(lemonadeChange.lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) {
            return true;
        }
        int five = 0, ten = 0, twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10 && five > 0) {
                five--;
                ten++;
            } else if (bills[i] == 20 && ten > 0 && five > 0) {
                ten--;
                five--;
            } else if (five > 3) {
                five -= 3;
            } else {
                return false;
            }
        }
        return true;
    }
}
