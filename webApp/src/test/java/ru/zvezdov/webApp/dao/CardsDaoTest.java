package ru.zvezdov.webApp.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
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

    @Test
    @Sql("/sql/create-db.sql")
    public void test_get_all_cards_from_empty_db() {
        Assert.assertTrue(cardsDao.getAllCards().isEmpty());
    }

    @Test
    @Sql({"/sql/create-db.sql", "/sql/insert-data.sql"})
    public void test_get_all_cards_from_not_empty_db() {
        Assert.assertFalse(cardsDao.getAllCards().isEmpty());
    }

    @Test
    @Sql({"/sql/create-db.sql", "/sql/insert-data.sql"})
    public void test_get_cards_by_grade_return_list_with_correct_grades() {
        cardsDao.getCardsByGrade(1).forEach((a) -> {Assert.assertEquals(1, a.getGrade());});
        cardsDao.getCardsByGrade(2).forEach((a) -> {Assert.assertEquals(2, a.getGrade());});
        cardsDao.getCardsByGrade(3).forEach((a) -> {Assert.assertEquals(3, a.getGrade());});
    }

    @Test
    public void test_delete_absent_card() {
        cardsDao.deleteCard(new Card(100, "", "", 1, ""));
    }
}
