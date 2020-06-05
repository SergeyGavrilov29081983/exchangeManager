package exchangeManager.util;


import exchangeManager.model.History;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class XmlparserHis {

    public static List<History> parseXMLfile(String fileName) throws XMLStreamException, FileNotFoundException {
        List<History> list = new ArrayList<>();
        History history = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
        while (reader.hasNext()) {
            XMLEvent xmlEvent = reader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                if (startElement.getName().getLocalPart().equals("row")) {
                    history = new History();
                    history.setSecId(getAttributeValue("SECID", startElement));
                    history.setTradeDate(getAttributeValue("TRADEDATE", startElement));
                    history.setNumTrades(parseDoubleOrNull(getAttributeValue("NUMTRADES", startElement)));
                    history.setOpen(parseDoubleOrNull(getAttributeValue("OPEN", startElement)));
                    history.setClose(parseDoubleOrNull(getAttributeValue("CLOSE", startElement)));
                    list.add(history);
                }

            }
        }
        return list;
    }

    private static String getAttributeValue(String attrName, StartElement startElement) {
        Attribute attribute = startElement.getAttributeByName(new QName(attrName));
        return attribute.getValue();
    }

    public static double parseDoubleOrNull(String str) {

        try {
            return str != null ? Double.parseDouble(str) : 0;
        } catch (NumberFormatException e) {

        }
        return 0;
    }
}



