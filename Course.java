import java.util.Scanner;

public class Course {
    CourseNode head;
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

    }
    public Course() {
        this.head = new CourseNode("head", 0, "headnode", null);
    }
    public void addNode(CourseNode node){
        node.next = new CourseNode("Math", 8, "B+", null);
    }
    public void customAddNode(CourseNode node) {
        while(node.next != null){
            node = node.next;
        }
        System.out.println("Enter course name: ");
        String Cname = input.nextLine();

        System.out.println("Enter course's credit worth (integer): ");
        int Ccredit = input.nextInt();
        
        System.out.println("Enter course grade: ");
        String Cgrade = input.next();
        
        node.next = new CourseNode(Cname, Ccredit, Cgrade, null);
    }
    public void removeNode(CourseNode node) {
        System.out.println("Enter index of node you want to remove(0 is start): ");
        CourseNode prev = null;
        int remove = input.nextInt();

        for(int i = 0; i < remove; i++) {
            if(i + 1 == remove) {
                prev = node;
            }
            else {prev = null;}
            node = node.next;
        }
        prev.next = node.next;
        node = null;

    }
}
