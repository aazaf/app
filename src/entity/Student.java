package entity;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Mohamed Aazaf <aazafmax2@gmail.com> (www.aazafbiz.web.app)
 * @since 2023-04-29
 */

@Entity(name = "Student_Table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "student_sequence")
    @SequenceGenerator(
            name = "student_sequence",
            initialValue = 1,
            sequenceName = "st_seq",
            allocationSize = 1
    )
    @Column(name = "id")
    private long studentId;
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(
            name = "address_table",
            joinColumns = @JoinColumn(name = "student_id",
                    referencedColumnName = "id")
    )
    @GenericGenerator(name = "address_sequence", strategy = "sequence")
    @CollectionId(columns = @Column(name = "address_id"),
            generator = "address_sequence", type = @Type(type = "int")
    )
    private Collection<Address> addressList = new ArrayList<>();

    public Student() {
    }

    public Student(long studentId, String name, Collection<Address> addressList) {
        this.studentId = studentId;
        this.name = name;
        this.addressList = addressList;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Collection<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", addressList=" + addressList +
                '}';
    }
}
