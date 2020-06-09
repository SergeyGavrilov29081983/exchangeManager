package exchangeManager.service;

import exchangeManager.model.Securities;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

public interface SecuritiesService {

    Securities save(Securities securities);

    void XmlImportToDb() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException;

    boolean delete(int id);

    Securities get(int id);

    List<Securities> getAll();
}
