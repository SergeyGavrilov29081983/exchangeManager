package exchangeManager.repository;

import exchangeManager.model.History;

import java.util.List;

public interface HistoryRepository {

    History save(History history);

    boolean delete(String secId);

    History get(String secId);

    List<History> getAll();
}
