package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService service;

    @Test
    public void getSeckillList() throws Exception {

        List<Seckill> list = service.getSeckillList();
        logger.info("list = {}", list);

    }

    @Test
    public void getById() throws Exception {

        long id = 1000L;
        Seckill seckill = service.getById(id);
        logger.info("seckill = {}", seckill);

    }

    @Test
    public void seckillLogic() throws Exception {

        long id = 1000L;
        Exposer exposer = service.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer = {}", exposer);
            long phone = 18374093482L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = service.executeSeckill(id, phone, md5);
                logger.info("result = {}", execution);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.warn("exposer = {}", exposer);
        }

    }

    @Test
    public void executeSeckillProcedure() {

        long seckillId = 1001;
        long phone = 18392038472L;

        Exposer exposer = service.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = service.executeSeckillProcedure(seckillId, phone, md5);
            logger.info(execution.getStateInfo());
        }


    }

}