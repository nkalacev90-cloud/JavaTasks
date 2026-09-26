package JavaTask;

public class Factorial {

    public static int factorial(int n) {
        // Базовый случай: факториал 0 или 1 равен 1
        if (n == 0 || n == 1) {
            return 1;
        }
        // Рекурсивный случай: n! = n * (n-1)!
        else {
            return n * factorial(n - 1);
        }
    }
}
