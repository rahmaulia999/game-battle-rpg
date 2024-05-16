class Weapon {
    public enum Type {PEDANG, PANAH}

    protected Type type;
    private String name;
    private int damage;

    public Weapon(Type type) {
        this.type = type;
        switch (type) {
            case PEDANG:
                this.name = "Pedang";
                this.damage = 50;
                break;
            case PANAH:
                this.name = "Panah";
                this.damage = 30;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}