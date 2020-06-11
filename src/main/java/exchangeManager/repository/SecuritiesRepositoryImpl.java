package exchangeManager.repository;

import exchangeManager.model.TableEntity;
import exchangeManager.model.Securities;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SecuritiesRepositoryImpl implements SecuritiesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Securities save(Securities securities) {
        if (securities.isNew()) {
            entityManager.persist(securities);
            return securities;
        } else {
            return entityManager.merge(securities);
        }
    }

    @Override
    public boolean delete(int id) {
        return entityManager.createNamedQuery(Securities.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public Securities get(int id) {
        return entityManager.find(Securities.class, id);
    }

    @Override
    public List<Securities> getAll() {
        return entityManager.createQuery("select s FROM Securities s").getResultList();
    }

    public List<String> getSecId() {
        return entityManager.createQuery("SELECT secid FROM Securities").getResultList();
    }

    public List<TableEntity> getDataToTable() {
        return entityManager.createNativeQuery("SELECT s.id, s.secid, s.regnumber, s.name, s.emitent_title, h.trade_date, h.numtrades, h.open, h.close FROM Securities s, History h", TableEntity.class).getResultList();
    }


}
