package de.miwoe.model;

import de.miwoe.enumerated.MyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by mwoelm on 11.07.17.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyEntity {

    @Id
    private UUID id;

    private String myBusinessString1;

    private String myBusinessString2;

    @Enumerated(EnumType.STRING)
    private MyStatus myStatus;



}
