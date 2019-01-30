package dao.mysql;

import Beans.Bonus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.impl.ServiceFactoryImpl;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlBonusDaoTest {


    private Bonus bonus;
    private Bonus testBonus;

    @Test
    void getById() {
        bonus = MySqlDaoFactory.getInstance().getBonusDao().getById(1);
        Bonus bonus4 = MySqlDaoFactory.getInstance().getBonusDao().getById(4);
        testBonus = new Bonus(1, "Pool");
        Bonus bonusExpected4 = new Bonus(4, "Cinema");
        assertEquals(testBonus, bonus);
        assertEquals(bonusExpected4, bonus4);
        assertNotNull(bonus);
    }

    @Test
    void getAll() {
        bonus = MySqlDaoFactory.getInstance().getBonusDao().getById(5);
        List<Bonus> bonusList = MySqlDaoFactory.getInstance().getBonusDao().getAll();
        assertTrue(bonusList.contains(bonus));
    }

    @Test
    void getByName() {
        testBonus = MySqlDaoFactory.getInstance().getBonusDao().getByName("Diving");
        assertThrows(RuntimeException.class,
                () -> {
                    ServiceFactoryImpl.getInstance().getBonusService().getById(testBonus.getId());
                });
        assertNull(testBonus);
    }
}