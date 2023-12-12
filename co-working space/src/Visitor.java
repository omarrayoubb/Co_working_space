import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Visitor extends person {
    private String type;
    private int id = 0;

    public Visitor(String username, String password, String type, int id) {
        super(username, password);
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Visitor() {
    }

    @Override
    public int login(ArrayList<Visitor> usr) {
        ArrayList<Visitor> usrData = usr;
        while (true) {
            String name, password;
            System.out.println("Enter Your Username");
            Scanner read = new Scanner(System.in);
            name = read.nextLine();
            System.out.println("Enter Your Password");
            password = read.nextLine();
            for (Visitor i : usrData) {
                if (name.equalsIgnoreCase(i.getUsername()) && password.equals(i.getPassword())) {
                    this.setPassword(i.getPassword());
                    this.setUsername(i.getUsername());
                    id = i.id;
                    type = i.type;
                    System.out.println("User has logged in Successfully");
                    return 0;
                }
            }
            System.out.println("Please Enter A valid Username Or password");
        }
    }

    public int Register() {

        String userName, Password, Type;

        // int check = 0;
        int id;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Username: ");
            userName = scan.nextLine();
            System.out.print("Password: ");
            Password = scan.nextLine();
            System.out.println("Type: ");
            Type = scan.nextLine();
            System.out.print("ID: ");
            id = scan.nextInt();
            //constraints
            if (userName.equalsIgnoreCase("admin")) {
                System.out.println("Please Enter a valid username");
                continue;
            }
            if (userName.isEmpty()) {
                System.out.println("Username field is required");
                continue;
            }
            if (Password.isEmpty()) {
                System.out.println("password field is required");
                continue;
            }
            if (checkPassword(Password) == false)
                continue;
            break;
        }
        // Create the user
        this.setUsername(userName);
        this.setPassword(Password);
        this.type = Type;
        this.id = id;
        return 0;

    }

    public boolean checkPassword(String password) {
        String Password = password;
        boolean x = false, y = false, z = false, checkPasswordd = false;

        if (Password.length() <= 6) {
            System.out.println("Please write a strong password");
            return checkPasswordd;
        }
        // check = 0;
        for (int i = 0; i < Password.length(); i += 1) {

            if (Password.charAt(i) >= (int) 'A' && Password.charAt(i) <= (int) 'Z') ;
            {
                x = true;
            }
            if (Password.charAt(i) >= (int) '0' && Password.charAt(i) <= (int) '9') {
                y = true;
            } else if (Password.charAt(i) >= (int) 'a' && Password.charAt(i) <= (int) 'z') {
                z = true;
            }
                /*
                if (x == true && y == true && z == true)
                {
                    break;
                }
                 */
        }
        if (x == false || y == false || z == false) {
            System.out.println("Please Enter A strong Password that contains upper and lower case letters and numbers and symbols");
            return checkPasswordd;
        }
        checkPasswordd = true;
        return checkPasswordd;

    }

    public static void displaytypeData(String type, ArrayList<Visitor> usrData)

    {
        ArrayList<Visitor> usr = usrData;
        for (Visitor i : usr)
        {
            if (i.getType().equalsIgnoreCase(type))
            {
                System.out.println(i.getUsername() + "\t" + i.getPassword() + "\t" + i.getId() + "\t" + i.getType());
            }
        }

    }
    public static void displayallData(String type, ArrayList<Visitor> usrData)

    {
        ArrayList<Visitor> usr = usrData;
        for (Visitor i : usr)
        {
                System.out.println(i.getUsername() + "\t" + i.getPassword() + "\t" + i.getId() + "\t" + i.getType());
        }

    }
    /*
    public boolean checkUsername(String name)
    {
        if (name.isEmpty())
            return false;
        else if (name.equalsIgnoreCase("admin"))
        {
            System.out.println("Please Enter a valid username");
            return false;
        }
    }

       */
}
