package com.example.admin.pandatv.model.modelutils.pandalive_greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LOOK_TALK_BEAN".
*/
public class LookTalkBeanDao extends AbstractDao<LookTalkBean, Long> {

    public static final String TABLENAME = "LOOK_TALK_BEAN";

    /**
     * Properties of entity LookTalkBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Ed_content = new Property(1, String.class, "ed_content", false, "ED_CONTENT");
        public final static Property Time = new Property(2, String.class, "time", false, "TIME");
        public final static Property Floor = new Property(3, int.class, "floor", false, "FLOOR");
    };


    public LookTalkBeanDao(DaoConfig config) {
        super(config);
    }
    
    public LookTalkBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LOOK_TALK_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ED_CONTENT\" TEXT," + // 1: ed_content
                "\"TIME\" TEXT," + // 2: time
                "\"FLOOR\" INTEGER NOT NULL );"); // 3: floor
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOOK_TALK_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, LookTalkBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String ed_content = entity.getEd_content();
        if (ed_content != null) {
            stmt.bindString(2, ed_content);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(3, time);
        }
        stmt.bindLong(4, entity.getFloor());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, LookTalkBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String ed_content = entity.getEd_content();
        if (ed_content != null) {
            stmt.bindString(2, ed_content);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(3, time);
        }
        stmt.bindLong(4, entity.getFloor());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public LookTalkBean readEntity(Cursor cursor, int offset) {
        LookTalkBean entity = new LookTalkBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // ed_content
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // time
            cursor.getInt(offset + 3) // floor
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, LookTalkBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setEd_content(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTime(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFloor(cursor.getInt(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(LookTalkBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(LookTalkBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
