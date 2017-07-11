package de.miwoe.service;

import de.miwoe.enumerated.MyStatus;
import de.miwoe.model.MyEntity;
import de.miwoe.repository.MyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.UUID;

/**
 * Created by mwoelm on 11.07.17.
 */
@Service
public class MyEntityService {

    @Autowired
    MyEntityRepository myEntityRepository;

    public MyEntity createEntity(String b1, String b2) {
        MyEntity myEntity = MyEntity.builder()
                .myBusinessString1(b1)
                .myBusinessString2(b2)
                .id(UUID.randomUUID())
                .myStatus(MyStatus.PREPARATION)
                .build();
        return myEntityRepository.save(myEntity);

    }

    public void activate(MyEntity myEntity) {
        myEntity.setMyStatus(MyStatus.START);
        myEntityRepository.save(myEntity);
    }
}
