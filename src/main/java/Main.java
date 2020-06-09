import exchangeManager.service.HistoryService;
import exchangeManager.service.SecuritiesService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException, XMLStreamException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-app.xml");

        SecuritiesService securitiesService = context.getBean(SecuritiesService.class);
        securitiesService.XmlImportToDb();

        HistoryService historyService = context.getBean(HistoryService.class);
        historyService.XmlImportToDb();


    }

}



