package dao;

import model.Utilisateur;
import java.util.List;

public interface UtilisateurDao {
    void create(Utilisateur utilisateur);
    Utilisateur findById(Long id);
    List<Utilisateur> findAll();
    void update(Utilisateur utilisateur);
    void delete(Utilisateur utilisateur);
} 