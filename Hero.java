class Hero extends Character {
    protected Weapon weapon;
    protected Armor armor;

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
        if (status.equals(Status.SLEEP)) {
            System.out.println(nama + " sedang tidur dan tidak bisa menyerang!");
            return;
        }

        int damage = weapon.getDamage();
        target.HP -= damage;
        System.out.println(nama + " menyerang " + target.nama + " dengan " + weapon.getName() + " dan menyebabkan "
                + damage + " damage!");

        if (target.status.equals(Status.WEAK)) {
            target.HP -= (int) (damage * 0.5); // Tambahan damage jika target dalam status WEAK
            System.out.println(target.nama + " menerima tambahan damage karena dalam kondisi WEAK!");
        }

        if (target.status.equals(Status.SLEEP)) {
            target.removeStatus(Status.SLEEP);
            System.out.println(target.nama + " bangun dari tidur setelah diserang!");
        }

        int biayaMP = 20;
        MP -= biayaMP;
        System.out.println(nama + " menggunakan " + biayaMP + " MP untuk menyerang. MP " + nama + " sekarang: " + MP);
    }

    @Override
    public void useSkill(Character target) {
        throw new UnsupportedOperationException("Unimplemented method 'useSkill'");
    }

    @Override
    public void useItem(Character target) {
        throw new UnsupportedOperationException("Unimplemented method 'useItem'");
    }

    public void defend() {
        int shield = armor.getShield();
        HP += shield;
        System.out.println(nama + " menggunakan " + armor.getName() + " untuk bertahan dan mendapatkan shield sebesar "
                + shield + "!");
    }

    public void item(String itemName) {
        switch (itemName.toLowerCase()) {
            case Item.ELIXIR:
                MP += 100;
                HP += 150;
                System.out.println(nama + " menggunakan Elixir dan meningkatkan MP sebesar 30 dan HP sebesar 20!");
                break;
            case Item.POTION:
                HP += 100;
                System.out.println(nama + " menggunakan Potion dan meningkatkan HP sebesar 50!");
                break;
            case Item.ETHER:
                MP += 100;
                System.out.println(nama + " menggunakan Ether dan meningkatkan MP sebesar 50!");
                break;
            case Item.REMEDY:
                removeAllStatuses();
                System.out.println(nama + " menggunakan Remedy dan menghilangkan seluruh status efek!");
                break;
            case Item.ANTIDOTE:
                removeStatus(Status.POISON);
                System.out.println(nama + " menggunakan Antidote dan menghilangkan efek Poison!");
                break;

            default:
                System.out.println("Item tidak valid.");
        }
    }

    @Override
    protected Object getNama() {
        throw new UnsupportedOperationException("Unimplemented method 'getNama'");
    }

    @Override
    public void useMagicUlti(Character target) {
        throw new UnsupportedOperationException("Unimplemented method 'useMagicUlti'");
    }
}
