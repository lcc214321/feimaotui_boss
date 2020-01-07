package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.egg.model.DO.BossUser;
import org.egg.model.DO.BossUserExample;

import java.util.List;

@Mapper
public interface BossUserDAO {
    int countByExample(BossUserExample example);

    int deleteByExample(BossUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BossUser record);

    int insertSelective(BossUser record);

    List<BossUser> selectByExample(BossUserExample example);

    BossUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BossUser record, @Param("example") BossUserExample example);

    int updateByExample(@Param("record") BossUser record, @Param("example") BossUserExample example);

    int updateByPrimaryKeySelective(BossUser record);

    int updateByPrimaryKey(BossUser record);
}