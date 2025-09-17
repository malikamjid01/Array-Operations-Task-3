import java.util.Scanner;

public class Main{
    static Scanner s = new Scanner(System.in);
    static int size; // current size of array

    public static void main(String[] args) {
        System.out.print("Enter maximum size of array: ");
        int maxSize = s.nextInt();
        int[] arr = new int[maxSize];

        System.out.print("Enter number of elements: ");
        size = s.nextInt();

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = s.nextInt();
        }

        while (true) {
            System.out.println("--- ARRAY OPERATION MENU ---");
            System.out.println("Press (1) for Traversal");
            System.out.println("Press (2) for Insertion");
            System.out.println("Press (3) for Deletion");
            System.out.println("Press (4) for Searching");
            System.out.println("Press (5) for Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    traversal(arr);
                    break;
                case 2:
                    insertion(arr);
                    break;
                case 3:
                    deletion(arr);
                    break;
                case 4:
                    searching(arr);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice Try again.");
            }
        }
    }

    // Traversal
    public static void traversal(int[] arr) {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        System.out.println("Array elements are: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void insertion(int[] arr) {
        if (size == arr.length) {
            System.out.println("Array is full! Cannot insert.");
            return;
        }
        System.out.println("Press 1 for Beginning");
        System.out.println("Press 2 for Given Position");
        System.out.println("Press 3 for End");
        System.out.print("Enter your choice: ");
        int n = s.nextInt();

        switch (n) {
            case 1:
                System.out.print("Enter element to insert: ");
                int first = s.nextInt();
                for (int i = size; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = first;
                size++;
                break;

            case 2:
                System.out.print("Enter position ");
                int pos = s.nextInt();
                if (pos < 0 || pos > size) {
                    System.out.println("invalid");
                    return;
                }
                System.out.print("Enter element to insert: ");
                int elem = s.nextInt();
                for (int i = size; i > pos; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[pos] = elem;
                size++;
                break;

            case 3:
                System.out.print("Enter element to insert: ");
                int last = s.nextInt();
                arr[size] = last;
                size++;
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }


    public static void deletion(int[] arr) {
        if (size == 0) {
            System.out.println("Array is empty! Cannot delete.");
            return;
        }
        System.out.println("Press 1 for Beginning");
        System.out.println("Press 2 for Given Position");
        System.out.println("Press 3 for End");
        System.out.print("Enter your choice: ");
        int n = s.nextInt();
        switch (n) {
            case 1:
                System.out.println("Deleted element: " + arr[0]);
                for (int i = 0; i < size - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                size--;
                break;
            case 2:
                System.out.print("Enter position (0 to " + (size - 1) + "): ");
                int pos = s.nextInt();
                if (pos < 0 || pos >= size) {
                    System.out.println("Invalid position!");
                    return;
                }
                System.out.println("Deleted element: " + arr[pos]);
                for (int i = pos; i < size - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                size--;
                break;

            case 3: // End
                System.out.println("Deleted element: " + arr[size - 1]);
                size--;
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    // Searching
    public static void searching(int[] arr) {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        System.out.print("Enter element to search: ");
        int key = s.nextInt();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index: " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element not found in array.");
        }
    }
}
