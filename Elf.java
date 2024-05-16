class Elf extends Foe implements Heal {

    public Elf(String nama, String ras, int level, int magicDamage, int magicUlti) {
        super(nama, ras, level, magicDamage, magicUlti);
    }

    @Override
    public void heal(Character target) {
        target.HP += 50;
        System.out.println(nama + " menggunakan Healing dan meningkatkan HP " + target.nama + " sebesar 50!");
    }

    @Override
    public void useSkill(Character target) {
        // Implementasi skill khusus Elf
    }

    @Override
    public void useItem(Character target) {
        // Implementasi penggunaan item oleh Elf
    }
}
