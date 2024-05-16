import java.util.Random;

class Foe extends Character {
    private int magicDamage;
    private int magicUlti;
    // private int potionDamage;
    // private int elixirDamage;
    // private int etherDamage;
    private int MP = 50;

    public Foe(String nama, String ras, int level, int magicDamage, int magicUlti, int potionDamage, int elixirDamage) {
        super(nama, ras, level);
        this.magicDamage = magicDamage;
        this.magicUlti = magicUlti;

        // this.potionDamage = potionDamage;
        // this.elixirDamage = elixirDamage;
    }

    @Override
    public void attack(Character target) {
        Random random = new Random();

        int action = new Random().nextInt(2);

        if (action == 0) {
            this.attack(target);
        } else {
            useItem(target);
        }

        int attackChoice = random.nextInt(3);

        switch (attackChoice) {
            case 0:
                normalAttack(target);
                break;
            case 1:
                useMagicDamage(target);
                break;
            case 2:
                useMagicUlti(target);
                break;
        }
        kurangiMP();

        // int itemChoice = random.nextInt(3);
        // switch (itemChoice) {
        // case 0:
        // target.HP -= potionDamage;
        // System.out.println(nama + " menggunakan Potion dan " + nama + " dan HP nya
        // bertambah sebanyak " + potionDamage + "!");
        // break;
        // case 1:
        // target.HP -= elixirDamage;
        // System.out.println(nama + " menggunakan Elixir dan " + nama + " dan HP nya
        // bertambah sebanyak " + elixirDamage + "!");
        // break;
        // case 2:
        // target.HP -= etherDamage;
        // System.out.println(nama + " menggunakan Ether dan " + nama + " dan HP nya
        // bertambah sebanyak " + etherDamage + "!");
        // break;
        // default:
        // System.out.println("Foe melakukan serangan normal.");

        // }

    }

    private void normalAttack(Character target) {
        // Implementasi serangan normal Foe
    }

    private void useMagicDamage(Character target) {
        target.HP -= magicDamage;
        System.out.println(nama + " menggunakan magic damage dan " + target.nama + " menerima damage sebesar "
                + magicDamage + "!");
    }

    public void defend() {
        // Implementasi perilaku bertahan Foe
        System.out.println(nama + " sedang bertahan!");
        kurangiMP();

    }

    private void useMagicUlti(Character target) {
        target.HP -= magicUlti;
        System.out
                .println(nama + " menggunakan Ulti dan " + target.nama + " menerima damage sebesar " + magicUlti + "!");
    }

    private void kurangiMP() {
        int biayaAksi = 20;
        MP -= biayaAksi;
        System.out.println(nama + " menggunakan " + biayaAksi + " MP untuk menyerang. MP " + nama + " sekarang: " + MP);

        // System.out.println(
        // nama + " menggunakan " + biayaAksi + " MP untuk melakukan aksi. MP " + nama +
        // " sekarang: " + MP);
    }

    // protected void usePotion() {
    // HP += potionDamage;
    // // System.out.println(nama + " menggunakan Potion dan meningkatkan HP sebesar
    // " + potionDamage + "!");
    // }

    // protected void useElixir() {
    // HP += elixirDamage;
    // MP += elixirDamage;
    // //System.out.println(nama + " menggunakan Elixir dan meningkatkan HP dan MP
    // sebesar " + elixirDamage + "!");
    // }

    // protected void useEther() {
    // MP += elixirDamage;
    // //System.out.println(nama + " menggunakan Ether dan meningkatkan MP sebesar "
    // + elixirDamage + "!");
    // }

    @Override
    public void useSkill(Character target) {

    }

    @Override
    public void useItem(Character target) {

    }

    @Override
    public String toString() {
        return nama + ": HP = " + HP + ", MP = " + MP;
    }
}