package exchangeManager.service;

import exchangeManager.model.History;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class XmlParserHistoryServiceImpl implements XmlParserHistoryService {

    @Override
    public List<History> xmlHistoryParser(String fileName) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        List<History> histories = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new FileInputStream(fileName));
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList dataItems = (NodeList) xPath
                .compile("/document/data[@id='history']/rows/row")
                .evaluate(doc.getDocumentElement(), XPathConstants.NODESET);

        int length = dataItems.getLength();
        for (int i = 0; i < length; i++) {
            Element startElement = (Element) dataItems.item(i);
            History history = new History();
            history.setSecId(getAttributeValue("SECID", startElement));
            history.setTradeDate(getAttributeValue("TRADEDATE", startElement));
            history.setNumTrades(parseDoubleOrNull(getAttributeValue("NUMTRADES", startElement)));
            history.setOpen(parseDoubleOrNull(getAttributeValue("OPEN", startElement)));
            history.setClose(parseDoubleOrNull(getAttributeValue("CLOSE", startElement)));
            histories.add(history);
        }
        return histories;
    }

    private static String getAttributeValue(String attrName, Element startElement) {
        return startElement.getAttribute(attrName);
    }

    public static double parseDoubleOrNull(String str) {
        try {
            return str != null ? Double.parseDouble(str) : 0;
        } catch (NumberFormatException ignored) {

        }
        return 0;
    }
}

