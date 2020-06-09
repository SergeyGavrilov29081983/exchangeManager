package exchangeManager.service;

import exchangeManager.model.History;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

public interface HistoryService {

        History save(History history);

        void XmlImportToDb() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException;

        boolean delete(String secId);

        History get(String secId);

        List<History> getAll();

}
