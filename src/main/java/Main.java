import exchangeManager.model.History;
import exchangeManager.repository.HistoryRepository;
import exchangeManager.util.XmlparserHis;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-app.xml");
        /*SecuritiesService impl = context.getBean(SecuritiesService.class);
        List<Securities> list = XmlParserSec.parseXMLfile("xml/securities_1.xml");
        list.forEach(impl::save);*/
        HistoryRepository historyRepository = context.getBean(HistoryRepository.class);
        List<History> list1 = XmlparserHis.parseXMLfile("xml/history_1.xml");
        list1.forEach(historyRepository::save);

    }
}
