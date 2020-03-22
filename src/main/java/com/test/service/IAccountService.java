package com.test.service;


import com.test.domain.Account;

/**
 * @Description: 账户业务层接口
 * @author: HandSomeMaker
 * @date: 2020/3/22 14:48
 */
public interface IAccountService {
    /**
     * 根据ID查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(int id);

    /**
     * 转账
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName, String targetName, Double money);
}
