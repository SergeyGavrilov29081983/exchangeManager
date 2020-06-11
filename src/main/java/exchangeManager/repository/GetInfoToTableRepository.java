package exchangeManager.repository;

import exchangeManager.dto.TableEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GetInfoToTableRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<TableEntity> getInfoForTable() {
        return entityManager.createQuery("SELECT s,h FROM Securities s JOIN History h ON s.secid=h.secId ", TableEntity.class).getResultList();
    }


}
