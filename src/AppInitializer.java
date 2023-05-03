import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;

/**
 * @author Mohamed Aazaf <aazafmax2@gmail.com> (www.aazafbiz.web.app)
 * @since 2023-04-29
 */
public class AppInitializer {

    public static void main(String[] args) {
//        Address address1 = new Address("SriLanka", "Kandy", 1456);
//        Address address2 = new Address("SriLanka", "colombo", 1200);
//        Address address3 = new Address("SriLanka", "Maali", 1244);
//        Student student = new Student();
//
//        student.setName("Namal");
//        student.setAddressList(Arrays.asList(address1,address2,address3));
//        saveStudent(student);
        findStudent(1);
    }

    private static void saveStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Long savedId = (Long) session.save(student);
            transaction.commit();
            System.out.println("student primary key " + savedId);
        }
    }

    private static void findStudent(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student selectedStudent = session.find(Student.class, id);
            System.out.println(selectedStudent);
            System.out.println("================");
            selectedStudent.getAddressList().stream()
                    .forEach(e -> System.out.println(e.toString()));
            System.out.println("================");
        }
    }
}
