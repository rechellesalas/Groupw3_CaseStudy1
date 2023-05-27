import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
class Inventory //ENCAPSULATION
{
    private Map <String, Integer> unit;//CONSTRUCTOR

    public Inventory()

    {
        unit = new HashMap<>();
    }

    public void addItem(String item, int quantity)//PARAMETERS
    {
        int currQuantity = unit.getOrDefault(item, 0);
        unit.put(item, currQuantity + quantity);
        System.out.println("The " + quantity + " " + item + " is successfully added to the inventory.");
    }

    public void removeItem(String item, int quantity)
    {
        if (unit.containsKey(item))
        {
            int currQuantity = unit.get(item);
            if (currQuantity >= quantity)
            {
                unit.put(item, currQuantity - quantity);
                System.out.println("The" + quantity + " " + item + " is successfully removed to the inventory.");
            }
            else
            {
                System.out.println("Insufficient number of quantity. Unable to remove " + quantity + " " + item + " from the inventory.");
            }
        }
        else
        {
            System.out.println("Sorry, Item not found in the inventory.");
        }
    }

    public void checkQuantity(String item)
    {
        if (unit.containsKey(item))
        {
            int quantity = unit.get(item);
            System.out.println("Quantity of " + item + " in the inventory: " + quantity);
        }
        else
        {
            System.out.println("Sorry, Item is not found in the inventory.");
        }
    }
}

public class InventoryManagement
{
    public static void main(String[] args)
    {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice)
            {
                case "1":
                    try 
                    {
                        System.out.print("Enter the inventory item name: ");
                        String item = scanner.nextLine();

                        System.out.print("Enter the quantity to be add: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        inventory.addItem(item, quantity);
                    }
                    catch (NumberFormatException e)
                    {
                         System.out.println("Invalid Quantity format. Please Enter a valid integer.");
                    }
                    break;
                case "2":
                    try
                    {
                        System.out.print("Enter the inventory item name: ");
                        String itemToRemove = scanner.nextLine();
                        System.out.print("Enter the number of quantity to remove: ");
                        int quantityToRemove = Integer.parseInt(scanner.nextLine());
                        inventory.removeItem(itemToRemove, quantityToRemove);
                    }
                    catch (NumberFormatException e) //EXCEPTION
                    {
                        System.out.println("Invalid Quantity format. Please Enter a valid integer.");
                    }
                    break;
                case "3":
                    System.out.print("Enter the item name: ");
                    String itemToCheck = scanner.nextLine();
                    inventory.checkQuantity(itemToCheck);
                    break;
                case "4":
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private static void printMenu()
    {
        System.out.println("\t--------------------\t");
        System.out.println("\tInventory Management\t");
        System.out.println("\t--------------------\t");
        System.out.println("1. Add item to the Inventory");
        System.out.println("2. Remove item or quantity from the Inventory");
        System.out.println("3. Check item quantity in the Inventory");
        System.out.println("4. Exit");
        System.out.print("\t\tEnter your choice:");

    }
}

