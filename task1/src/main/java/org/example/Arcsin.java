package org.example;

public class Arcsin {
    public static double count(double x){
        return count (x, Integer.MAX_VALUE);
    }
    // допустим у нас ряд маклорена, а не тейлора
    public static double count(double x, int n){
        if (Math.abs(x) > 1) {
            return Double.NaN;
        }

        // если аргумент 0 - то возвращаем 0
        if (x == 0.0 || Double.isNaN(x)) {
            return x;
        }

        if (x < 0) {
            return -count(-x, n);
        }

        // при х близких к 1 ряд медленно сходится, поэтому делаем преобразование аргумента и считаем ряд с меньшим аргументом
        if (x > 0.8){
            return Math.PI / 2 - arcsinSeries(Math.sqrt(1 - x*x), n);
        }
        return arcsinSeries(x, n);
    }

    // функция для вычисления ряда
    // каждый член ряда считается рекуррентно
    private static double arcsinSeries(double x, int n){
        double sum = x;
        double x_curr = x;

        for (int i = 1; i < n; i++){
            double x_new = x_curr * (Math.pow(2 * i - 1, 2))/((2 * i)*(2 * i + 1)) * x * x;
            sum += x_new;
            x_curr = x_new;
        }
        return sum;
    }
}
