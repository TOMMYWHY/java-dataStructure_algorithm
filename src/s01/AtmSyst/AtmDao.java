package s01.AtmSyst;

import java.util.HashMap;

//Data Access Object    ----    CURD
public class AtmDao {

    private FileLoaderAndCommit fileLoaderAndCommit = new FileLoaderAndCommit("/javaSe01/src/s01/AtmSyst/User.txt");

    private HashMap<String, User> userBox = fileLoaderAndCommit.loadFile();

    public User selectOne(String aName) {
        return userBox.get(aName);
    }

    public void update(User user) {
        userBox.put(user.getaName(), user);
        this.fileLoaderAndCommit.commit(this.userBox);
    }

    // TODO: 2019/8/31
    public void insert(){}
    public void delete(){}
}
