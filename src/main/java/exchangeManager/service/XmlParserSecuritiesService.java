package exchangeManager.service;

import exchangeManager.model.Securities;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

public interface XmlParserSecuritiesService {

    List<Securities> xmlSecuritiesParser(String fileName) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException;
}
