package s01.AtmSyst;

import java.io.Serializable;

// connector        ----        javaBean
public class User implements Serializable{
    private static final long serialVersionUID = -8760146539670963759L;
    private String aName;
    private String aPassword;
    private Float aBalance;


    public User() {}

    public User(String aName, String aPassword, Float aBalance) {
        this.aName = aName;
        this.aPassword = aPassword;
        this.aBalance = aBalance;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public Float getaBalance() {
        return aBalance;
    }

    public void setaBalance(Float aBalance) {
        this.aBalance = aBalance;
    }
}
