import java.util.Scanner;

class Fairy extends Hero implements Heal {
    public Fairy(String nama, String ras, int level, Weapon.Type weaponType, Armor.Type armorType) {
        super(nama, ras, level, weaponType, armorType);
    }

    @Override
    public void heal(Character target) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih karakter yang akan disembuhkan:");
        System.out.println("1. Heal diri sendiri\n2. Heal lawan");
        int choice = scanner.nextInt();
        //scanner.close();

        switch (choice) {
            case 1:
                this.HP += 50;
                System.out.println(this.nama + " menyembuhkan diri sendiri dan menambah HP sebesar 50!");
                break;
            case 2:
                System.out.println("Masukkan nama lawan yang akan disembuhkan:");
                String namaLawan = scanner.next();
                Character[] party = { target };
                for (Character c : party) {
                    if (c.nama.equals(namaLawan)) {
                        c.HP += 50;
                        System.out.println(this.nama + " menyembuhkan " + namaLawan + " dan menambah HP sebesar 50!");
                    }
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                scanner.close();
        } 
    } 
}

