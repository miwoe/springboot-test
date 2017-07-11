package de.miwoe;

import de.miwoe.configuration.DataConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by mwoelm on 11.07.17.
 */
@Configuration
@ContextConfiguration(classes = {SpringbootTestApplication.class, DataConfiguration.class})
public class CommonTestConfig {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());


}
