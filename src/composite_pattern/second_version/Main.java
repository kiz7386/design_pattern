package composite_pattern.second_version;

public class Main {
    public static void main(String[] args) {
        Directory root = Directory.root();
        Directory firstDocument = new Directory("d");
        Directory notes = new Directory("notes");
        root.addItem(firstDocument);
        firstDocument.addItem(notes);
        root.addItem(new File("me.txt", "Hello World"));
        notes.addItem(new File("m-0806.txt", "someOne: aaaaaaaa"));
        notes.addItem(new File("m-0807.txt", "someTwo: bbbbbbbb"));

        CLI cli = new CLI(root);
        cli.start();
    }
}
