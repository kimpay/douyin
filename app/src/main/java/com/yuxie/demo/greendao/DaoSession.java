package com.yuxie.demo.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.yuxie.demo.entity.SmsApi;
import com.yuxie.demo.entity.User;

import com.yuxie.demo.greendao.SmsApiDao;
import com.yuxie.demo.greendao.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig smsApiDaoConfig;
    private final DaoConfig userDaoConfig;

    private final SmsApiDao smsApiDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        smsApiDaoConfig = daoConfigMap.get(SmsApiDao.class).clone();
        smsApiDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        smsApiDao = new SmsApiDao(smsApiDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(SmsApi.class, smsApiDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        smsApiDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public SmsApiDao getSmsApiDao() {
        return smsApiDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}