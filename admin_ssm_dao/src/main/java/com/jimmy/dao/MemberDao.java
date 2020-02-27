package com.jimmy.dao;

import com.jimmy.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    @Select("select * from member_ where id=#{id}")
    Member findById(int id);
}
