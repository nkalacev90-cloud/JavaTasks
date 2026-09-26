package JavaTask;

public class Calculator {
    // Метод для выполнения операции
     public static double calculate(double num1, double num2, char operation) {
        switch (operation) {
            case '+':
                return sum(num1, num2) ;
            case '-':
                return diff(num1, num2);
            case '*':
                return mul(num1, num2);
            case '/':
                // Проверка на деление на ноль
                if (num2 == 0) {
                    System.out.println("Ошибка: Деление на ноль невозможно.");
                    System.exit(1);
                }
                return div(num1, num2); // Целочисленное деление (отбрасывает остаток)
            default:
                System.out.println("Ошибка: Неверный оператор.");
                System.exit(1);
        }
        return 0;
    }
    public static int sum (int num1, int num2){
         return  num1 + num2;
    }

    public static double sum (double num1, double num2){
        return  num1 + num2;
    }

    public static int div (int num1, int num2){
        return  num1 / num2;
    }

    public static double div (double num1, double num2){
        return  num1 / num2;
    }

    public static int mul (int num1, int num2){
        return  num1 * num2;
    }

    public static double mul (double num1, double num2){
        return  num1 * num2;
    }

    public static int diff  (int num1, int num2){
        return  num1 - num2;
    }

    public static double diff  (double num1, double num2){
        return  num1 - num2;
    }
    
}
