package composite_pattern.init_version;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private Directory parent;
    private final String directoryName;
    private String pwd;
    private List<File> fileChildrenList = new ArrayList();
    private List<Directory> directoryChildrenList = new ArrayList();

    public static Directory root(){
        return new Directory("root");
    }

    public Directory(String directoryName){
        this.directoryName = Utils.shouldMatch("^[A-Za-z0-9._-]+$", directoryName);

    }
    public void addDirectory(Directory directory){
        directoryChildrenList.add(directory);
        directory.setParent(this);
    }

    public void addFile(File file){
        fileChildrenList.add(file);
        file.setParent(this);
    }

    public Directory getDirectory(String directoryName) {
        for(Directory directory : directoryChildrenList){
            if(directory.getDirectoryName().equals(directoryName)){
                return directory;
            }
        }
        return null;
    }

    public File getFile(String fileName){
        for(File file : fileChildrenList){
            if(file.getFileName().equals(fileName)){
                return file;
            }
        }
        return null;
    }

    public long totalBytes(){
        // TODO 統計自己fileTList & directoryChildrenList下面的fileTList大小
        long totalBytes = 0;
        totalBytes+= fileChildrenList.stream().map(o -> o.bytes()).mapToLong(Long::longValue).sum();
        totalBytes+= directoryChildrenList.stream().map(o -> o.totalBytes()).mapToLong(Long::longValue).sum();

        return totalBytes;

    }

    public String getDirectoryName() {
        return directoryName;
    }


    public List<File> getFileChildrenList() {
        return fileChildrenList;
    }

    public void setFileChildrenList(List<File> fileChildrenList) {
        this.fileChildrenList = fileChildrenList;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public List<Directory> getDirectoryChildrenList() {
        return directoryChildrenList;
    }

    public void setDirectoryChildrenList(List<Directory> directoryChildrenList) {
        this.directoryChildrenList = directoryChildrenList;
    }
}
