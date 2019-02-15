package com.bawei.zhanglei.a0215greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bawei.zhanglei.a0215greendao.entity.UserEntity;
import com.bawei.zhanglei.a0215greendao.greendao.UserEntityDao;
import com.bawei.zhanglei.a0215greendao.utils.GreenDaoUtils;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
    /**
     *
     * 添加
     * @param view
     */
    public void add(View view){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("张三");
        UserEntityDao userEntityDao = GreenDaoUtils.getInstance().getDaoSession().getUserEntityDao();
        userEntityDao.insert(userEntity);
    }
    /**
     *
     *删除
     * @param view
     *
     */

    public void delete(View view){
        UserEntityDao userEntityDao = GreenDaoUtils.getInstance().getDaoSession().getUserEntityDao();
       //删除全部
      //  userEntityDao.deleteAll();
       // Toast.makeText(Main2Activity.this,"删除全部成功",Toast.LENGTH_SHORT).show();
        //根据条件删除
       List<UserEntity> userEntities = userEntityDao.loadAll();
        for (UserEntity userEntity : userEntities) {
            if(2==userEntity.getId()){
                userEntityDao.delete(userEntity);
                Toast.makeText(Main2Activity.this,"条件删除成功",Toast.LENGTH_SHORT).show();
            }

        }
    }

    /**
     *更新 修改
     * @param view
     */
    public void update(View view){
        UserEntityDao userEntityDao = GreenDaoUtils.getInstance().getDaoSession().getUserEntityDao();
        List<UserEntity> userEntities = userEntityDao.loadAll();
        for (UserEntity userEntity : userEntities) {
           if(4==userEntity.getId()){
               userEntity.setName("贾玲");
               userEntityDao.update(userEntity);
               Toast.makeText(Main2Activity.this,"修改"+userEntity.getName()+"成功",Toast.LENGTH_SHORT).show();
           }
        }
    }
    /**
     *查询
     * @param view
     *
     */
    public void query(View view){
        //获取到想要查询的表UserEntityDao
        UserEntityDao userEntityDao = GreenDaoUtils.getInstance().getDaoSession().getUserEntityDao();

        //第一种方式
        List<UserEntity> userEntities = userEntityDao.loadAll();
        Toast.makeText(Main2Activity.this,"查询到的数据共有"+userEntities.size()+"条",Toast.LENGTH_SHORT).show();
        for (UserEntity userEntity : userEntities) {
            Toast.makeText(Main2Activity.this,"名字为:"+userEntity.getName(),Toast.LENGTH_SHORT).show();
        }

        //第二种 根据条件查询数据
       List<UserEntity> tiaos = userEntityDao.queryRaw("where _id=? and name =?",  "2","张三");
        Toast.makeText(Main2Activity.this,"条件查询到的数据共有"+tiaos.size()+"条",Toast.LENGTH_SHORT).show();
        //第三种 链式条件查询
       QueryBuilder<UserEntity> queryBuilder = GreenDaoUtils.getInstance().getDaoSession()
                .queryBuilder(UserEntity.class)//要查询的表
                .where(UserEntityDao.Properties.Id.eq("1"))//查询的条件
                .orderDesc(UserEntityDao.Properties.Id);//根据id降序
        List<UserEntity> list = queryBuilder.list();
        Toast.makeText(Main2Activity.this,"链式条件查询到的数据共有"+tiaos.size()+"条",Toast.LENGTH_SHORT).show();


    }
}
