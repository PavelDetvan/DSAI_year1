//package EX2;


public class LoginManager {
    private String[] usernames = {"jerry", "tom", "enrique"};
    private String[] passwords = {"123Welcome", "Qwerti", "Azertu2"};
    private int failedAttempts = 0;

    public boolean login(String userName, String password){
        if(getAttempts()==3){
            return false;
        }
        
        int index = -1;
            
        //checking if the username exists in the system and storing its index
        for(int i = 0;i<usernames.length;i++){
            if(usernames[i].equals(userName)){
                index=i;
                break;
            }
        }
        if(index!=-1 && password.equals(passwords[index])){
            return true;
        }
        else{
            failedAttempts++;
            return false;
        }
    }

    public int getAttempts(){
        return failedAttempts;
    }
}
