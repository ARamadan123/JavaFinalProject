import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class user_login_frame extends JFrame implements ActionListener{
    // Login menu elements
    JLabel text = new JLabel("Please Login");
    Button login,quit;
    TextField username = new TextField("USERNAME"),password = new TextField("PASSWORD");
    // Class user elements
    User mainUser;
    ArrayList<User> other = new ArrayList<User>();
    // After login elements
    JFrame acc = new JFrame();
    JLabel uDisp = new JLabel();
    JLabel cDisp = new JLabel();
    JButton create_course_node = new JButton("Create course");
    JButton refresh = new JButton("Refresh Window");
    String[] columnLabel = {"Course Name", "Credit", "Grade"};


    public static void main(String[] args) throws FileNotFoundException{
        new user_login_frame();
    }
    public user_login_frame() throws FileNotFoundException {
        mainUser = new User();
        other = mainUser.getInfo(other);
        GridLayout grid = new GridLayout(1,0);
        JPanel panel = new JPanel();
        JPanel main = new JPanel(new FlowLayout(FlowLayout.CENTER,50,20));
        JPanel above = new JPanel(new FlowLayout(FlowLayout.CENTER,150,10));
        panel.setLayout(grid);
        login = new Button("LOGIN");
        quit = new Button("QUIT");
        panel.add(login);
        login.addActionListener(this);
        panel.add(quit);
        quit.addActionListener(this);
        main.add(panel);
        above.add(text);
        above.add(username);
        above.add(password);
        above.add(main);
        add(above);
        setVisible(true);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login) {
            loginButton();
        }
        else if(e.getSource() == quit) {
            System.exit(0);
        }
        else if(e.getSource() == create_course_node) {

        }
        else if(e.getSource() == refresh) {

        }
        
    }
    public static void wait(int ms){
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    public void loginButton(){
            String uField = username.getText();
            String pField = password.getText();
            for(int i = 0;i < other.size();i++) {
                User temp = other.get(i);
                if(temp.isLogin(uField, pField)) {
                    text.setText("Account exists");
                    mainUser = temp;
                    loggedInDesign();
                    i = other.size();
                }
                else {
                    text.setText("No user");
                } 
            }
    }
    public void loggedInDesign(){
        // designing JTable
        Object[][] data = {{"CourseName", "credit", "grades"}, {"CourseName", "credit", "grades"},{"CourseName", "credit", "grades"}};
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3;j++){
                if(j==0){data[i][j] = mainUser.myCourse.head.courseName;}
                if(j==1){data[i][j] = mainUser.myCourse.head.credit;}
                if(j==2){data[i][j] = mainUser.myCourse.head.grade;}
            }
            if(mainUser.myCourse.head.next == null) {break;}
            else {mainUser.myCourse.head = mainUser.myCourse.head.next;}
        }
        JTable courseTable = new JTable(data,columnLabel);
        //wait(2000);
        this.setVisible(false);
        acc.setVisible(true);
        uDisp.setText("Username: " + mainUser.username);
        cDisp.setText("Course Head: "+ mainUser.myCourse.head.courseName);
        GridLayout mainWinLay = new GridLayout(2,1);
        acc.setLayout(mainWinLay);
        JPanel panel1 = new JPanel(new GridLayout(1,2));
        JPanel panel2 = new JPanel();
        JPanel panel11 = new JPanel();
        JPanel panel12 = new JPanel(new GridLayout(2,1));
        panel1.add(panel11);
        panel1.add(panel12);
        panel11.add(uDisp);
        panel12.add(create_course_node);
        panel12.add(refresh);
        create_course_node.addActionListener(this);
        refresh.addActionListener(this);
        panel2.add(courseTable);
        acc.add(panel1);
        acc.add(panel2);
        acc.setSize(400, 400);
        acc.setLocationRelativeTo(null);
        acc.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
