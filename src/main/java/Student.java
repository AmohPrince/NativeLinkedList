public class Student {
    private Student next;
    private String name;
    private String id;
    private String email;
    private String address;
    private Course course;

    public Student(String name, String id, String email, String address, Course course) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.address = address;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }
}
