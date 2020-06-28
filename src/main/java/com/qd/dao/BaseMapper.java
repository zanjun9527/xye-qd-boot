package com.qd.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BaseMapper<T> {
	
	/**
     * 插入一个实体（在数据库INSERT一条记录）
     * @param entity 实体对象
     */
    public abstract int insert(T object);
    
    /**
     * 插入一个实体（在数据库INSERT一条记录）
     * @param entity 实体对象
     */
    public abstract int insertSelective(T object);
    
    /**
     * 修改一个实体对象（UPDATE一条记录）
     * @param entity 实体对象
     * @return 修改的对象个数，正常情况=1
     */
    public abstract int updateById(T object);
    
    /**
     * 修改一个实体对象（UPDATE一条记录）
     * @param entity 实体对象
     * @return 修改的对象个数，正常情况=1
     */
    public abstract int updateByIdSelective(T object);
    
    public abstract int updateByIdWithBLOBs(T object);
    
    /**
     * 按主键删除记录
     * @param Id 主键对象
     * @return 删除的对象个数，正常情况=1
     */
    public abstract int deleteById(Integer id);
    
    public abstract int deleteById(Long id);
    
    /**
     * 按对象删除记录
     * @param object 对象
     * @return 删除的对象个数，正常情况=1
     */
    public abstract int deleteByObject(T object);

    /**
     * 按主键取记录
     * @param Id 主键值
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null
     */
    public abstract T selectById(Integer id);
    
    public abstract T selectById(Long id);
    
    
    
    /**
     * 按主键取记录
     * @param ids 主键值
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null
     */
    public abstract List<T> selectByIdIn(@Param("idstr") String ids);
    
    /**
     * 取全部记录
     * @return 全部记录实体对象的List
     */
    public abstract List selectAll();
    
    /**
     * 按条件查询记录
     * @param param 查询条件参数
     * @return 符合条件记录的实体对象的List
     */
    public abstract List<T> selectByObject(@Param("param") T object);
    
    /**
     * 批量删除
     * @param idstr
     */
	public abstract void deleteByIds(@Param("idstr") String idstr);
	
	
	
	/**
     * 批量删除--array
     * @param idstr
     */
	public abstract int deleteByIdsArray(@Param("idsArray") String[] idstr);

}
