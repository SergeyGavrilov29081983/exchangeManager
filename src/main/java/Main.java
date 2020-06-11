import exchangeManager.model.Securities;
import exchangeManager.repository.GetInfoToTableRepository;
import exchangeManager.service.SecuritiesService;
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

        SecuritiesService securitiesService = context.getBean(SecuritiesService.class);
       /* securitiesService.XmlImportToDb();

        HistoryService historyService = context.getBean(HistoryService.class);
        historyService.XmlImportToDb();
*/
        Securities securities = context.getBean(Securities.class);
        securities.setId(1);
        securities.setName("сергей");
       /* if (securities.getName().matches("[ А-Яа-я0-9ёЁ]+")) {
            System.out.println(securitiesService.save(securities));
        } else {
            System.out.println("No valid name!!!");
        }*/
        System.out.println(securitiesService.save(securities));
        GetInfoToTableRepository repository = context.getBean(GetInfoToTableRepository.class);
        List<Securities> list  = securitiesService.getInfoForTable();
        System.out.println(list.get(0).toString());





    }

}



