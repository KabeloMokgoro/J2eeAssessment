package com.interlife.JEEAssessment.test;

import com.interlife.JEEAssessment.repository.AccountRepository;
import org.junit.Before;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * @author <a href="mailto:kabelo@guruhut.com">Kabelo Mokgoro</a>
 */

public abstract class AbstractTest {

    Context context;
    AccountRepository accRepo;

    @Before
    public void setUp() {
        try {
            Properties properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.cosnaming.CNCtxFactory");
            properties.setProperty(Context.PROVIDER_URL, "http://localhost:8080/JEEAssessment-1.0-SNAPSHOT");

            context = new InitialContext(properties);
            accRepo = (AccountRepository)context.lookup("mockAccountRepo");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }


}
