import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book
{
    private static int nextId = 1; 

    private int id;  //instances of attributes 
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author)  //public constructor
    {
        this.id = nextId++;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }
}

class Library
{
    private List<Book> books;

    public Library()
    {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author)
    {
        Book book = new Book(title, author);
        books.add(book);
        System.out.println("--> Book added: " + book.getTitle());
    }

    public void removeBook(int id)
    {
        Book book = findBookById(id);
        if (book != null)
        {
            books.remove(book);
            System.out.println("--> Book removed:" + book.getTitle());
        }
        else
        {
            System.out.println("--> Book not found with ID:" + id);
        }
    }

    public void displayAvailableBooks()
    {
        System.out.println("\n---------- Available Books: ----------");
        if (books.isEmpty())
        {
            System.out.println("  There are no books available in the library.\n");
        }
        else
        {
            for (Book book : books)
            {
                if (book.isAvailable())
                {
                    System.out.println("--> ID: " + book.getId() + ", BOOK TITLE: " + book.getTitle() + ", BOOK AUTHOR: " + book.getAuthor());
                }
            }
        }
    }

    public void borrowBook(int id)
    {
        Book book = findBookById(id);
        if (book != null)
        {
            if (book.isAvailable())
            {
                book.setAvailable(false);
                System.out.println("--> Book borrowed: " + book.getTitle());
            }
            else
            {
                System.out.println("  It is not possible to borrow this book:\n" + book.getTitle());
            }
        }
        else
        {
            System.out.println("--> Book not found with ID:" + id);
        }
    }

    public void returnBook(int id)
    {
        Book book = findBookById(id);
        if (book != null)
        {
            if (!book.isAvailable())
            {
                book.setAvailable(true);
                System.out.println("--> Book returned:" + book.getTitle());
            }
            else
            {
                System.out.println("--> Book is already available:" + book.getTitle());
            }
        }
        else
        {
            System.out.println("--> Book not found with ID Number:" + id);
        }
    }

    private Book findBookById(int id)
    {
        for (Book book : books)
        {
            if (book.getId() == id)
            {
                return book;
            }
        }
        return null;
    }
}

class LibraryManagement   //encapsulations
{
    private static final String EXIT_COMMAND = "6";
    private Library library;

    public LibraryManagement()
    {
        library = new Library();
    }

    public static void main(String[] args)
    {
        LibraryManagement libraryManagement = new LibraryManagement();
        libraryManagement.start();
    }

    public void start()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n==============  CASE #2  ==============");
        System.out.println("    ----------------------  ");
        System.out.println("      LIBRARY MANAGEMENT  ");
        System.out.println("    ----------------------  ");

        String command;
        do {
            displayMenu();
            command = scanner.nextLine();

            try {
                if (command.equalsIgnoreCase("1")) {
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                } else if (command.equalsIgnoreCase("2")) {
                    System.out.print("Enter book ID Number: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    library.removeBook(id);
                } else if (command.equalsIgnoreCase("3")) {
                    library.displayAvailableBooks();
                } else if (command.equalsIgnoreCase("4")) {
                    System.out.print("Enter book ID Number: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    library.borrowBook(id);
                } else if (command.equalsIgnoreCase("5")) {
                    System.out.print("Enter book ID Number: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    library.returnBook(id);
                } else if (!command.equalsIgnoreCase(EXIT_COMMAND)) {
                    System.out.println(" -- Invalid choice! Please try again.--\n");
                }
            } catch (NumberFormatException e) {  //Exception
                System.out.println(" Invalid input!");
                System.out.println(" Please enter a valid number.\n");
            }
        } while (!command.equalsIgnoreCase(EXIT_COMMAND));

        System.out.println("\n  Thank you!");
        System.out.println("  --- End of Program ---");

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. Display available books");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Exit\n");
        System.out.print("  Hi! Please enter your choice: ");
    }
}

