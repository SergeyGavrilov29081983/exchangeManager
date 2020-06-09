package exchangeManager.service;

import exchangeManager.model.Securities;
import exchangeManager.repository.SecuritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

@Service
public class SecuritiesServiceImpl implements SecuritiesService {

    private SecuritiesRepository securitiesRepository;
    private XmlParserSecuritiesService xmlParserSecuritiesService;

    @Autowired
    public void setSecuritiesRepository(SecuritiesRepository securitiesRepository) {
        this.securitiesRepository = securitiesRepository;
    }

    @Autowired
    public void setXmlParserSecuritiesService(XmlParserSecuritiesService xmlParserSecuritiesService) {
        this.xmlParserSecuritiesService = xmlParserSecuritiesService;
    }

    @Override
    public Securities save(Securities securities) {
        String name = securities.getName();
        if (name.matches("[ А-Яа-я0-9ёЁ]+")) {

            return securitiesRepository.save(securities);
        }
        return null;
    }

    @Override
    public void XmlImportToDb() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        List<Securities> securities = xmlParserSecuritiesService.xmlSecuritiesParser("xml/securities_1.xml");
        securities.forEach(s -> securitiesRepository.save(s));
    }

    @Override
    public boolean delete(int id) {
        return securitiesRepository.delete(id);
    }

    @Override
    public Securities get(int id) {
        return securitiesRepository.get(id);
    }

    @Override
    public List<Securities> getAll() {
        return securitiesRepository.getAll();
    }
}
