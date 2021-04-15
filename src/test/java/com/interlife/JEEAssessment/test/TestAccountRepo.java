package com.interlife.JEEAssessment.test;

import com.interlife.JEEAssessment.generated.Statements;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static org.junit.Assert.assertNotNull;

/**
 * @author <a href="mailto:kabelo@guruhut.com">Kabelo Mokgoro</a>
 */

public class TestAccountRepo extends AbstractTest {

    @Test(expected = AssertionError.class)
    public void testGetAll() {
        assertNotNull(accRepo);
    }

    @Test
    public void testReadFile() {
        try {
            File file = new File("src\\test\\resources\\StatementSingle.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Statements.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Statements statements = (Statements) jaxbUnmarshaller.unmarshal(file);
            System.out.println(statements.getStatement().get(0).getAccount().getAccountHolderName());

            assertNotNull(statements.getStatement().get(0));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
