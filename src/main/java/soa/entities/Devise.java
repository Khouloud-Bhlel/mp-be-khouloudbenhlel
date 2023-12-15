package soa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Devise {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String symbole;
    @OneToMany(mappedBy = "devise" ,cascade = {CascadeType.REMOVE  , CascadeType.MERGE , CascadeType.PERSIST})

    private Collection<Facture> factures = new ArrayList<Facture>();

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Devise(Long id, String code, String symbole) {
        this.id = id;
        this.code=code;
        this.symbole=symbole;

    }
    public Devise(Long id) {
        this.id = id;
    }
    public Devise() {


    }


    @Override
    public String toString() {
        return "Devise{" +
                "id=" + id +
                ", code=" + code +
                ", symbole='" + symbole+
                '}';
    }
}
