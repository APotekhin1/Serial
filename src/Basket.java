import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
        System.out.println("Ваша корзина:");
        for (int i = 0; i < productsName.length; i++) {
            if (counts[i] != 0) {
                System.out.println(productsName[i] + " " + counts[i] +
                        " шт. " + prices[i] + " руб./шт. " +
                        (counts[i] * prices[i]) + " в сумме");
            }
        }
    }

    public void saveJson(File jsonFile) throws IOException {
        try (PrintWriter out = new PrintWriter(jsonFile)) {



        }
    }

    public static Basket loadFromJson(File jsonFile) {

    }
}
