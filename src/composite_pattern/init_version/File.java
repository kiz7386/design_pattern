package composite_pattern.init_version;

public class File{

    private Directory parent;
    private final String fileName;
    private final byte[] content;


    public File(String fileName, String content){
        this.fileName = Utils.shouldMatch("^[A-Za-z0-9._-]+$", fileName);
        this.content = content.getBytes();
    }

    public long bytes(){
        return content.length;
    }


    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getContent() {
        return content;
    }
}
