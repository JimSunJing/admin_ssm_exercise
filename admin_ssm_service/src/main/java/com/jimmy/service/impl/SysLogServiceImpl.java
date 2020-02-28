package com.jimmy.service.impl;

import com.jimmy.dao.SysLogDao;
import com.jimmy.domain.SysLog;
import com.jimmy.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
