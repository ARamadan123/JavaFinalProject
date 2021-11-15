import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class User {
    public static ArrayList<User> userList = new ArrayList<User>();
    protected String username;
    protected String password;
    protected Course myCourse;
    public static void main(String[] args){

    }
    public User() {
        this.username = "EMPTY FIELD";
        this.password = "EMPTY FIELD";
        this.myCourse = new Course();

    }
    public User(String userName, String passWord){
        this.username = userName;
        this.password = passWord;
    }
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    public boolean isLogin(String userName, String passWord) { 
        /* this method checks if username and password 
        that were passed as paramters are equal to usernmame
         and password of particular user*/
        return ((this.username.equals(userName)) && (this.password.equals(passWord)));
    }
    public ArrayList<User> getInfo(ArrayList<User> list) throws FileNotFoundException{
        File info = new File("UserLoginInfo.txt");
        Scanner sc = new Scanner(info);
        sc.useDelimiter(",");
        int count = 0;
        while(sc.hasNextLine()) {
             
            String field = sc.nextLine();
            String arr[] = field.split(",", 2);
            User newUser = new User();

            for (String temp: arr) {
                if(count == 0) {
                    String field1 = temp;
                    newUser.setUsername(field1);
                }
                else {
                    String field2 = temp;
                    newUser.setPassword(field2);
                }
                count++;
            }
            list.add(newUser);
            count = 0;
        }
        sc.close();
        return list;

    }
    public void userLogin(){ // login menu
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter username: "); // enter username
        String name = input.nextLine();
        System.out.println("Please enter password: "); // enter password
        String pass = input.nextLine();
        boolean flag = false; 
        for(int i = 0; i < userList.size(); i++){ // traverses array list
            User temp = userList.get(i); // Assigns array list element to a temporary user
            if(temp.isLogin(name,pass)){ //calls isLogin()
                flag = true;
            }
        }
        if (flag){
            System.out.println("Succesfully Logged in");
        }
        else {
            System.out.println("User not found");
        }
    }
    
}
