package exchangeManager.util;


import exchangeManager.model.Securities;

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



public class XmlParserSec {

    public static List<Securities> parseXMLfile(String fileName) throws XMLStreamException, FileNotFoundException {
        List<Securities> list = new ArrayList<>();
        Securities securities = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
        while (reader.hasNext()) {
            XMLEvent xmlEvent = reader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                if (startElement.getName().getLocalPart().equals("row")) {
                    securities = new Securities();
                    securities.setId(Integer.parseInt(getAttributeValue("id", startElement)));
                    securities.setSecid(getAttributeValue("secid", startElement));
                    securities.setRegnumber(getAttributeValue("regnumber", startElement));
                    securities.setName(getAttributeValue("name", startElement));
                    securities.setEmitent_title(getAttributeValue("emitent_title", startElement));
                    list.add(securities);
                }
            }
        }
        return list;
    }

    private static String getAttributeValue(String attrName, StartElement startElement) {
        Attribute attribute = startElement.getAttributeByName(new QName(attrName));
        return attribute.getValue();
    }
}


