package org.study.service;

public interface AccountService {
    void transfer(String outUser,String inUser,double money) throws Exception;
}
