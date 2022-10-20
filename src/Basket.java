import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Basket {
    protected String[] productsName;
    protected int[] prices;
    protected int[] counts;

    public Basket(String[] productsName, int[] prices) {
        this.productsName = productsName;
        this.prices = prices;
        this.counts = new int[prices.length];
    }

    private Basket(String[] productsName, int[] prices, int[] counts) {
        this.productsName = productsName;
        this.prices = prices;
        this.counts = counts;
    }

    public void addToCart(int productsNum, int amount) {
        counts[productsNum] += amount;
    }

    public void printCart() {
        //System.out.println("Ваша корзина:");
        //for (int i = 0; i < products.length; i++) {
        //    if (sumCountProd[i] != 0) {
        //        System.out.println(products[i] + " " + sumCountProd[i] +
        //                " шт. " + prices[i] + " руб./шт. " +
        //                (sumCountProd[i] * prices[i]) + " в сумме");
        //    }
        //}
    }

    public void saveTxt(File textFile) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(textFile)) {
            for (String productsName : productsName) {
                out.print(productsName + " ");
            }
            out.println();

            for (int price : prices) {
                out.print(price + " ");
            }
            out.println();

            for (int count : counts) {
                out.print(count + " ");
            }
            out.println();
        }

    }

    public static Basket loadFromTxtFile(File txtFile) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream(txtFile))) {
            String[] procuctsNames = scanner.nextLine().trim().split(" ");
            int[] prices = Arrays.stream(scanner.nextLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] counts = Arrays.stream(scanner.nextLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return new Basket(procuctsNames, prices, counts);
        }
    }
}
