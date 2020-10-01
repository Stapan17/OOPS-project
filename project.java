import java.util.Scanner;

abstract class Bike {

    int[][] BikesPrice = { { 300, 320, 350, 400 }, { 200, 220, 240, 250 }, { 2800, 2850, 2900, 3000 },
            { 400, 420, 450, 480 } };

    static int[][] BikesQuantity = { { 3, 3, 3, 3 }, { 3, 3, 3, 3 }, { 3, 3, 3, 3 }, { 3, 3, 3, 3 } };

    int[][] BikesPenalty = { { 25, 30, 35, 35 }, { 20, 25, 30, 30 }, { 110, 130, 150, 180 }, { 30, 40, 45, 50 } };

    String[] Types = { "Regular", "NonGear", "Sports", "Battery" };
    String[] Colors = { "White", "Black", "Red", "Blue" };
    long time1, time2, DueTime = 60;
    static int ChoosenType = 1, ChoosenColor = 1;

    Scanner sc = new Scanner(System.in);

    void BikeDetails() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Types[i] + " Bikes \n");
            System.out.println("Colors  " + "Price   " + "Penalty    " + "Quantity");

            for (int j = 0; j < 4; j++) {
                System.out.println(Colors[j] + "       " + BikesPrice[i][j] + "         " + BikesPenalty[i][j]
                        + "      " + BikesQuantity[i][j]);

            }
        }
    }

    void TakeBike() {
        System.out.println("1. Regular");
        System.out.println("2. NonGear");
        System.out.println("3. Sports");
        System.out.println("4. Battery");
        System.out.println("Enter your Choice for Types of Bike: ");

        ChoosenType = sc.nextInt();

        System.out.println("1. White");
        System.out.println("2. Black");
        System.out.println("3. Red");
        System.out.println("4. Blue");
        System.out.println("Enter your Choice For colors : ");

        ChoosenColor = sc.nextInt();

        if (BikesQuantity[ChoosenType - 1][ChoosenColor - 1] >= 1) {
            BikesQuantity[ChoosenType - 1][ChoosenColor - 1]--;
            System.out.println("Enjoy your Ride!!");
            time1 = System.currentTimeMillis() / 60000;
        } else {
            System.out.println("Bike is not Available");
        }
    }

    void ReturnBike() {
        System.out.println("1. Regular");
        System.out.println("2. NonGear");
        System.out.println("3. Sports");
        System.out.println("4. Battery");
        System.out.println("Enter your Choice : ");

        // ChoosenType = sc.nextInt();

        System.out.println("1. White");
        System.out.println("2. Black");
        System.out.println("3. Red");
        System.out.println("4. Blue");
        System.out.println("Enter your Choice : ");

        // ChoosenColor = sc.nextInt();

        BikesQuantity[ChoosenType - 1][ChoosenColor - 1]++;
        System.out.println("We Hope You Enjoy!!");
        time2 = System.currentTimeMillis() / 60000;
    }

}

class Rent extends Bike {

    private int Amount = BikesPrice[ChoosenType - 1][ChoosenColor - 1];
    long Time = time2 - time1;

    int GetHourRent() {

        Amount *= 1;

        // penalty case:
        if (Time > DueTime) {
            Amount += BikesPenalty[ChoosenType - 1][ChoosenColor - 1];
        }
        return Amount;
    }

    int GetDayRent() {
        Amount *= (0.98 * 24);

        // penalty case:
        if (Time > DueTime) {
            Amount += BikesPenalty[ChoosenType - 1][ChoosenColor - 1];
        }
        return Amount;
    }

    int GetWeekRent() {
        Amount *= (0.89 * 24 * 7);

        // penalty case:
        if (Time > DueTime) {
            Amount += BikesPenalty[ChoosenType - 1][ChoosenColor - 1];
        }
        return Amount;
    }
}

class All_User {

    static int I = 0, Index = 0;
    private static String array[][] = new String[50][2];
    // First column for username and second for password
    private static String Details[][] = new String[50][3];

    // First column for name, second for phone number and third for email

    public static void CreateUser() {

        System.out.println("\n----------------------------------");
        System.out.println("--> Enter Your Details Carefully :");
        System.out.println("----------------------------------");
        Scanner sc = new Scanner(System.in);

        String user, pass1, name, phone, email, pass2;

        System.out.println("\nEnter your name : ");
        name = sc.next();

        System.out.println("\nEnter your Phone Number : ");
        phone = sc.next();

        System.out.println("\nEnter your Email id : ");
        email = sc.next();

        System.out.println("\nEnter your Username : ");
        user = sc.next();

        System.out.println("\nEnter your Password : ");
        pass1 = sc.next();

        System.out.println("\nConfirm Password : ");
        pass2 = sc.next();

        System.out.println("\n#########################");

        if (pass1.equals(pass2)) {
            array[I][0] = user;
            array[I][1] = pass1;

            Details[I][0] = name;
            Details[I][1] = phone;
            Details[I][2] = email;

            I++;

            System.out.println(" Succesfully Registered!");
            System.out.println("#########################");
        } else {
            System.out.println("Password Doesn't Match");
        }

    }

    public static boolean CheckUser() {

        String User, pass;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter your Username : ");
        User = sc.nextLine();

        System.out.println("\nEnter your Password : ");
        pass = sc.nextLine();

        for (int i = 0; i <= I; i++)
            if (array[i][0].equals(User) && array[i][1].equals(pass)) {
                Index = i;

                return true;
            }

        return false;
    }

    public static void Profile() {
        System.out.println("\n  --> User Name : " + array[Index][0]);
        System.out.println("  --> Name :      " + Details[Index][0]);
        System.out.println("  --> Phone :     " + Details[Index][1]);
        System.out.println("  --> Email Id :  " + Details[Index][2] + "\n");
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("####### Welcome to Online BRS #######");
        System.out.println("-------------------------------------");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nSELECT CHOICE :\n ");
            System.out.println(" 1. Register");
            System.out.println(" 2. Log-in");
            System.out.println(" 3. Exit");

            int choice, authenticated = 0;
            choice = sc.nextInt();

            if (choice == 1) {
                All_User.CreateUser();
                authenticated = 1;
            }

            else if (choice == 2) {
                boolean check = All_User.CheckUser();

                if (check)
                    authenticated = 1;
                else {
                    System.out.println("Invalid username or password");
                    continue;
                }
            }

            else if (choice == 3) {
                break;
            }

            if (authenticated == 1) {
                System.out.println("\n\n##__WELCOME__##\n");
                while (true) {
                    int select = 0;
                    System.out.println("\nSelect Choice :\n ");
                    System.out.println("  1. Show Avaiable Bikes");
                    System.out.println("  2. Profile");
                    System.out.println("  3. Take Bike");
                    System.out.println("  4. Return Bike");
                    System.out.println("  5. Log-out");

                    select = sc.nextInt();
                    Rent TakeAndReturnBike = new Rent();

                    if (select == 1) {
                        Rent Details = new Rent();
                        Details.BikeDetails();
                    } else if (select == 2) {
                        All_User.Profile();
                    } else if (select == 3) {
                        TakeAndReturnBike.TakeBike();
                    } else if (select == 4) {
                        TakeAndReturnBike.ReturnBike();
                    } else if (select == 5) {
                        break;
                    }
                }
            } else {
                System.out.println("\nInvalid Usename or password");
            }
        }
    }
}