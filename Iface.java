import java.util.Scanner;

public class Iface
{
    static int guests = 0;
    static int friend_position = 0;
    static int current_account = -1;
    static int[] friend_counter = new int[100];
    static int[] request_counter = new int[100];
    static int[] comm_request_counter = new int[100];
    static int[] community_counter = new int[100];
    static int[] my_communities = new int[100];
    static int[] posts_index = new int[100];
    static int[][] community_requests = new int[100][100];
    static int[][] requests = new int[100][100];
    static int[][] friends = new int[100][100];
    static int[][] community_members = new int[100][100];
    static String[][] community_info = new String[100][2];
    static String[][] community_feed = new String[100][200];
    static String[][] messages = new String[100][200];
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
        System.out.println("               [3] ------- Social");
        System.out.println("               [4] ------- Community Space");
        System.out.println("               [5] ------- Delet my account (Dangerous)");
        System.out.println("               [6] ------- Log off");         
    }
    public static void draw_friends()
    {
        System.out.println("\n               [1] ------- Check friend requests");
        System.out.println("               [2] ------- Search for a person");
        System.out.println("               [3] ------- Show friend list");
        System.out.println("               [0] ------- Back");
    }
    public static void draw_comm_menu()
    {
        System.out.println("\n               [1] ------- My communities");
        System.out.println("               [2] ------- Available communities");
        System.out.println("               [3] ------- Create a community");
        System.out.println("               [4] ------- Manage your community");
        System.out.println("               [0] ------- Back");
    }
    public static void draw_message_menu()
    {
        System.out.println("\n               [1] ------- Send Messages");
        System.out.println("               [2] ------- Mailbox");
        System.out.println("               [0] ------- Back");
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
                    System.out.print("[IFace] Choose an option >> ");
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
                        change_data(option2);
                        clear();
                        show_profile();
                        clear();
                    }
                    else System.out.println("Invalid option!");
                }
            }
            else if  (option == 2)
            {
                clear();
                draw_friends();
                clear();
                while (true)
                {
                    System.out.print("[IFace] Choose an option >> ");
                    option2 = input.nextInt();
                    if (option2 == 1) 
                    {
                        clear();
                        draw_friends();
                        clear();
                        friend_requests();
                    }
                    else if (option2 == 2)
                    {
                        clear();
                        draw_friends();
                        clear();
                        show_people();
                    }
                    else if (option2 == 3)
                    {
                        if (friend_counter[current_account] == 0) 
                        {
                            clear();
                            draw_friends();
                            clear();
                            System.out.println("You don't have any friends either!");
                        }
                        else
                        {
                            clear();
                            draw_friends();
                            clear();
                            System.out.println("Friends: ");
                            for (int i = 0; i < 100; i++) if (friends[current_account][i] == 1) System.out.printf("Nickname: %s\n", nicks[i]);                   

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
                clear();
                draw_message_menu();
                clear();
                while (true)
                {
                    System.out.print("[IFace] Choose an option >> ");
                    option2 = input.nextInt();
                    if (option2 == 1)
                    {
                        clear();
                        draw_message_menu();
                        clear();
                        send_message();
                    }
                    else if (option2 == 2)
                    {
                        clear();
                        draw_message_menu();
                        clear();
                        mailbox();
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
            else if (option == 4)
            {
                clear();
                draw_comm_menu();
                clear();
                while (true)
                {
                    System.out.print("[IFace] Choose an option >> ");
                    option2 = input.nextInt();
                    if (option2 == 1)
                    {
                        clear();
                        System.out.println("\n               [1] ------- View a community feed");
                        System.out.println("               [2] ------- Make a post");
                        System.out.println("               [0] ------- Back");
                        clear();
                        while (true)
                        {
                            System.out.print("[IFace] Choose an option >> ");
                            option2 = input.nextInt();
                            if (option2 == 1) show_community();
                            else if (option2 == 2) make_posts();
                            else if (option2 == 0)
                            {
                                clear();
                                draw_comm_menu();
                                clear();
                                break;
                            }
                        else System.out.println("Invalid option!");
                        }
                    }
                    else if (option2 == 2)
                    {
                        clear();
                        draw_comm_menu();
                        clear();
                        available_community();
                    }
                    else if (option2 == 3)
                    {
                        if (community_info[current_account][0] == null && community_info[current_account][1] == null)
                        {
                            clear();
                            draw_comm_menu();
                            clear();
                            create_community();
                        }
                        else
                        {
                            clear();
                            draw_comm_menu();
                            clear();
                            System.out.println("You are already a community administrator!");
                        }
                    }
                    else if (option2 == 4)
                    {
                        if (community_info[current_account][0] != null && community_info[current_account][1] != null)
                        {
                            clear();
                            System.out.println("\n               [1] ------- View requests");
                            System.out.println("               [2] ------- Expel someone");
                            System.out.println("               [0] ------- Back");
                            clear();
                            while (option2 != 0)
                            {
                                System.out.print("[IFace] Choose an option >> ");
                                option2 = input.nextInt();
                                if (option2 == 1 || option2 == 2) manage_community(option2);
                                else System.out.println("Invalid option!");
                            }
                            clear();
                            draw_comm_menu();
                            clear();
                        }
                        else
                        {
                            clear();
                            draw_comm_menu();
                            clear();
                            System.out.println("You are not a community administrator!");
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
            else if (option == 5)
            {
                System.out.print("Are you sure you want to delete your account? YES(1) / NO(0) >> ");
                option2 = input.nextInt();
                if (option2 == 1) 
                {
                    delete_account();
                    first_menu();
                }
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
    public static void make_posts()
    {
        int choice;
        Scanner input = new Scanner(System.in);
        if (my_communities[current_account] > 0)
        {
            System.out.println("Your communities: ");
            for (int i = 0; i < 100; i++)
            {
                if (community_members[i][current_account] == 1)
                {
                    System.out.printf("%d Community: %s\n", i+1, community_info[i][0]);
                    System.out.printf("Description: %s\n\n", community_info[i][1]);
                }
                else if (community_members[i][current_account] == 2)
                {
                    System.out.printf("[ADM] %d Your community: %s\n", i+1, community_info[i][0]);
                    System.out.printf("Description: %s\n\n", community_info[i][1]);
                }
            }
            String post;
            while (true)
            {
                System.out.print("Type the community ID number that you want to make a post (-1 to exit) >> ");
                choice = input.nextInt();
                input.nextLine();
                if (choice <= 0) break;
                if (choice <= 100 && (community_members[choice-1][current_account] == 1 || community_members[choice-1][current_account] == 2))
                {
                    if (posts_index[choice-1] > 200) posts_index[choice-1] = 0;
                    System.out.println("Enter your message: ");
                    post = input.nextLine();
                    post += "\n" + "Signed by: " + nicks[current_account] + "\n";
                    community_feed[choice-1][posts_index[choice-1]] = post;
                    posts_index[choice-1]++;
                    System.out.println("Sucess! You made a post.");
                    break;
                }
                else System.out.println("Invalid option!");
            }
        }
        else System.out.println("You are not part of any community");
    }
    public static void available_community()
    {
        Scanner input = new Scanner(System.in);
        int option;
        boolean exist = false;
        for (int i = 0; i < 100; i++)
        {
            if (community_info[i][0] != null && i != current_account && community_requests[i][current_account] != 1 && community_members[i][current_account] != 1) 
            {
                System.out.printf("%d Community: %s\n", i+1, community_info[i][0]);
                System.out.printf("Description: %s\n", community_info[i][1]);
                if (exist == false) exist = true;
            }
        }
        if (exist)
        {    
            while (true)
            {
                System.out.print("Enter the community number that you want to join >> ");
                option = input.nextInt();
                if (option <= 0 || option > 100 || community_requests[option-1][current_account] == 1 || option-1 == current_account)
                {
                    System.out.println("Invalid option!");
                }
                else break;
            }
            community_requests[option-1][current_account] = 1;
            comm_request_counter[option-1]++;
            System.out.println("Sucess! Your request has been sent!");
        }
        else System.out.println("There are currently no communities available!");
    }
    public static void manage_community(int option)
    {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        if (option == 1)
        {
            if (comm_request_counter[current_account] > 0)
            {    
                for (int i = 0; i < 100; i++)
                {
                    if (community_requests[current_account][i] == 1)
                    {
                        System.out.printf("%s wants to join to the community! YES(1) / NO(ANY) >> ", nicks[i]);
                        choice = input.nextInt();
                        if (choice == 1) 
                        {
                            community_members[current_account][i] = 1;
                            community_requests[current_account][i] = 0;
                            comm_request_counter[current_account]--;
                            community_counter[current_account]++;
                            my_communities[i]++;
                        }       
                    }
                }
            }
            else System.out.println("There are no requests!");
        }
        else
        {
            if (community_counter[current_account] > 0)
            {
                for (int i = 0; i < 100; i++)
                {
                    if (community_members[current_account][i] == 1) System.out.printf("%d Nickname: %s", i+1, nicks[i]);
                }
                while (true)
                {
                    System.out.print("Type the user number ID to expel (-1 to exit) >> ");
                    choice = input.nextInt();
                    if (choice <= 0) break;
                    if (choice <= 100 && community_members[current_account][choice-1] == 1)
                    {
                        community_members[current_account][choice-1] = 0;
                        community_counter[current_account]--;
                        my_communities[choice-1]--;
                    }
                    else System.out.println("Invalid option!");
                }
            }
            else System.out.println("Your community currently has no members!");
        }
    }
    public static void show_community()
    {
        int choice;
        Scanner input = new Scanner(System.in);
        if (my_communities[current_account] > 0)
        {
            System.out.println("Your communities: ");
            for (int i = 0; i < 100; i++)
            {
                if (community_members[i][current_account] == 1)
                {
                    System.out.printf("%d Community: %s\n", i+1, community_info[i][0]);
                    System.out.printf("Description: %s\n\n", community_info[i][1]);
                }
                else if (community_members[i][current_account] == 2)
                {
                    System.out.printf("[ADM] %d Your community: %s\n", i+1, community_info[i][0]);
                    System.out.printf("Description: %s\n\n", community_info[i][1]);
                }
            }
            boolean exist = false;
            while (true)
            {
                System.out.print("Type the community ID number that you want to see the feed (-1 to exit) >> ");
                choice = input.nextInt();
                if (choice <= 0) break;
                if (choice <= 100 && community_members[choice-1][current_account] >= 1)
                {
                    for (int i = 0; i < 200; i++)
                    {
                        if (community_feed[choice-1][i] != null) 
                        {
                            System.out.println(community_feed[choice-1][i]);
                            if (exist == false) exist = true;
                        }
                    }
                    if (exist == false) System.out.println("There are no posts in this community!");
                    else exist = false;
                }
                else System.out.println("Invalid option!");
            }
        }
        else System.out.println("You are not part of any community");
    }
    public static void create_community()
    {
        Scanner input = new Scanner(System.in);
        String name, description;
        boolean exist = true;
        while (true)
        {    
            System.out.print("Enter community name >> ");
            name = input.nextLine();
            System.out.print("Enter a description for it >> ");
            description = input.nextLine();
            for (int i = 0; i < 100; i++)
            {
                if (community_info[i][0] != null && name.equals(community_info[i][0]))
                {
                    System.out.println("This community name is already in use!");
                    break;
                }
                if (i == 99) exist = false;
            }
            if (exist == false) break;
        }
        community_info[current_account][0] = name;
        community_info[current_account][1] = description;
        my_communities[current_account]++;
        community_members[current_account][current_account] = 2;
        System.out.println("Sucess! your community has been created.");


    }
    public static void delete_account()
    {
        accounts[current_account] = null;
        nicks[current_account] = null;
        pass[current_account] = null;
        friend_counter[current_account] = 0;
        request_counter[current_account] = 0;
        guests--;
        my_communities[current_account] = 0;
        comm_request_counter[current_account] = 0;
        community_counter[current_account] = 0;
        community_info[current_account][0] = null;
        community_info[current_account][1] = null;
        for (int i = 0; i < 100; i++)
        {
            requests[current_account][i] = 0; 
            if (requests[i][current_account] == 1)
            {
                requests[i][current_account] = 0;
                request_counter[i]--;
            }
            if (friends[current_account][i] == 1)
            {
                friends[current_account][i] = 0;
                friends[i][current_account] = 0;
                friend_counter[i]--;
            }
            if (community_requests[i][current_account] == 1) community_requests[i][current_account] = 0;
            community_requests[i][current_account] = 0;
            community_members[i][current_account] = 0;
            if (community_members[current_account][i] == 1)
            {
                my_communities[i]--;
                community_members[current_account][i] = 0;
            }
        }
        for (int i = 0; i < 200; i++) community_feed[current_account][i] = null;
    }
    public static void friend_requests()
    {
        int option;
        Scanner input = new Scanner(System.in);
        if (request_counter[current_account] > 0)
        {       
            System.out.println("Requests: ");
            for (int i = 0; i < 100; i++)
            {
                if (i != current_account && requests[current_account][i] == 1)
                {
                    while (true)
                    {
                        System.out.printf("Do you like to accept the request from %s? YES(1) / NO(0) >> ", nicks[i]);
                        option = input.nextInt();
                        if (option == 1)
                        {
                            request_counter[current_account]--;
                            if (requests[i][current_account] == 1) request_counter[i]--;
                            requests[current_account][i] = 0;
                            requests[i][current_account] = 0;
                            friends[current_account][i] = 1;
                            friends[i][current_account] = 1;
                            friend_counter[current_account]++;
                            friend_counter[i]++;
                            break;
                        }
                        else if (option == 0) 
                        {   
                            request_counter[current_account]--;
                            requests[current_account][i] = 0;
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
        for (int i = 0; i < 100; i++)
        {
            if (accounts[i] != null)
            {    
                if (i != current_account && requests[i][current_account] != 1 && friends[i][current_account] != 1) 
                {
                    if (exist_people == false) exist_people = true;
                    System.out.printf("Name: %s\n", nicks[i]);
                }
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
            while (true)
            {    
                System.out.print("[IFace] Enter your new account name >> ");
                data = input.nextLine();
                if (exist(data, 1)) System.out.println("This username already exists!");
                else
                {
                    accounts[current_account] = data;
                    System.out.println("Your account name has been changed!");
                    break;
                }
            }
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
        for (i = 0 ; i < 100; i++)
        {
            if (accounts[i] != null)
            {    
                if (account.equals(accounts[i]))
                {
                    found = true;
                    break;
                }
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
                if (i != null && i.equals(check)) return true;
            }
            return false;
        }
        for (int i = 0; i < 100; i++)
        {
            if (nicks[i] != null && nicks[i].equals(check))
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
        
        while (true)
        {    
            System.out.print("[IFace] Type your nickname >> ");
            nickname = input.nextLine();
            if (exist(nickname, 0)) System.out.println("This nickname already exists!");
            else break;
        }

        while (true)
        {    
            System.out.print("[IFace] Type your password >> ");
            password = input.nextLine();
            System.out.print("[IFace] Confirm your password >> ");
            confirm = input.nextLine();
            if (password.equals(confirm)) break;
            else System.out.println("Passwords do not match!");
            
        }

        for (int i = 0; i < 100; i++)
        {
            if (accounts[i] == null)
            {
                accounts[i] = account;
                nicks[i] = nickname;
                pass[i] = password;
                break;
            }
        }
        clear();
        draw();
        clear();
        System.out.println("Sucess!");
        guests++;
    }
    public static void send_message()
    {
        boolean exist_people = false;
        for (String i : nicks)
        {
            if (i != null && i.equals(nicks[current_account]) == false) 
            {
                System.out.printf("Name: %s\n", i);
                if (exist_people == false) exist_people = true;
            } 
        }
        if (exist_people)
        {    
            String nickname, message;
            Scanner input = new Scanner(System.in);

            while (true)
            {    
                System.out.print("Type the name of the person that you want to send a message >> ");
                nickname = input.nextLine();
                if (exist(nickname, 0) && current_account != friend_position)
                {
                    System.out.println("Enter your message: ");
                    message = input.nextLine();
                    message += "\nSigned by: " + nicks[current_account] + "\n";
                    for (int i = 0; i < 100; i++)
                    {
                        if (messages[friend_position][i] == null) 
                        {
                            messages[friend_position][i] = message;
                            break;
                        }
                    }
                    break;
                }
                else System.out.println("Invalid nickname!");
            }
            System.out.println("Sucess! Your message has been sent.");
        }
        else System.out.println("There are no people available to chat right now!");
    }
    public static void mailbox()
    {
        int option;
        boolean yes = true;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 200; i++)
        {
            if (messages[current_account][i] != null)
            {
                System.out.printf("%s\n", messages[current_account][i]);
                messages[current_account][i] = null;
                System.out.print("Do you want to see more messages? YES(1) / NO(0) >> ");
                option = input.nextInt();
                if (option != 1) 
                {
                    yes = false;
                    break;
                }
            }
        }
        if (yes) System.out.println("There is no messages for you!");
    }
    public static void print_registered()
    {
        for (int i = 0; i < 100; i++)
        {
            if (accounts[i] != null) System.out.printf("%s %s %s\n", accounts[i], nicks[i], pass[i]);
        }
    }
    public static void clear()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n");
    }
}