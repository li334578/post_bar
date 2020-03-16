package com.zzgs.post_bar.Service.impl;

import com.zzgs.post_bar.Bean.Jurisdiction;
import com.zzgs.post_bar.Mapper.JurisdictionMapper;
import com.zzgs.post_bar.Service.JurisdictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:   Tang
 * Date:     2019/12/31 13:42
 * Description:
 */
@Service
public class JurisdictionServiceImpl implements JurisdictionService {

    @Autowired
    JurisdictionMapper jurisdictionMapper;

    /**
     * 查询所有资源的访问权限设置
     * @return 资源列表
     */
    @Override
    public List<Jurisdiction> findAll() {
        return jurisdictionMapper.findAll();
    }
}
