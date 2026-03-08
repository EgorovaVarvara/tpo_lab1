package org.example;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("Usage: java App <x> <n>");
        }else{
            try{
                double x = Double.parseDouble(args[0]);
                int n = Integer.parseInt(args[1]);

                double result = Arcsin.count(x, n);

                if (Double.isNaN(result)) {
                    System.out.println("Error: x must be in [-1...1].");
                    return;
                }

                System.out.printf("arcsin(%.2f) = %.6f%n (with %d terms)", x, result, n);
            }catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number for x and an integer for n.");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        // провалидировать, распарсить

        // аргументы: x - аргумент функции, n - до какого порядка раскладывать в ряд

        // посчитать значение ряда (вынести в отдельный класс)

        // вывести красиво результат
    }
}