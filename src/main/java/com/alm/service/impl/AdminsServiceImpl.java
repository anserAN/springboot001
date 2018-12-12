package com.alm.service.impl;

import com.alm.entity.Admins;
import com.alm.dao.AdminsMapper;
import com.alm.service.AdminsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anluming
 * @since 2018-12-01
 */
@Service
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins> implements AdminsService {
	
}
