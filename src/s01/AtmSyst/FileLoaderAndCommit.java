package s01.AtmSyst;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

// connect DB and save
public class FileLoaderAndCommit {
    private String fileName = null;
    public  FileLoaderAndCommit(String fileName){
        this.fileName = fileName;
    }

    //loading user information
   public HashMap<String,User> loadFile() {
       HashMap<String, User> userBox = new HashMap<String, User>();
        File file = new File(System.getProperty("user.dir") + this.fileName);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);//file operation
            bufferedReader = new BufferedReader(fileReader);
            String value = bufferedReader.readLine(); //read file
            while (value != null) {
                String[] userValue = value.split("-");
                User user = new User(userValue[0], userValue[1], Float.parseFloat(userValue[2]));//create user
                userBox.put(user.getaName(), user);// push user into hashMap
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return  userBox;
    }

    public void commit(HashMap<String,User> userBox) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(System.getProperty("user.dir") + this.fileName);

            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Iterator<String> names = userBox.keySet().iterator();
            while (names.hasNext()) {
                String name = names.next();
                User user = userBox.get(name);
//             String value = user.getaName() + "-"
                StringBuilder builder = new StringBuilder(user.getaName());
                builder.append("-");
                builder.append(user.getaPassword());
                builder.append("-");
                builder.append(user.getaBalance());
                bufferedWriter.write(builder.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
