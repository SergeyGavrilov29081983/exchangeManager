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
        if(history.isNew()) {
            entityManager.persist(history);
            return history;
        } else {
            return entityManager.merge(history);
        }
    }

    @Override
    public boolean delete(String secId) {
        return entityManager.createNamedQuery(History.DELETE)
                .setParameter("id", secId)
                .executeUpdate() != 0;
    }

    @Override
    public History get(String secId) {
        return entityManager.find(History.class, secId);
    }

    @Override
    public List<History> getAll() {
        return entityManager.createQuery(History.GET_ALL, History.class).getResultList();
    }
}
