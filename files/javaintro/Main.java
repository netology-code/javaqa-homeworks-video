public class Main {
    public static void main(String[] args) {

        int income = 70000;   // доход
        int spending = 100000; // расход
        
        int tax = income * 6 / 100; // налог 6% на доходы
        int tax2 = (income - spending) * 15 / 100; // налог 15% на разницу доходов и расходов

        System.out.println("Ваш налог на первой системе: " + tax + " рублей");
        System.out.println("Ваш налог на второй системе: " + tax2 + " рублей");

    }
}
