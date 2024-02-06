package tech.ada.ecommerce.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity // JPA annotation that indicates that the class is a database entity
@Table // JPA annotation that indicates that the class is a database table
@Getter // Lombok annotation that automatically creates getters for all attributes
@Setter // Lombok annotation that automatically creates setters for all attributes
@EqualsAndHashCode // Lombok annotation that creates class Equals and HashCode
@AllArgsConstructor // Lombok annotation that creates class constructor with all arguments
@NoArgsConstructor // Lombok annotation that creates class constructor with no arguments
public class Usuario {

    @Id // indicates primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generates and increments id
    private Long id;
    private String login;
    private String password;
    private String name;
    private String address;
    private String cpf;
    private String city;
    private String uf;

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(address, user.address) && Objects.equals(cpf, user.cpf) && Objects.equals(city, user.city) && Objects.equals(uf, user.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/
}
