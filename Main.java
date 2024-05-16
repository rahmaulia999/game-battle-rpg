import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character hero = selectHero(scanner);
        Character foe = selectFoe(scanner);
        System.out.println("\nPertempuran dimulai!");

        while (foe.HP > 0 && hero.HP > 0) {
            int foeAction = new Random().nextInt(2);

            if (foeAction == 0) {
                foe.attack(hero);
            } else {
                ((Foe)foe).defend();
            }

            System.out.println("\nInformasi Karakter Setelah Serangan Foe:");
            System.out.println(hero);
            System.out.println(foe);

            int heroAction = selectAction(scanner);

            switch (heroAction) {
                case 1:
                    hero.attack(foe);
                    break;
                case 2:
                    ((Hero)hero).defend();
                    break;
                case 3:
                    useItem((Hero)hero, scanner);
                    break;
                case 4:
                    if (hero instanceof Heal) {
                        ((Heal) hero).heal(hero);
                    } else {
                        System.out.println("Hero tidak bisa menggunakan heal.");
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

            System.out.println("\nInformasi Karakter Setelah Aksi Hero:");
            System.out.println(hero);
            System.out.println(foe);
        }

        if (foe.HP <= 0) {
            System.out.println(foe.nama + " telah dikalahkan!");
            hero.levelUp();
            System.out.println(hero.nama + " naik level menjadi level " + hero.level + "!");
        } else if (hero.HP <= 0) {
            System.out.println(hero.nama + " telah dikalahkan...");
        }

        scanner.close();
    }

    private static Character selectHero(Scanner scanner) {
        System.out.println("Pilih hero:");
        System.out.println("1. Arthur");
        System.out.println("2. Archer");
        System.out.println("3. Fighter");
        System.out.println("4. Fairy");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return new Hero("Arthur", "Knight", 1, Weapon.Type.PEDANG, Armor.Type.PERISAI);
            case 2:
                return new Hero("Archer", "Archer", 1, Weapon.Type.PANAH, Armor.Type.ZIRAH);
            case 3:
                return new Hero("Fighter", "Fighter", 1, Weapon.Type.PEDANG, Armor.Type.ZIRAH);
            case 4:
                return new Fairy("Fairy", "Fairy", 1, Weapon.Type.MAGIC, Armor.Type.PERISAI);
            default:
                System.out.println("Anda tidak memilih hero.");
                return null;
        }
    }

    private static Character selectFoe(Scanner scanner) {
        System.out.println("Pilih foe:");
        System.out.println("1. Dragon");
        System.out.println("2. Goblin");
        System.out.println("3. Elf");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return new Foe("Dragon", "Dragon", 1, 30, 50);
            case 2:
                return new Foe("Goblin", "Goblin", 1, 15, 30);
            case 3:
                return new Elf("Elf", "Elf", 1, 20, 40);
            default:
                System.out.println("Pilihan tidak valid, memilih Dragon sebagai default.");
                return new Foe("Dragon", "Dragon", 1, 30, 50);
        }
    }

    private static int selectAction(Scanner scanner) {
        System.out.println("Pilih aksi:");
        System.out.println("1. Serang");
        System.out.println("2. Bertahan");
        System.out.println("3. Gunakan item");
        System.out.println("4. Heal");

        return scanner.nextInt();
    }

    private static void useItem(Hero hero, Scanner scanner) {
        System.out.println("Pilih item:");
        System.out.println("1. Elixir");
        System.out.println("2. Potion");
        System.out.println("3. Ether");
        System.out.println("4. Remedy");
        System.out.println("5. Antidote");

        int itemChoice = scanner.nextInt();
        switch (itemChoice) {
            case 1:
                hero.item(Item.ELIXIR);
                break;
            case 2:
                hero.item(Item.POTION);
                break;
            case 3:
                hero.item(Item.ETHER);
                break;
            case 4:
                hero.item(Item.REMEDY);
                break;
            case 5:
                hero.item(Item.ANTIDOTE);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}