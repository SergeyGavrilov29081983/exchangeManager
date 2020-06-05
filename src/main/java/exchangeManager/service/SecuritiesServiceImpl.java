package exchangeManager.service;

import exchangeManager.model.Securities;
import exchangeManager.repository.SecuritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecuritiesServiceImpl implements SecuritiesService {

    @Autowired
    SecuritiesRepository securitiesRepository;

    @Override
    public Securities save(Securities securities) {
        return securitiesRepository.save(securities);

    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Securities get(int id) {
        return null;
    }

    @Override
    public List<Securities> getAll() {
        return null;
    }
}
