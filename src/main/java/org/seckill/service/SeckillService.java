package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

public interface SeckillService {

    /**
     * 查询所有秒杀记录
     *
     * @return
     *          秒杀记录列表
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     *                  商品ID
     * @return
     *                  单个秒杀记录
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     *                  商品ID
     * @return
     *                  秒杀信息
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     *                  商品ID
     * @param userPhone
     *                  用户号码
     * @param md5
     *                  md5值
     * @return
     *                  秒杀结果
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException, RepeatKillException, SeckillCloseException;

    /**
     * 执行秒杀操作存储过程
     *
     * @param seckillId
     *                  商品ID
     * @param userPhone
     *                  用户号码
     * @param md5
     *                  md5值
     * @return
     *                  秒杀结果
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);

}
