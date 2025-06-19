import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class EcommerceSearch {
    public static Product linearSearch(Product[] products, int targetId){
        for(Product product : products){
            if(product.productId == targetId){
                return product;
            }
        }
        return null;

    }
    public static Product binarySearch(Product[] sortedProducts, int targetId){
        int left = 0;
        int right = sortedProducts.length-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            int currentId = sortedProducts[mid].productId;

            if(currentId == targetId){
                return sortedProducts[mid];
            }else if (currentId < targetId){
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[]products={
            new Product(01,"Laptop","Electronics"),
            new Product(03,"Sandals", "Footwear"),
            new Product(05,"Jeans", "Clothing"),
            new Product(02,"Utensils", "Kitchenware"),
            new Product(04,"Lipstick", "Makeup"),
            new Product(06,"Pens", "Stationery"),
        };
        Arrays.sort(products,Comparator.comparingInt(p->p.productId));
        while(true){
            System.out.println("\nPresent Product IDs:01,02,03,04,05,06");
            System.out.print("Enter ProductID to search(or 0 to exit):");
            int targetId = scanner.nextInt();

            if(targetId == 0){
                System.out.println("Exiting program....");
                break;
            }
            System.out.println("\n----Linear Search----");
            Product linearResult = linearSearch(products, targetId);
            printResult(linearResult);

            System.out.println("\n----Binary Search----");
            Product binaryResult = binarySearch(products, targetId);
            printResult(binaryResult);
        }
        scanner.close();
    }
    private static void printResult(Product result){
        if(result != null){
            result.displayInfo();
        }else{
            System.out.println("Product not found.");
        }
    }
    
}
