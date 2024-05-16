class Hero extends Character {
    private Weapon weapon;
    private Armor armor;

    public Hero(String nama, String ras, int level, Weapon.Type weaponType, Armor.Type armorType) {
        super(nama, ras, level);
        this.weapon = new Weapon(weaponType);
        this.armor = new Armor(armorType);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    @Override
    public void attack(Character target) {
        int damage = weapon.getDamage();
        target.HP -= damage;
        System.out.println(nama + " menyerang " + target.nama + " dengan " + weapon.getName() + " dan menyebabkan " + damage + " damage!");

        int biayaMP = 20;
        MP -= biayaMP;
        System.out.println(nama + " menggunakan " + biayaMP + " MP untuk menyerang. MP " + nama + " sekarang: " + MP);
    }

    public void defend() {
        int shield = armor.getShield();
        HP += shield;
        System.out.println(nama + " menggunakan " + armor.getName() + " untuk bertahan dan mendapatkan shield sebesar " + shield + "!");
    }

    public void item(String itemName) {
        switch (itemName.toLowerCase()) {
            case "elixir":
                MP += 30;
                HP += 20;
                System.out.println(nama + " menggunakan Elixir dan meningkatkan MP sebesar 30 dan HP sebesar 20!");
                break;
            case "potion":
                HP += 50;
                System.out.println(nama + " menggunakan Potion dan meningkatkan HP sebesar 50!");
                break;
            case "ether":
                MP += 50;
                System.out.println(nama + " menggunakan Ether dan meningkatkan MP sebesar 50!");
                break;
            default:
                System.out.println("Item tidak valid.");
        }
    }

    @Override
    public void useSkill(Character target) {
        throw new UnsupportedOperationException("Unimplemented method 'useSkill'");
    }

    @Override
    public void useItem(Character target) {
        throw new UnsupportedOperationException("Unimplemented method 'useItem'");
    }
}