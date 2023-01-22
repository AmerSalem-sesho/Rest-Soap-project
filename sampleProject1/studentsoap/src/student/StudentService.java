package student;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
@WebService
public class StudentService {
    List<Student> studentList;

    @WebMethod
    public void loadStudents(){
        studentList = new ArrayList<Student>();
        studentList.add(new Student(1,"Amer Salem"));
    }
    @WebMethod
    public List<Student> getAllStudents(){
        return studentList;
    }
    @WebMethod
    public void addStudent(Student student){
        studentList.add(student);
    }
}
