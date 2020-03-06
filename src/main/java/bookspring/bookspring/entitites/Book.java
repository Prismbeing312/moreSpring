package bookspring.bookspring.entitites;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Publish_Date", nullable = false)
    private LocalDate publishDate;

    @ManyToOne
    @JoinColumn(name = "Author_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    @ManyToMany(mappedBy = "Books")
    private List<Customer> customers = new ArrayList<>();
}
