package com.bawei.zhanglei.a0215greendao.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bawei.zhanglei.a0215greendao.entity.UserEntity;
import com.bawei.zhanglei.a0215greendao.entity.PresonEntity;

import com.bawei.zhanglei.a0215greendao.greendao.UserEntityDao;
import com.bawei.zhanglei.a0215greendao.greendao.PresonEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userEntityDaoConfig;
    private final DaoConfig presonEntityDaoConfig;

    private final UserEntityDao userEntityDao;
    private final PresonEntityDao presonEntityDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userEntityDaoConfig = daoConfigMap.get(UserEntityDao.class).clone();
        userEntityDaoConfig.initIdentityScope(type);

        presonEntityDaoConfig = daoConfigMap.get(PresonEntityDao.class).clone();
        presonEntityDaoConfig.initIdentityScope(type);

        userEntityDao = new UserEntityDao(userEntityDaoConfig, this);
        presonEntityDao = new PresonEntityDao(presonEntityDaoConfig, this);

        registerDao(UserEntity.class, userEntityDao);
        registerDao(PresonEntity.class, presonEntityDao);
    }
    
    public void clear() {
        userEntityDaoConfig.clearIdentityScope();
        presonEntityDaoConfig.clearIdentityScope();
    }

    public UserEntityDao getUserEntityDao() {
        return userEntityDao;
    }

    public PresonEntityDao getPresonEntityDao() {
        return presonEntityDao;
    }

}
