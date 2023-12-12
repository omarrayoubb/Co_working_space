import java.io.*;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static ArrayList<Visitor> ReadUsers()
    {
        try
        {
            FileInputStream users = new FileInputStream("Users.txt");
            ObjectInputStream objusers = new ObjectInputStream(users);
            ArrayList<Visitor> userData = (ArrayList<Visitor>) objusers.readObject();
            return userData;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static  void WriteUsers(ArrayList<Visitor> usr)
    {
        try
        {
            FileOutputStream fileUsr = new FileOutputStream("Users.txt");
            ObjectOutputStream objUsr = new ObjectOutputStream(fileUsr);
            ArrayList<Visitor> usrOutput = usr;
            objUsr.writeObject(usrOutput);
            objUsr.close();
            fileUsr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {

        Visitor user = new Visitor();
        int choose;
        Scanner scan = new Scanner(System.in);
        ;
        ArrayList<Visitor> usrData = new ArrayList<Visitor>();

        usrData = ReadUsers();
        for (Visitor s: usrData)
        {
            System.out.println(s.getUsername() + s.getPassword() + s.getType() + s.getId());
        }
        System.out.println("1: for Login");
        System.out.println("2: for Register");
        choose = scan.nextInt();
        if (choose == 1)
            user.login(usrData);
        else if (choose == 2)
        {
            user.Register();
            usrData.add(user);
        }
        WriteUsers(usrData);



        slots date = new slots();
        date.setDate(24, 10, 2003, 7, 30);
        System.out.println(date.getDate());
        slots date2 = new slots();
        date2.setDate(20, 10, 2003);
        System.out.println(date2.getDate());
    }
}