package exchangeManager.repository;

import exchangeManager.model.TableEntity;
import exchangeManager.model.Securities;

import java.util.List;

public interface SecuritiesRepository {

    Securities save(Securities securities);

    boolean delete(int id);

    Securities get(int id);

    List<Securities> getAll();

    List<String> getSecId();

    List<TableEntity> getDataToTable();
}


