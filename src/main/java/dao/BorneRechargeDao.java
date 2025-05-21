package dao;

import model.BorneRecharge;
import java.util.List;

public interface BorneRechargeDao {
    void create(BorneRecharge borne);
    BorneRecharge findById(Long id);
    List<BorneRecharge> findAll();
    void update(BorneRecharge borne);
    void delete(BorneRecharge borne);
} 