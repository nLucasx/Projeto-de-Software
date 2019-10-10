import java.util.Scanner;

public class Iface
{
    static int guests = 0;
    static int friend_position = 0;
    static int current_account = -1;
    static int[] friend_counter = new int[100];
    static int[] request_counter = new int[100];
    static int[][] requests = new int[100][100];
    static int[][] friends = new int[100][100];
    static String[] accounts = new String[100];
    static String[] nicks = new String[100];
    static String[] pass = new String[100];

    public static void main(String[] args)
    {   
        first_menu();
        System.out.println("Bye bye!");
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
        System.out.println("               [2] ------- Friends");
        System.out.println("               [3] ------- Send Messages to friends");
        System.out.println("               [4] ------- Community Space");
        System.out.println("               [5] ------- Delet my account (Dangerous)");
        System.out.println("               [6] ------- Log off");         
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
                if (guests < 100)
                {
                    input.nextLine();
                    register();
                }
                else System.out.println("We can not register anyone else!");
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
    public static void second_menu()
    {
        int option, option2;
        Scanner input = new Scanner(System.in);
        while (true)
        {
            System.out.print("[IFace] What do you want? >> ");
            option = input.nextInt();
            if (option == 1)
            {
                clear();
                show_profile();
                clear();
                while (true)
                {
                    System.out.print("[IFace] Choose an option to edit >> ");
                    option2 = input.nextInt();
                    if (option2 == 0) 
                    {
                        clear();
                        draw2();
                        clear();
                        break;
                    }
                    else if (option2 >= 1 && option2 <= 3)
                    {
                        clear();
                        draw2();
                        clear();
                        change_data(option2);
                        break;
                    }
                    else System.out.println("Invalid option!");
                }
            }
            else if  (option == 2)
            {
                clear();
                System.out.println("\n               [1] ------- Check friend requests");
                System.out.println("               [2] ------- Search for a person");
                System.out.println("               [3] ------- Show friend list");
                System.out.println("               [0] ------- Back");
                clear();
                while (true)
                {
                    System.out.print("[IFace] Choose an option >> ");
                    option2 = input.nextInt();
                    if (option2 == 1) 
                    {
                        clear();
                        draw2();
                        clear();
                        friend_requests();
                        break;
                    }
                    else if (option2 == 2)
                    {
                        clear();
                        draw2();
                        clear();
                        show_people();
                        break;
                    }
                    else if (option2 == 3)
                    {
                        if (friend_counter[current_account] == 0) 
                        {
                            clear();
                            draw2();
                            clear();
                            System.out.println("You don't have any friends either!");
                            break;
                        }
                        else
                        {
                            clear();
                            draw2();
                            clear();
                            System.out.println("Friends: ");
                            for (int i = 0; i < 100; i++) if (friends[current_account][i] == 1) System.out.printf("Nickname: %s\n", nicks[i]);                   
                            break;
                        }
                    }
                    else if (option2 == 0)
                    {
                        clear();
                        draw2();
                        clear();
                        break;
                    }
                    else System.out.println("Invalid option!");
                }
            }
            else if (option == 3)
            {

            }
            else if (option == 4)
            {

            }
            else if (option == 5)
            {
                System.out.print("Are you sure you want to delete your account? YES(1) / NO(0) >> ");
                option2 = input.nextInt();
                if (option2 == 1) delete_account();
                else 
                {
                    clear();
                    draw2();
                    clear();
                }
            }   
            else if (option == 6) break;
            else System.out.println("Invalid option!");
            
        }
        first_menu();
    }
    public static void delete_account()
    {
        
    }
    public static void friend_requests()
    {
        int option;
        Scanner input = new Scanner(System.in);
        if (request_counter[current_account] > 0)
        {       
            System.out.println("Requests: ");
            for (int i = 0; i < request_counter[current_account]; i++)
            {
                if (requests[current_account][i] == 1)
                {
                    while (true)
                    {
                        System.out.printf("Do you like to accept the request from %s? YES(1) / NO(0) >> ", nicks[i]);
                        option = input.nextInt();
                        if (option == 1)
                        {
                            request_counter[current_account]--;
                            requests[current_account][i] = 0;
                            friends[current_account][i] = 1;
                            friends[i][current_account] = 1;
                            friend_counter[current_account]++;
                            friend_counter[i]++;
                            break;
                        }
                        else if (option == 0) 
                        {   
                            System.out.printf("The request will be archived!");
                            break;
                        }
                        else System.out.println("Invalid option!");
                    }

                }
            }
        }
        else System.out.println("You don't have any requests!");
    }
    public static void show_people()
    {
        boolean exist_people = false;
        for (int i = 0; i < guests; i++)
        {
            if (i != current_account && requests[i][current_account] != 1 && friends[i][current_account] != 1) 
            {
                if (exist_people == false) exist_people = true;
                System.out.printf("Name: %s\n", nicks[i]);
            }
        }
        if (exist_people)
        {    
            while (true)
            {    
                System.out.print("Type the name of the person that you want to add >> ");
                String nickname;
                Scanner input = new Scanner(System.in);
                nickname = input.nextLine();
                if (exist(nickname, 0) && current_account != friend_position && requests[friend_position][current_account] != 1)
                {
                    send_request();
                    break;
                }
                else System.out.println("Invalid nickname!");
            }
            System.out.println("Sucess! Your request has been sent.");
        }
        else System.out.println("There are no people available right now!");
    }
    public static void send_request()
    {
        requests[friend_position][current_account] = 1;
        request_counter[friend_position]++;

    }
    public static void change_data(int option)
    {
        Scanner input = new Scanner(System.in);
        String data;
        if (option == 1)
        {
            System.out.print("[IFace] Enter your new account name >> ");
            data = input.nextLine();
            accounts[current_account] = data;
            System.out.println("Your account name has been changed!");
        }
        else if (option == 2)
        {
            System.out.print("[IFace] Enter your new nickname >> ");
            data = input.nextLine();
            nicks[current_account] = data;
            System.out.println("Your nickname has been changed!");
        }
        else
        {
            String confirm;
            while (true)
            {
                System.out.print("[IFace] Enter your new password >> ");
                data = input.nextLine();
                System.out.print("[IFace] Confirm your new password >> ");
                confirm = input.nextLine();
                if (data.equals(confirm))
                {
                    pass[current_account] = data;
                    System.out.println("Your account name has been changed!");
                    break;
                }
                else System.out.println("Passwords do not match!");
            }
        }
    }
    public static void show_profile()
    {
        System.out.printf("\n               [1] ------- Account: %s\n", accounts[current_account]);
        System.out.printf("               [2] ------- Nickname: %s\n", nicks[current_account]);
        System.out.print("               [3] ------- Password: ");
        for (int i = 0; i < pass[current_account].length(); i++) System.out.print("*");
        System.out.println("\n               [0] ------- Back ");
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
        for (int i = 0; i < guests; i++)
        {
            if (nicks[i].equals(check))
            {
                friend_position = i;
                return true;
            }
            
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
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
}