package com.test.service.impl;

import com.test.dao.IAccountDao;
import com.test.domain.Account;
import com.test.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @author: HandSomeMaker
 * @date: 2020/3/22 14:57
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao dao;

    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }

    @Override
    public Account findAccountById(int id) {
        return dao.findAccountById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void transfer(String sourceName, String targetName, Double money) {
        //根据名称查询出转出账户
        Account source = dao.findAccountByName(sourceName);
        //根据名称查询转入账户
        Account target = dao.findAccountByName(targetName);
        //转出用户减钱
        source.setMoney(source.getMoney() - money);
        //转入用户加钱
        target.setMoney(target.getMoney() + money);
        //更新转出账户
        dao.updateAccount(source);
        //更新转入账户
        dao.updateAccount(target);
    }
}
