package s01.AtmSyst;

// business logic   ---     Model repository
public class AtmService {
    private AtmDao dao = new AtmDao();
    /*
    login
     */
    public int login(String aName, String aPassword) {
        User user = dao.selectOne(aName); //查询 user info
        if (user != null && user.getaPassword().equals(aPassword)) {
//            return "login successfully~! welcome : " + user.getaName();
            return 1;
        }
//        return "username or password error~!";
        return 0;
    }

    public Float queryBalance(String aName) {
        User user = dao.selectOne(aName);
        return user.getaBalance();
    }

    public void deposit(String aName, Float depositMoney) {
        User user = dao.selectOne(aName);
        user.setaBalance(user.getaBalance() + depositMoney);
        dao.update(user);
//        dao.commit();
    }

    public void withdrawal(String aName, Float withdrawalMoney) {
        User user = dao.selectOne(aName);
        if (user.getaBalance() > withdrawalMoney) {
            user.setaBalance(user.getaBalance() - withdrawalMoney);
            dao.update(user);
//            dao.commit();
        } else {
            System.out.println(aName + " balance cannot withdrawal");
        }
    }

    public void transfer(String outName, String intName, Float transferMoney) {
        User outUser = dao.selectOne(outName);
        if (outUser.getaBalance() > transferMoney) {
            User inUser = dao.selectOne(intName);
            if (inUser != null) {
                outUser.setaBalance(outUser.getaBalance() - transferMoney);
                inUser.setaBalance(inUser.getaBalance() + transferMoney);
                dao.update(outUser);
                dao.update(inUser);
//                this.commit();
            } else {
                System.out.println("transfer fail: target User not exist ");
            }

        } else {
            System.out.println(outName + " balance cannot withdrawal");
        }
    }


}
