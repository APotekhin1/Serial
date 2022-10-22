import java.io.*;

public class Basket implements Serializable {
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

    public void saveBin(File binFile) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(binFile))) {
            out.writeObject(this);
        }
    }

    public static Basket loadFromBinFile(File binFile) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(binFile))) {
            return (Basket) in.readObject();
        }
    }
}
