package org.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.study.service.AccountInService;
import org.study.service.AccountOutService;
import org.study.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountInService accountInService;
    @Autowired
    AccountOutService accountOutService;
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor = Exception.class)
    public void transfer(final String outUser,final String inUser,final double money) throws Exception {
        if(inUser.equals(outUser)){
            throw new Exception("转账用户不能是自己");
        }
        int in = accountInService.inMoney(inUser,money);
        try{
            int out = accountOutService.outMoney(outUser,money);
        }catch (Exception e){
            System.out.println("异常分支执行");
            throw new Exception(e.getMessage());
        }
//        int z = 0/0;
    }
}
