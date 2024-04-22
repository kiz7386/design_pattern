package composite_pattern.init_version;

import java.util.Scanner;

public class CLI {
    private final Scanner in = new Scanner(System.in);
    private Directory current;

    public CLI(Directory directory) {
        this.current = directory;
    }

    public void start() {
        while (true) {
            System.out.print(String.format("%s> ", current.getDirectoryName()));
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
            Directory directory = current.getDirectory(name);
            if(directory == null){
                System.err.println(String.format("Can't find the item '%s' ..",name));
            } else {
                current = directory;
            }
        }
    }

    private void countTotalBytes(String name) {
        // 當前已經是檔案
        File file = current.getFile(name);
        if(file != null){
            System.out.println(String.format("Size : %sB",file.bytes()));
        } else {
            Directory directory = current.getDirectory(name);
            if(null != directory){
                System.out.println(String.format("Size : %sB",directory.totalBytes()));
            } else {
                System.err.println(String.format("Can't find the item '%s' ..",name));
            }
        }
    }
}
