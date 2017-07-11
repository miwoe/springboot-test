package de.miwoe.service;

import de.miwoe.CommonTestConfig;
import de.miwoe.enumerated.MyStatus;
import de.miwoe.model.MyEntity;
import de.miwoe.repository.MyEntityRepository;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;


/**
 * Created by mwoelm on 11.07.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MyEntityServiceTest extends CommonTestConfig{

    @Autowired
    MyEntityService myEntityService;

    @Autowired
    MyEntityRepository myEntityRepository;

    @Autowired
    DataFactory dataFactory;

    @Test
    public void createEntity() throws Exception {
        MyEntity savedEntity = myEntityService.createEntity("foo", "bar");
        log.info(savedEntity.getId().toString()+savedEntity.getMyStatus().toString());
        assertTrue(savedEntity.getMyStatus().equals(MyStatus.PREPARATION));
    }

    @Test
    @Sql("preparedEntity.sql")
    public void i_can_activate_an_entity() {
        assertTrue(myEntityRepository.count() == 1l);
        MyEntity preparedEntity = myEntityRepository.findAll().get(0);
        myEntityService.activate(preparedEntity);
        MyEntity activatedEntity = myEntityRepository.findAll().get(0);
        assertTrue(activatedEntity.getMyStatus().equals(MyStatus.START));

    }

    @Test
    public void i_can_activate_an_entity_java() throws Exception {
        createEntity();
        assertTrue(myEntityRepository.count() == 1l);
        MyEntity preparedEntity = myEntityRepository.findAll().get(0);
        myEntityService.activate(preparedEntity);
        MyEntity activatedEntity = myEntityRepository.findAll().get(0);
        assertTrue(activatedEntity.getMyStatus().equals(MyStatus.START));

    }

}