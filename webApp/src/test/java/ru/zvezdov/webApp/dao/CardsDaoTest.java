package ru.zvezdov.webApp.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.zvezdov.webApp.model.Card;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author Dmitry Zvezdov
 *         15.07.17.
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:dispatcher-servlet.xml",
        "classpath:application-context.xml",
        "classpath:database.xml"})
public class CardsDaoTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    CardsDao cardsDao;

    @Test
    public void sampleTest() {
//        CardsDao cardsDao = applicationContext.getBean("cardsDao", CardsDao.class);
//        Assert.assertNotNull(cardsDao);
//        List<Card> cardsByGrade = cardsDao.getCardsByGrade(1);
//        Assert.assertEquals(1, cardsByGrade.get(0).getGrade());

        List<Card> list = new LinkedList<>();
        list.add(new Card(0, "a", "b", 1, ""));
        CardsDao mockedDao = mock(CardsDao.class);
        when(mockedDao.getAllCards()).thenReturn(list);

        System.out.println(mockedDao.getAllCards().get(0).getWord());

//        verify(mockedDao, times(3)).getAllCards();
//        sampleBean = (SampleBean) applicationContext.getBean("sampleBean");
//        Assert.assertNotNull(sampleBean);
//
//        Assert.assertEquals(sampleBean.getNumber(), 666);
//        Assert.assertEquals(sampleBean.getStringValue(), "postConstructValue");
    }
}
