package s01.io;

import java.io.*;

public class OperateFile {

    public static void main(String[] args) {
        OperateFile of = new OperateFile();
//        of.copyFile(new File("/Users/Tommy/Desktop/temp/001.jpg"),"/Users/Tommy/Desktop");
//        of.encryptFile(new File("/Users/Tommy/Desktop/temp/001.jpg"),"/Users/Tommy/Desktop ");
//        of.copyFolderAndFile(new File("/Users/Tommy/Desktop/temp/001.jpg"),"/Users/Tommy/Desktop/test");
        of.copyFolderAndFile(new File("/Users/Tommy/Desktop/study2020"),"/Users/Tommy/Desktop/test ");

    }

    public void copyFile(File file,String path){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File newFile = new File(path+ "/"+file.getName());
             fos = new FileOutputStream(newFile);


             fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int count =  fis.read(b);
            while (count != -1){
                fos.write(b,0,count);
                fos.flush();
                count = fis.read(b);
            }
            System.out.println("copy completed~@!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis !=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos !=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void encryptFile(File file,String path){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File newFile = new File(path+ "/"+file.getName());
            fos = new FileOutputStream(newFile);


            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int count =  fis.read(b);
            while (count != -1){
                byte temp = b[0];
                b[0] = b[1];
                b[1] = temp;
                fos.write(b,0,count);
                fos.flush();
                count = fis.read(b);
            }
            System.out.println("copy completed~@!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis !=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos !=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //
    public void copyFolderAndFile(File file,String newPath){
        //p58 rewrite
        String oldPath = file.getAbsolutePath();
        String newFilePth = newPath + oldPath.split("Desktop")[1];
        File newFile = new File(newFilePth);

        File[] files = file.listFiles();
        if(files !=null){
            //folder
            newFile.mkdir();

            if(files !=null && files.length !=0){
                for (File f :files){
                    this.copyFolderAndFile(f,newPath);
                }
            }
        }
        else {
            //file
           FileInputStream fis = null;
           FileOutputStream fos = null;
            try {
                fis = new FileInputStream(file);
                  byte[] b = new byte[1024];
                int count =  fis.read(b);
                while (count !=-1){
                    fos.write(b,0,count);
                    fos.flush();
                    count = fis.read();
                }
                System.out.println( newFile.getName() + " copy completed~!");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(fis!=null ){
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(fos!=null ){
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
