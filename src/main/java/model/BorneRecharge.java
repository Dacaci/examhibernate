package model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class BorneRecharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String etat;

    @Column(nullable=false)
    private BigDecimal tarifHoraire;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lieu_id")
    private LieuRecharge lieu;

    @OneToMany(mappedBy = "borne", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Reservation> reservations;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEtat() { return etat; }
    public void setEtat(String etat) { this.etat = etat; }
    public BigDecimal getTarifHoraire() { return tarifHoraire; }
    public void setTarifHoraire(BigDecimal tarifHoraire) { this.tarifHoraire = tarifHoraire; }
    public LieuRecharge getLieu() { return lieu; }
    public void setLieu(LieuRecharge lieu) { this.lieu = lieu; }
    public Set<Reservation> getReservations() { return reservations; }
    public void setReservations(Set<Reservation> reservations) { this.reservations = reservations; }

    @Override
    public String toString() {
        return "BorneRecharge{" +
                "id=" + id +
                ", etat='" + etat + '\'' +
                ", tarifHoraire=" + tarifHoraire +
                ", lieu=" + (lieu != null ? lieu.getNom() : null) +
                '}';
    }
} 