import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero hero = selectHero(scanner);
        Foe foe = selectFoe(scanner);
        System.out.println("\nPertempuran dimulai!");

        while (foe.HP > 0 && hero.HP > 0) {
            int foeAction = new Random().nextInt(2);

            if (foeAction == 0) {
                foe.attack(hero);
            } else {
                foe.defend();
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
                    hero.defend();
                    break;
                case 3:
                    useItem(hero, scanner);
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

    public static Hero selectHero(Scanner scanner) {
        System.out.println("Pilih Hero:");
        System.out.println("1. Arthur (Knight)");
        System.out.println("2. Robin (Archer)");
        System.out.print("Pilih Hero (masukkan nomor): ");
        int heroChoice = scanner.nextInt();

        switch (heroChoice) {
            case 1:
                return new Hero("Arthur", "Knight", 10, Weapon.Type.PEDANG, Armor.Type.PERISAI);
            case 2:
                return new Hero("Robin", "Archer", 8, Weapon.Type.PANAH, Armor.Type.ZIRAH);
            default:
                System.out.println("Pilihan Hero tidak valid, Arthur (Knight) akan dipilih secara default.");
                return new Hero("Arthur", "Knight", 10, Weapon.Type.PEDANG, Armor.Type.PERISAI);
        }
    }

    public static Foe selectFoe(Scanner scanner) {
        System.out.println("\nPilih Foe:");
        System.out.println("1. Orc");
        System.out.println("2. Elf");
        System.out.print("Pilih Foe (masukkan nomor): ");
        int foeChoice = scanner.nextInt();
    
        switch (foeChoice) {
            case 1:
                return new Foe("Orc", "Orc", 12, 30, 50, 70, 10 );
            case 2:
                return new Foe("Elf", "Elf", 9, 25, 40, 60, 10);
            default:
                System.out.println("Pilihan Foe tidak valid, Orc akan dipilih secara default.");
                return new Foe("Orc", "Orc", 12, 30, 50, 70, 10);
        }
    }

    public static int selectAction(Scanner scanner) {
        System.out.println("\nApa yang akan dilakukan oleh Hero?");
        System.out.println("1. Serang");
        System.out.println("2. Bertahan");
        System.out.println("3. Gunakan item");
        System.out.print("Pilih aksi (masukkan nomor): ");
        return scanner.nextInt();
    }

    public static void useItem(Hero hero, Scanner scanner) {
        System.out.println("\nPilih item yang akan digunakan:");
        System.out.println("1. Elixir (Menambahkan MP dan HP)");
        System.out.println("2. Potion (Menambahkan HP)");
        System.out.println("3. Ether (Menambahkan MP)");
        System.out.print("Pilih item (masukkan nama item): ");
        String itemName = scanner.next();
        hero.item(itemName);
    }
}