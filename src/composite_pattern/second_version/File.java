package composite_pattern.second_version;

public class File extends Item{

    private final byte[] content;


    public File(String fileName, String content){
        super(fileName);
        this.content = content.getBytes();
    }

    @Override
    public long bytes(){
        return content.length;
    }

}
