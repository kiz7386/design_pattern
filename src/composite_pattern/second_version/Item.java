package composite_pattern.second_version;

public abstract class Item {

    protected final String name;
    protected Directory parent;

    public Item(String name){
        this.name = Utils.shouldMatch("^[A-Za-z0-9._-]+$", name);
    }

    public abstract long bytes();

    public String getName() {
        return name;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }
}
