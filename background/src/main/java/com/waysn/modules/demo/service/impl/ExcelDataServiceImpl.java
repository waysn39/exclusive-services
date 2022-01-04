package com.waysn.modules.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.modules.demo.dao.ExcelDataDao;
import com.waysn.modules.demo.dto.ExcelDataDTO;
import com.waysn.modules.demo.entity.ExcelDataEntity;
import com.waysn.modules.demo.service.ExcelDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Excel导入演示
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
public class ExcelDataServiceImpl extends CrudServiceImpl<ExcelDataDao, ExcelDataEntity, ExcelDataDTO> implements ExcelDataService {

    @Override
    public QueryWrapper<ExcelDataEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<ExcelDataEntity> wrapper = new QueryWrapper<>();

        String realName = (String)params.get("realName");
        wrapper.like(StringUtils.isNotBlank(realName), "real_name", realName);

        String identity = (String)params.get("identity");
        wrapper.like(StringUtils.isNotBlank(identity), "identity", identity);

        return wrapper;
    }
}