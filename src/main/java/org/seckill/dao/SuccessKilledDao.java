package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {

    /**
     * 插入购买明细
     *
     * @param seckillId
     *                  商品ID
     * @param userPhone
     *                  用户号码
     * @return
     *                  插入结果
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled对象并携带秒杀产品对象
     *
     * @param seckillId
     *                  商品ID
     * @param userPhone
     *                  用户号码
     * @return
     *                  秒杀成功商品信息
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}
