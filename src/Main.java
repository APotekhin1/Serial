import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"Хлеб", "Яблоки", "Молоко",
                "Крупа", "Огурцы", "Конфеты"};
        int[] prices = {50, 100, 40, 120, 60, 180};
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] +
                    ", Цена: " + prices[i] + " руб./шт.");
        }
        int[] sumCountProd = new int[products.length];
        int productNumber = 0; //номер продукта
        int productCount = 0; //количество продукта
        int sumProducts = 0; //сумма корзины
        while (true) {
            System.out.println("Выберите товар " +
                    "и количество или введите end");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");
            productNumber = Integer.parseInt(parts[0]) - 1;
            productCount = Integer.parseInt(parts[1]);
            sumProducts += productCount * prices[productNumber];
            sumCountProd[productNumber] += productCount;
            //общее кол-во продукта
        }
        System.out.println("Ваша корзина:");
        for (int i = 0; i < products.length; i++) {
            if (sumCountProd[i] != 0) {
                System.out.println(products[i] + " " + sumCountProd[i] +
                        " шт. " + prices[i] + " руб./шт. " +
                        (sumCountProd[i] * prices[i]) + " в сумме");
            }
        }
        System.out.println("Итого: " + sumProducts + " руб.");
    }
}