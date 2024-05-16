public abstract class Character {
    public String nama;
    public String ras;
    protected int level;
    protected int HP;
    protected int MP;
    protected String status = Status.NONE;
    protected int poisonDamage = 0;

    public Character(String nama, String ras, int level) {
        this.nama = nama;
        this.ras = ras;
        this.level = level;
        this.HP = level * 100;
        this.MP = level * 50;
    }

    public abstract void attack(Character target);

    public abstract void useSkill(Character target);

    public abstract void useItem(Character target);

    public abstract void useMagicUlti(Character target);

    public void levelUp() {
        this.level++;
        this.HP = level * 100;
        this.MP = level * 50;
    }

    public void applyStatus(String newStatus, int additionalDamage) {
        this.status = newStatus;
        if (newStatus.equals(Status.POISON)) {
            this.poisonDamage = additionalDamage;
        }
    }

    public void removeStatus(String statusType) {
        if (statusType.equals(Status.NONE) || this.status.equals(statusType)) {
            this.status = Status.NONE;
            this.poisonDamage = 0;
        }
    }

    public void removeAllStatuses() {
        this.status = Status.NONE;
        this.poisonDamage = 0;
    }

    @Override
    public String toString() {
        return nama + ": HP = " + HP + ", MP = " + MP + ", Status = " + status;
    }

    protected abstract Object getNama();
}

