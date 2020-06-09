package exchangeManager.service;

import exchangeManager.model.Securities;
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
public class XmlParserSecuritiesServiceImpl implements XmlParserSecuritiesService {

    @Override
    public List<Securities> xmlSecuritiesParser(String fileName) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        List<Securities> list = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new FileInputStream(fileName));
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList dataItems = (NodeList) xPath
                .compile("/document/data[@id='securities']/rows/row")
                .evaluate(doc.getDocumentElement(), XPathConstants.NODESET);

        int length = dataItems.getLength();
        for (int i = 0; i < length; i++) {
            Element startElement = (Element) dataItems.item(i);
            Securities securities = new Securities();
            securities.setId(Integer.parseInt(getAttributeValue("id", startElement)));
            securities.setSecid(getAttributeValue("secid", startElement));
            securities.setRegnumber(getAttributeValue("regnumber", startElement));
            securities.setRegnumber(getAttributeValue("name", startElement));
            securities.setEmitent_title(getAttributeValue("emitent_title", startElement));
            list.add(securities);
        }
        return list;
    }

    private static String getAttributeValue(String attrName, Element startElement) {
        return startElement.getAttribute(attrName);
    }
}



