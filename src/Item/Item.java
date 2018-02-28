public abstract class Item {
    private int value;
    private String name;

    public Item() {
        this.name="";
        this.value = 0;
    }

    public Item(int value, String name) {
        setValue(value);
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    private void setValue(int value) {
        if (value>=0) {
            this.value = value;
        }
        else this.value=0;
    }

    public String getName() {
        return name;
    }
}
