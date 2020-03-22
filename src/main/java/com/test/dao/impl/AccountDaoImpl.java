package com.test.dao.impl;

import com.test.dao.IAccountDao;
import com.test.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @author: HandSomeMaker
 * @date: 2020/3/22 15:18
 */
@Repository
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate template;

    @Override
    public Account findAccountById(int id) {
        List<Account> accounts = template.query("SELECT * FROM account WHERE id=?", new BeanPropertyRowMapper<>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts = template.query("SELECT * FROM account WHERE name=?", new BeanPropertyRowMapper<>(Account.class), name);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        template.update("UPDATE account SET name=?,money=? WHERE id=?", account.getName(), account.getMoney(), account.getId());
    }
}
