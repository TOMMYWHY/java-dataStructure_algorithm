package s01.io;

import java.io.File;

public class TreeFile {
    public void showFile(File file) {
        File[] files = file.listFiles();
        if(files != null && files.length != 0){
            for(File f : files){
                this.showFile(f);
            }
        }
        System.out.println(file.getAbsolutePath());
    }

    public static void main(String[] args) {
        TreeFile ntf = new TreeFile();
        File file = new File("/Users/Tommy/Desktop/study2020");
        ntf.showFile(file);
    }
}

