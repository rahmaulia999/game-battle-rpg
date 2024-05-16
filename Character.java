public abstract class Character {
    public String nama;
    public String ras;
    protected int level;
    protected int HP = 100;
    protected int MP = 50;

    public Character(String nama, String ras, int level) {
        this.nama = nama;
        this.ras = ras;
        this.level = level;
        this.HP = level * 10; 
        this.MP = level * 5;
    }

    public abstract void attack(Character target);

    public abstract void useSkill(Character target);

    public abstract void useItem(Character target);

    public void levelUp() {
        this.level++;
        this.HP = level * 100;
        this.MP = level * 50;
    }

    @Override
    public String toString() {
        return nama + ": HP = " + HP + ", MP = " + MP;
    }
}