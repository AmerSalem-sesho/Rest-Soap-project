import student.StudentService;
import javax.xml.ws.Endpoint;
public class Main {
    public static void main(String[] args) {
        System.out.println(
                "Service published at 8484...."
        );
        Endpoint.publish(
                "http://localhost:8484/student",
                new StudentService());


    }
}