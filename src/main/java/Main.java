import exchangeManager.model.History;
import exchangeManager.model.Securities;
import exchangeManager.repository.HistoryRepository;
import exchangeManager.repository.SecuritiesRepository;
import exchangeManager.service.HistoryServiceImpl;
import exchangeManager.service.SecuritiesService;
import exchangeManager.util.XmlParserSec;
import exchangeManager.util.XmlparserHis;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException, XMLStreamException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-app.xml");
        SecuritiesService impl = context.getBean(SecuritiesService.class);
        SecuritiesRepository impl2 = context.getBean("sec", SecuritiesRepository.class);
        List<Securities> list = XmlParserSec.parseXMLfile("xml/securities_1.xml");
        list.forEach(impl::save);
        HistoryServiceImpl service = context.getBean(HistoryServiceImpl.class);
        HistoryRepository historyRepository = context.getBean(HistoryRepository.class);
        List<History> list1 = XmlparserHis.parseXMLfile("xml/history_1.xml");

        /*for (History history : list1) {
            historyRepository.save(history);
        }*/
       /*List<String> list1 = service.getSecId();
       list1.forEach(System.out::println);*/

        //Вот Здесь когда код все работает,
        // а когда переношу в сервис HistoryserviceImpl
        // и запускаюсь из main валится


      /*  List<History> histories = XmlparserHis.parseXMLfile("xml/history_1.xml");
        //istoryServiceImpl impl1 = new HistoryServiceImpl();
        List<String> secIds = impl2.getSecId();
        for (int i = 0; i < histories.size(); i++) {
            String secid = histories.get(i).getSecId();
            for (int i1 = 0; i1 < secIds.size(); i1++) {
                History history = histories.get(i);
                if (secid.equalsIgnoreCase(secIds.get(i1))) {
                    historyRepository.save(history);
                }
            }
        }
*/
        //List<History> list2 = XmlparserHis.parseXMLfile()
        for (History history : list1) {
            service.save(history);
        }
        }

    }

