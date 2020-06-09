package exchangeManager.repository;

import exchangeManager.model.History;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HistoryRepositoryImpl implements HistoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public History save(History history) {
        if (history.isNew()) {
            entityManager.persist(history);
            return history;
        }
        return entityManager.merge(history);
    }

    @Override
    public boolean delete(String secId) {
        return entityManager.createNamedQuery(History.DELETE)
                .setParameter("secid", secId)
                .executeUpdate() != 0;
    }

    @Override
    public History get(String secId) {
        return entityManager.find(History.class, secId);
    }

    @Override
    public List<History> getAll() {
        return entityManager.createQuery("SELECT h FROM History h").getResultList();
    }
}
