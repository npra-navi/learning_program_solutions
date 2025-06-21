import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(202, "Headphones", "Accessories"),
            new Product(303, "Keyboard", "Electronics"),
            new Product(404, "Shoes", "Fashion")
        };

        Product resultLinear = SearchAlgorithms.linearSearch(products, 202);
        System.out.println("Linear Search Result: " + resultLinear);

        Arrays.sort(products, (a, b) -> Integer.compare(a.productId, b.productId));

        Product resultBinary = SearchAlgorithms.binarySearch(products, 202);
        System.out.println("Binary Search Result: " + resultBinary);

        System.out.println("Linear Search Complexity: O(n)");
        System.out.println("Binary Search Complexity: O(log n)");
    }
}
