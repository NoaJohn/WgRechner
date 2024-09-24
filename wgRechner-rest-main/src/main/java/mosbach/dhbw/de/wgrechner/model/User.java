package mosbach.dhbw.de.wgrechner.model;


public class User {
    private static int userIdCounter; //Zeigt an wieviele user existieren

    private String userId;
    private String communeId;
    private String accountId;
    private String eMail;
    private String password;
    private String username;

    //Konstruktor
    public User(String username, String eMail, String password){
        this.userId = User.createUserId();
        this.communeId = null; // Beim erstellen immer nicht existent
        this.accountId = null; //WIP kommt noch
        this.username = username;
        this.eMail = eMail;
        this.password = password; //WIP verschlüsseln fehlt
    }

    //Methoden für Id Erstellung -> ++User... macht erst +1 dann zuweisen, also startet mit 1
    private static synchronized String createUserId(){
        return "user_"+ (++User.userIdCounter);
    }

    //getter und setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCommuneId() {
        return communeId;
    }

    public void setCommuneId(String communeId) {
        this.communeId = communeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}