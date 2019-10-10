import java.util.Scanner;

public class Iface
{
    static int guests = 0;
    static int current_account = -1;
    static String[] accounts = new String[100];
    static String[] nicks = new String[100];
    static String[] pass = new String[100];

    public static void main(String[] args)
    {   
        first_menu();
        System.out.println("Bye bye!");
        //print_registered();
    }
    public static void draw()
    {
        System.out.println("              _____  __");                
        System.out.println("              \\_   \\/ _| __ _  ___ ___"); 
        System.out.println("               / /\\/ |_ / _` |/ __/ _ \\");
        System.out.println("            /\\/ /_ |  _| (_| | (_|  __/");
        System.out.println("            \\____/ |_|  \\__,_|\\___\\___|");
        System.out.println("\n                    Welcome to IFace!");

        System.out.println("\n               [1] ------- Sign in");
        System.out.println("               [2] ------- Sign up");
        System.out.println("               [0] ------- Exit"); 
    }
    public static void draw2()
    {
        System.out.println("\n               [1] ------- Edit your profile");
        System.out.println("               [2] ------- Add friends");
        System.out.println("               [3] ------- Send Messages to friends");
        System.out.println("               [4] ------- Community Space");
        System.out.println("               [5] ------- Delet my account (Dangerous)");         
    }
    public static void first_menu()
    {                  
        clear();
        draw();
        clear();

        int option;
        Scanner input = new Scanner(System.in);
        System.out.print("[IFace] >> ");
        option = input.nextInt();
        while (option != 0)
        {
            if (option == 1)
            {       
                input.nextLine();
                login();
                second_menu();
                option = 0;
            }
            else if (option == 2)
            {
                input.nextLine();
                register();
                System.out.print("[IFace] Do you need anything else? >> ");
                option = input.nextInt();
            }
            else
            {
                if (option != 0)
                {    
                    System.out.print("[IFace] Invalid option! Try again >> ");
                    option = input.nextInt();
                }
            }
        }
    }
    public static int check_user(String account, String password)
    {
        boolean found = false;
        int i;
        for (i = 0 ; i < guests; i++)
        {
            if (account.equals(accounts[i]))
            {
                found = true;
                break;
            }
        }
        if (found)
        {
            if (password.equals(pass[i])) return i;
        }
        return -1;
    }
    public static void login()
    {
        boolean yes = true;
        String account, password;
        Scanner input = new Scanner(System.in);

        while (yes)    
        {    
            System.out.print("[IFace] Type your account name >> ");
            account = input.nextLine();

            System.out.print("[IFace] Type your password >> ");
            password = input.nextLine();

            current_account = check_user(account, password);
            if (current_account != -1)
            {
                clear();
                draw2();
                clear();
                System.out.printf("Welcome %s!\n", accounts[current_account]);
                yes = false;
            }
            else System.out.println("Account not found or invalid password. Try again!");
        }

    }
    public static void second_menu()
    {

    }
    public static boolean exist(String check, int operation)
    {
        if (operation == 1)
        {
            for (String i : accounts)
            {
                if ( i != null && i.equals(check)) return true;
            }
            return false;
        }
        for (String i : nicks)
        {
            if (i != null && i.equals(check)) return true;
        }
        return false;
    }
    
    public static void register()
    {
        String account, nickname, password, confirm;
        Scanner input = new Scanner(System.in);
        while (true)
        {
            System.out.print("[IFace] Type your account name >> ");
            account = input.nextLine();
            if (exist(account, 1)) System.out.println("This username already exists!");
            else break;
        }

        accounts[guests] = account;
        
        while (true)
        {    
            System.out.print("[IFace] Type your nickname >> ");
            nickname = input.nextLine();
            if (exist(nickname, 0)) System.out.println("This nickname already exists!");
            else break;
        }

        nicks[guests] = nickname;

        while (true)
        {    
            System.out.print("[IFace] Type your password >> ");
            password = input.nextLine();
            System.out.print("[IFace] Confirm your password >> ");
            confirm = input.nextLine();
            if (password.equals(confirm)) break;
            else System.out.println("Passwords do not match!");
            
        }

        pass[guests] = password;
        clear();
        draw();
        clear();
        System.out.println("Sucess!");
        guests++;
    }
    public static void print_registered()
    {
        for (int i = 0; i < guests; i++)
        {
            System.out.printf("%s %s %s\n", accounts[i], nicks[i], pass[i]);
        }
    }
    public static void clear()
    {
        System.out.println("\n\n\n\n\n\n\n");
    }
}