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
    public boolean isAlive() {
        return health > 0;
    }

    public int rollDice(Scanner scanner, String playerName, String rollType) {
        int roll;
        do {
            System.out.print(playerName + ", enter your " + rollType + " roll (1-6): ");
            roll = scanner.nextInt();
        } while (roll < 1 || roll > 6);
        return roll;
    }

    public void attack(Player defender, Scanner scanner) {
        int attackRoll = rollDice(scanner, this.name, "attack");
        int defenseRoll = defender.rollDice(scanner, defender.getName(), "defense");
        
        int damageDealt = this.attack * attackRoll;
        int damageDefended = defender.getStrength() * defenseRoll;
        int damageToDefender = Math.max(damageDealt - damageDefended, 0);
        
        defender.setHealth(defender.getHealth() - damageToDefender);
        
        System.out.println(this.name + " attacks " + defender.getName() + " and rolls a " + attackRoll);
        System.out.println(defender.getName() + " defends and rolls a " + defenseRoll);
        System.out.println(this.name + " deals " + damageToDefender + " damage to " + defender.getName());
        System.out.println(defender.getName() + " health is now " + defender.getHealth());
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

    public void startBattle() {
        System.out.println("Battle starts between " + playerA.getName() + " and " + playerB.getName());
        while (playerA.isAlive() && playerB.isAlive()) {
            if (playerA.getHealth() < playerB.getHealth()) {
                playerA.attack(playerB, scanner);
                if (playerB.isAlive()) {
                    playerB.attack(playerA, scanner);
                }
            } else {
                playerB.attack(playerA, scanner);
                if (playerA.isAlive()) {
                    playerA.attack(playerB, scanner);
                }
            }
        }

        if (playerA.isAlive()) {
            System.out.println(playerA.getName() + " wins the battle!");
        } else {
            System.out.println(playerB.getName() + " wins the battle!");
        }
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
        arena.startBattle();
       
        scanner.close();
    }
}

