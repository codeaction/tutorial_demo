package org.codeaction.test;

import org.codeaction.bean.Account;
import org.codeaction.config.RootConfig;
import org.codeaction.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class SpringTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testSpring() {
        accountService.findAll();
    }

}
