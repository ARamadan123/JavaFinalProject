public class CourseNode {
    String courseName;
    int credit;
    String grade;
    CourseNode next;

    public CourseNode() {
        this.courseName = "EMPTYFIELD";
        this.credit = 0;
        this.grade = "W";
        next = null;
    }
    public CourseNode(String NewcourseName, int newCredit, String newGrade, CourseNode newNext) {
        this.courseName = NewcourseName;
        this.credit = newCredit;
        this.grade = newGrade;
        next = newNext;
    }
    public void setNode(CourseNode newNode){this.next = newNode;}
    public CourseNode getNode(){return this.next;}
}
