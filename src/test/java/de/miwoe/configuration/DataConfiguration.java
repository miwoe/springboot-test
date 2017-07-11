package de.miwoe.configuration;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mwoelm on 11.07.17.
 */
@Configuration
public class DataConfiguration {

    @Bean
    DataFactory getDataFactory() {
        return new DataFactory();
    }
}
