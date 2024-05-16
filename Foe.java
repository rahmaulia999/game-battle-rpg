import java.util.Random;

class Foe extends Character {
    private int magicDamage;
    private int magicUlti;

    public Foe(String nama, String ras, int level, int magicDamage, int magicUlti) {
        super(nama, ras, level);
        this.magicDamage = magicDamage;
        this.magicUlti = magicUlti;
    }

    @Override
    public void attack(Character target) {
        Random random = new Random();
        int action = random.nextInt(2);

        if (action == 0) {
            normalAttack(target);
        } else {
            useSkill(target);
        }

        if (target.status.equals(Status.POISON)) {
            target.HP -= target.poisonDamage;
            System.out.println(target.nama + " menerima " + target.poisonDamage + " damage karena efek POISON!");
        }
    }

    private void normalAttack(Character target) {
        System.out.println(nama + " menyerang " + target.nama + " dengan serangan foe!");
        target.HP -= 10; // Contoh nilai damage serangan normal
    }

    @SuppressWarnings("unused")
    private void useMagicDamage(Character target) {
        target.HP -= magicDamage;
        System.out.println(nama + " menggunakan magic damage dan " + target.nama + " menerima damage sebesar "
                + magicDamage + "!");
    }

    public void defend() {
        System.out.println(nama + " sedang bertahan!");
        kurangiMP();
    }

    @Override
    public void useMagicUlti(Character target) {
        target.HP -= magicUlti;
        System.out.println(nama + " menggunakan Ulti dan " + target.nama + " menerima damage sebesar " + magicUlti + "!");
    }

    private void kurangiMP() {
        int biayaAksi = 20;
        MP -= biayaAksi;
        System.out.println(nama + " menggunakan " + biayaAksi + " MP untuk menyerang. MP " + nama + " sekarang: " + MP);
    }

    @Override
    public void useSkill(Character target) {
        if (ras.equals("Dragon")) {
            target.applyStatus(Status.WEAK, 0);
            System.out.println(nama + " menggunakan skill 'fire' dan menyebabkan status WEAK pada " + target.nama + "!");
        } else if (ras.equals("Goblin")) {
            target.applyStatus(Status.POISON, 10);
            System.out.println(nama + " menggunakan skill 'gigit' dan menyebabkan status POISON pada " + target.nama + "!");
        } else if (ras.equals("Elf")) {
            target.applyStatus(Status.SLEEP, 0);
            System.out.println(nama + " menggunakan skill 'lullaby' dan menyebabkan status SLEEP pada " + target.nama + "!");
        }
    }

    @Override
    public void useItem(Character target) {
        // Implementasi penggunaan item oleh Foe
    }

    @Override
    protected Object getNama() {
        return nama;
    }
}
