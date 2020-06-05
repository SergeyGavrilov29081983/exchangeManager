package exchangeManager.service;

import exchangeManager.model.Securities;

import java.util.List;

public interface SecuritiesService {

    Securities save(Securities securities);

    boolean delete(int id);

    Securities get(int id);

    List<Securities> getAll();
}
