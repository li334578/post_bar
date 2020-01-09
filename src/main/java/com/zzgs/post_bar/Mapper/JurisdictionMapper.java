package com.zzgs.post_bar.Mapper;

import com.zzgs.post_bar.Bean.Jurisdiction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author:   Tang
 * Date:     2019/12/31 13:41
 * Description:
 */
@Mapper
public interface JurisdictionMapper {
    /**
     * 按照权重升序查询所有的资源访问权限
     * @return
     */
    @Select("SELECT * FROM jurisdiction ORDER BY sortnum ASC")
    List<Jurisdiction> findAll();
}
