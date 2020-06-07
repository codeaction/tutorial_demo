package org.codeaction.test;

import org.codeaction.config.SpringConfig;
import org.codeaction.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class MyTest {
    @Autowired
    private IAccountService accountService;

    @Test
    public void testTrans() {
        accountService.trans(1, 2, 100F);
    }
}
