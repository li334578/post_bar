package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.Jurisdiction;

import java.util.List;

/**
 * Author:   Tang
 * Date:     2019/12/31 13:41
 * Description:
 */
public interface JurisdictionService {
    /**
     * 查询所有资源的访问权限设置
     * @return
     */
    List<Jurisdiction> findAll();
}
