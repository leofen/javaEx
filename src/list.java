import java.io.File;

public class list {

    public static void main(String[] args){
        String path = "/";
        File folder = new File(path);
        String[] files = folder.list();
        for (String filename:files){
            System.out.println(filename);
        }
    }
}
