package org.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.study.demo.dao.AccountDao;
import org.study.service.AccountOutService;
@Service
public class AccountOutServiceImpl implements AccountOutService {
    @Autowired
    AccountDao accountDao;
    @Transactional(propagation = Propagation.NESTED)
    public int outMoney(final String outUser,final double money) throws Exception {
       int count =  accountDao.updateForOut(outUser,money);
       int i = 0/0;
       return count;
    }
}
