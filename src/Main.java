import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"Хлеб", "Яблоки", "Молоко",
                "Крупа", "Огурцы", "Конфеты"};
        int[] prices = {50, 100, 40, 120, 60, 180};
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] +
                    ", Цена: " + prices[i] + " руб./шт.");
        }

        // int[] sumCountProd = new int[products.length];
        Basket basket = new Basket(products, prices);


        int productNumber = 0; //номер продукта
        int productCount = 0; //количество продукта

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

            basket.addToCart(productNumber, productCount);
        }

        basket.saveBin(new File("basket.bin"));

        basket.printCart();


    }
}