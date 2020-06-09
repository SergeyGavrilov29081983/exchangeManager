package exchangeManager.service;

import exchangeManager.model.History;
import exchangeManager.repository.HistoryRepository;
import exchangeManager.repository.SecuritiesRepository;

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

    private SecuritiesRepository securitiesRepository;
    private HistoryRepository historyRepository;
    private XmlParserHistoryService xmlParserHistoryService;

    @Autowired
    public void setRepository(SecuritiesRepository repository) {
        this.securitiesRepository = repository;
    }

    @Autowired
    public void setHistoryRepository(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Autowired
    public void setXmlParserHistoryService(XmlParserHistoryService xmlParserHistoryService) {
        this.xmlParserHistoryService = xmlParserHistoryService;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public History save(History history) {
        return historyRepository.save(history);
    }

    @Override
    public void XmlImportToDb() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {

        List<History> histories = xmlParserHistoryService.xmlHistoryParser("xml/history_1.xml");
        List<String> secIds = securitiesRepository.getSecId();

        for (int i = 0; i < histories.size(); i++) {
            String secid = histories.get(i).getSecId();
            for (int k = 0; k < secIds.size(); k++) {
                History history = histories.get(i);
                if (secid.equalsIgnoreCase(secIds.get(k))) {
                    historyRepository.save(history);
                }
            }
        }
    }

    @Override
    public boolean delete(String secId) {
        return historyRepository.delete(secId);
    }

    @Override
    public History get(String secId) {
        return historyRepository.get(secId);
    }

    @Override
    public List<History> getAll() {
        return historyRepository.getAll();
    }

}
