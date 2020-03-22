package com.test.demo;

import com.config.SpringConfiguration;
import com.test.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @author: HandSomeMaker
 * @date: 2020/3/20 22:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class ClientTest {
    @Autowired
    private IAccountService service;

    @Test
    public void Transfer() {
        service.transfer("aaa", "bbb", 100.0);
    }
}
