package org.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.study.demo.dao.AccountDao;
import org.study.service.AccountInService;
@Service
public class AccountInServiceImpl implements AccountInService {
    @Autowired
    AccountDao accountDao;
    @Transactional(propagation = Propagation.NESTED,rollbackFor = Exception.class)
    public int inMoney(final String inUser,final double money){
       int count =   accountDao.upateForIn(inUser,money);
       return count;
    }
}
