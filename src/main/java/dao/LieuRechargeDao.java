package dao;

import model.LieuRecharge;
import java.util.List;

public interface LieuRechargeDao {
    void create(LieuRecharge lieu);
    LieuRecharge findById(Long id);
    List<LieuRecharge> findAll();
    void update(LieuRecharge lieu);
    void delete(LieuRecharge lieu);
} 