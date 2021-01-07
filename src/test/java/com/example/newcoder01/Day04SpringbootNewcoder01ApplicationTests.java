package com.example.newcoder01;

import com.example.newcoder01.config.AlphaConfig;
import com.example.newcoder01.controller.AlphaController;
import com.example.newcoder01.dao.AlphaDao;
import com.example.newcoder01.dao.DiscussPostMapper;
import com.example.newcoder01.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Service;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Day04SpringbootNewcoder01Application.class)
class Day04SpringbootNewcoder01ApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeanCreationException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplicationContext(){
//        System.out.println(applicationContext);
//        boolean b = applicationContext.containsBean("alphaHibernateImpl");
//        System.out.println(b);
        AlphaDao alphaDao = (AlphaDao) applicationContext.getBean(AlphaDao.class);
        String select = alphaDao.select();

        AlphaDao alphaHibernateImpl = (AlphaDao) applicationContext.getBean("alphaHibernateImpl");
        String select1 = alphaHibernateImpl.select();

        System.out.println(select);
        System.out.println(select1);
        /*
         * @Author ayuan
         * @Description //TODO org.springframework.web.context.support.GenericWebApplicationContext@38b27cdc,
         *                  started on Sat Jan 02 18:46:13 CST 2021
         **/
    }
    @Test
    public void testService(){
        AlphaService bean = applicationContext.getBean(AlphaService.class);
        System.out.println(bean);


        AlphaService bean1 = applicationContext.getBean(AlphaService.class);
        System.out.println(bean1);
    }
    @Test
    public void testAlphaConfig(){
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @Autowired
    @Qualifier("alphaHibernateImpl")
    private AlphaDao alphaDao;
    @Autowired
    private AlphaService alphaService;
    @Autowired
    private AlphaConfig alphaConfig;
    @Test
    public void testDI(){
        System.out.println(alphaDao);
        System.out.println(alphaService);
        System.out.println(alphaConfig);
    }

    @Test
    public void testSys(){
        AlphaController controller = applicationContext.getBean(AlphaController.class);
        controller.executeSelect();
    }

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testCount(){
        int count = discussPostMapper.selectCount("");
        System.out.println(count);
    }

}
