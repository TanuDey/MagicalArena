package Player;
import java.util.Scanner;

class Player {
    private String name;
    private int health;
    private int strength;
    private int attack;

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

   

}



class MagicalArena {
    private Player playerA;
    private Player playerB;
    private Scanner scanner;

    public MagicalArena(Player playerA, Player playerB, Scanner scanner) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.scanner = scanner;
    }

 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Player A:");
        System.out.print("Name: ");
        String nameA = scanner.nextLine();
        System.out.print("Health: ");
        int healthA = scanner.nextInt();
        System.out.print("Strength: ");
        int strengthA = scanner.nextInt();
        System.out.print("Attack: ");
        int attackA = scanner.nextInt();
        scanner.nextLine();

        Player playerA = new Player(nameA, healthA, strengthA, attackA);

        System.out.println("Enter details for Player B:");
        System.out.print("Name: ");
        String nameB = scanner.nextLine();
        System.out.print("Health: ");
        int healthB = scanner.nextInt();
        System.out.print("Strength: ");
        int strengthB = scanner.nextInt();
        System.out.print("Attack: ");
        int attackB = scanner.nextInt();

        Player playerB = new Player(nameB, healthB, strengthB, attackB);

        MagicalArena arena = new MagicalArena(playerA, playerB, scanner);
       
        scanner.close();
    }
}

