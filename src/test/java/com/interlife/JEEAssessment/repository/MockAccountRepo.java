package com.interlife.JEEAssessment.repository;

import com.interlife.JEEAssessment.entity.Account;
import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:kabelo@guruhut.com">Kabelo Mokgoro</a>
 */
@NoArgsConstructor
@Stateless(mappedName = "mockAccountRepo")
public class MockAccountRepo extends MockRepo<Account> implements AccountRepository {

    @Override
    public List<Account> findAccountByIdNumber(BigInteger idNumber) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Account> findAccountByAccountNumber(BigInteger accountNumber) {
        return Collections.EMPTY_LIST;
    }
}
