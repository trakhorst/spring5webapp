package guru.springframework.spring5webapp.domain;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Entity maakt een object van de class die oa gebruikt kan worden in Hibernate (JPA)
@Entity
public class Author {

    // Er wordt een Id value toegewezen aan de Entity voor de tabel
    // De Id value wordt met @generated value zo ingesteld dat deze vanzelf wordt gegenereerd en het type wordt door Hibernate gekozen (GenerationType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }



// Override gebruikt voor equals voor Hibernate implementatie (op basis van ID value)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Objects.equals(id, author.id);
    }

// Override gebruikt voor hashcode voor Hibernate implementatie (op basis van ID value)
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

// To string gebruikt voor een beter weergave van informatie uit het object
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
