package composite_pattern.second_version;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Item{

    private final List<Item> itemChildrenList = new ArrayList<>();
    public static Directory root(){
        return new Directory("root");
    }

    public Directory(String name){
        super(name);

    }

    public Item getItem(String name){
//        return itemChildrenList.stream().filter(child -> child.name.equals(name)).findFirst().orElse(null);
        for (Item child : itemChildrenList){
            if(child.name.equals(name)){
                return child;
            }
        }
        return null;
    }

    public void addItem(Item item){
        itemChildrenList.add(item);
        item.setParent(this);
    }

    @Override
    public long bytes() {
        return itemChildrenList.stream().mapToLong(Item::bytes).sum();
    }
}
