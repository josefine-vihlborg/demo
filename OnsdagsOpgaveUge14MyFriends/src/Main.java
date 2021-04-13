import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private ArrayList<Friend> friends = new ArrayList<>();

  public static void main(String[] args) {
    new Main().run();     //Her har jeg oprettet en instans af Main-klassen og kaldt run-metoden (punkt 5).
  }

  public void run() {
    Scanner scan = new Scanner(System.in);

    String[] menuItems = new String[6];
    menuItems[0] = "1. Show list of friends";
    menuItems[1] = "2. Enter new friend";
    menuItems[2] = "3. Delete Friend";
    menuItems[3] = "4. Save list";
    menuItems[4] = "5. Load list";
    menuItems[5] = "9. Quit";

    Menu menu = new Menu("MENU", "Choose option", menuItems);

    int choice;
    do {
      menu.printMenu();
      choice = menu.readChoice();
      switch (choice) {
        case 1:
          showList();
          break;
        case 2:
          System.out.print("Name: ");
          String name = scan.nextLine();
          System.out.print("Phone: ");
          String phone = scan.nextLine();
          System.out.print("Email: ");
          String email = scan.nextLine();
          Friend friend = new Friend(name, phone, email);
          enterNewFriend(friend);
          break;
        case 3:
          System.out.print("Name: ");
          String nameDelete = scan.nextLine();
          deleteFriend(nameDelete);
          break;
        case 4:
          saveList();
          break;
        case 5:
          loadList();
          break;
        case 9:
          System.out.println("Quitting... ");
          break;
        default:
          System.out.println("Not a valid choice!");
          break;
      }
    } while (choice != 9);
  }

  public void showList() {
    for (int i = 0; i < friends.size(); i++) {
      System.out.println("Name: " + friends.get(i).getName());
      System.out.println("Phone: " + friends.get(i).getPhone());
      System.out.println("Email: " + friends.get(i).getEmail());
      System.out.println();
    }
  }

  public void enterNewFriend(Friend friend) {
    friends.add(friend);
  }

  public void deleteFriend(String name) {
    for (int i = 0; i < friends.size(); i++) {
      if (friends.get(i).getName().equals(name)) {
        friends.remove(friends.get(i));
        break;
      }
    }
  }

  public void saveList() {
    try {
      PrintStream stream = new PrintStream("FriendList.txt");
      for (int i = 0; i < friends.size(); i++) {
        stream.println(friends.get(i));
      }
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
  }

  public void loadList() {
    friends.clear();

    try {
      Scanner scan = new Scanner(new File("FriendList.txt"));
      while (scan.hasNextLine()) {
        String text = scan.nextLine();
        String[] arr = text.split("#");
        Friend friend = new Friend(arr[0], arr[1], arr[2]);
        friends.add(friend);
      }
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
  }
}
