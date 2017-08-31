package com.example.admin.pandatv.model.modelutils.pandalive_greendao;

import android.content.Context;

/**
 * Created by LiYRong on 2017/8/31.
 */

public class DaoUtils {

    private static DaoUtils daoUtils;
    private  DaoMaster.DevOpenHelper devOpenHelper;


    private DaoUtils(Context context) {
        devOpenHelper = new DaoMaster.DevOpenHelper(context, "Students.db");
    }

    public LookTalkBeanDao getdao(){
        return new DaoMaster(devOpenHelper.getReadableDb()).newSession().getLookTalkBeanDao();
    }

    public static DaoUtils getDaoUtils(Context context){

        if (daoUtils == null) {
            synchronized (DaoUtils.class) {
                if (daoUtils == null) {
                    daoUtils = new DaoUtils(context);
                }
            }
        }

        return daoUtils;
    }


}
