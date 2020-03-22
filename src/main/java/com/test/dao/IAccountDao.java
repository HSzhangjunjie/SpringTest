package com.test.dao;


import com.test.domain.Account;

/**
 * @Description:
 * @author: HandSomeMaker
 * @date: 2020/3/22 14:43
 */
public interface IAccountDao {
    /**
     * 按照ID查询
     * @param id
     * @return
     */
    Account findAccountById(int id);

    /**
     * 按照姓名查询
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
