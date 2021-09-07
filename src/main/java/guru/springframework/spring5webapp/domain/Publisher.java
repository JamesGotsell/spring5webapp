package guru.springframework.spring5webapp.domain;


import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publisher_id;

    private String address_1_line;
    private String city;
    private String state;
    private String zip;
    private String name;

    @OneToMany
    private Set<Book> books = new HashSet<>();
    public Publisher() {
    }

    public Publisher(String address_1_line, String city, String state, String zip, String name) {

        this.address_1_line = address_1_line;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.name = name;
    }

    public Long getId() {
        return publisher_id;
    }

    public void setId(Long id) {
        this.publisher_id = publisher_id;
    }

    public String getAddress_1_line() {
        return address_1_line;
    }

    public void setAddress_1_line(String address_1_line) {
        this.address_1_line = address_1_line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisher_id=" + publisher_id +
                ", address_1_line='" + address_1_line + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return publisher_id != null ? publisher_id.equals(publisher.publisher_id) : publisher.publisher_id == null;
    }

    @Override
    public int hashCode() {
        return publisher_id != null ? publisher_id.hashCode() : 0;
    }

    public void setName(String name) {
        this.name = name;
    }
}
