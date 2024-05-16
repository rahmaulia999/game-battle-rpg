class Armor {
    public enum Type {PERISAI, ZIRAH}

    protected Type type;
    private String name;
    private int shield;

    public Armor(Type type) {
        this.type = type;
        switch (type) {
            case PERISAI:
                this.name = "Perisai";
                this.shield = 30;
                break;
            case ZIRAH:
                this.name = "Zirah";
                this.shield = 20;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getShield() {
        return shield;
    }
}