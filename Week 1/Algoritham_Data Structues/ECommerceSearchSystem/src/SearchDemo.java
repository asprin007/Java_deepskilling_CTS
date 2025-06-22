import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) return products[mid];
            else if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("P001", "Laptop", "Electronics"),
                new Product("P002", "Shirt", "Apparel"),
                new Product("P003", "Phone", "Electronics"),
                new Product("P004", "Shoes", "Footwear"),
                new Product("P005", "Book", "Education")
        };

        Product foundLinear = linearSearch(products, "Phone");
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        Product foundBinary = binarySearch(products, "Phone");
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary : "Not Found"));
    }
}
