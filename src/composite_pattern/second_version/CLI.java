package composite_pattern.second_version;

import java.util.Scanner;

public class CLI {
    private final Scanner in = new Scanner(System.in);
    private Directory current;

    public CLI(Directory directory) {
        this.current = directory;
    }

    public void start() {
        while (true) {
            System.out.print(String.format("%s> ", current.getName()));
            String command = in.nextLine();
            executeCommand(command);
        }
    }

    private void executeCommand(String command) {
        String[] parts = command.split(" ");
        if ("cd".equals(parts[0])) {
            changeDirectory(parts[1]);
        } else if ("size".equals(parts[0])) {
            countTotalBytes(parts[1]);
        } else {
            System.err.println("Unrecognizable Command..");
        }
    }

    private void changeDirectory(String name) {
        if ("..".equals(name)) {
            current = current.getParent() == null ? current : current.getParent();
        } else {
            Item item = current.getItem(name);
            if(item == null){
                System.err.println(String.format("Can't find the item '%s' ..",name));
            } else {
                current = (Directory) item;
            }
        }
    }

    private void countTotalBytes(String name) {
        Item item = current.getItem(name);
        if(null == item){
            System.err.println(String.format("Can't find the item '%s' ..",name));
        } else {
            System.out.println(String.format("Size: %s B",item.bytes()));
        }
    }
}
