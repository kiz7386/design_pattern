package composite_pattern.init_version;

public class Main {
    public static void main(String[] args) {
        Directory root = Directory.root();
        Directory firstDocument = new Directory("firstDocument");
        Directory notes = new Directory("notes");
        root.addDirectory(firstDocument);
        firstDocument.addDirectory(notes);
        root.addFile(new File("me.txt", "Hello World"));
        notes.addFile(new File("meeting-0806.txt", "someOne: aaaaaaaa"));
        notes.addFile(new File("meeting-0807.txt", "someTwo: bbbbbbbb"));

        CLI cli = new CLI(root);
        cli.start();
    }
}
