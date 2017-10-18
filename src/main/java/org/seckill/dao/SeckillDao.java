package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {

    /**
     * 减库存
     *
     * @param seckillId
     *                  商品ID
     * @param killTime
     *                  秒杀时间
     * @return
     *                  减库存结果
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     *
     * @param seckillId
     *                  商品ID
     * @return
     *                  商品信息
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param offset
     *                  偏移量
     * @param limit
     *                  查询条数限制
     * @return
     *                  商品列表
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     *
     * @param paramMap
     *                  参数
     */
    void killByProcedure(Map<String, Object> paramMap);

}
