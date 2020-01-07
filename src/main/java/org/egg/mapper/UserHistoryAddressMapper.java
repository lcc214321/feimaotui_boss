package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.egg.model.DO.UserHistoryAddress;
import org.egg.model.DO.UserHistoryAddressExample;

import java.util.List;

@Mapper
public interface UserHistoryAddressMapper {
    int countByExample(UserHistoryAddressExample example);

    int deleteByExample(UserHistoryAddressExample example);

    int insert(UserHistoryAddress record);

    int insertSelective(UserHistoryAddress record);

    List<UserHistoryAddress> selectByExample(UserHistoryAddressExample example);

    int updateByExampleSelective(@Param("record") UserHistoryAddress record, @Param("example") UserHistoryAddressExample example);

    int updateByExample(@Param("record") UserHistoryAddress record, @Param("example") UserHistoryAddressExample example);
}