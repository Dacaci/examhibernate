package model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class LieuRecharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nom;

    @Column(nullable=false)
    private String adresse;

    @OneToMany(mappedBy = "lieu", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<BorneRecharge> bornes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public Set<BorneRecharge> getBornes() { return bornes; }
    public void setBornes(Set<BorneRecharge> bornes) { this.bornes = bornes; }

    @Override
    public String toString() {
        return "LieuRecharge{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
} 