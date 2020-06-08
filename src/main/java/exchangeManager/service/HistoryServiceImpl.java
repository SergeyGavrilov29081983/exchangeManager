package exchangeManager.service;

import exchangeManager.model.History;
import exchangeManager.repository.HistoryRepository;
import exchangeManager.repository.SecuritiesRepository;
import exchangeManager.repository.SecuritiesRepositoryImpl;
import exchangeManager.util.XmlparserHis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;



    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public History save(History history) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        List<History> histories = XmlparserHis.parseXMLfile("xml/history_1.xml");
        SecuritiesRepository impl = new SecuritiesRepositoryImpl();
        List<String> secIds = impl.getSecId();
        for (int i = 0; i < histories.size(); i++) {
            String secid = histories.get(i).getSecId();
            for (int i1 = 0; i1 < secIds.size(); i1++) {
                history = histories.get(i);
                if (secid.equalsIgnoreCase(secIds.get(i1))) {
                    historyRepository.save(history);
                }
            }
        }
        return history;
    }

    @Override
    public boolean delete(String secId) {
        return false;
    }

    @Override
    public History get(String secId) {
        return null;
    }

    @Override
    public List<History> getAll() {
        return null;
    }

}
