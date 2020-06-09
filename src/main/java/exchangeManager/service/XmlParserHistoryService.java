package exchangeManager.service;

import exchangeManager.model.History;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

public interface XmlParserHistoryService {

    List<History> xmlHistoryParser(String fileName) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException;
}