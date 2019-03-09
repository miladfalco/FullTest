package layout.milad.com.testbestfull.storage;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import layout.milad.com.testbestfull.models.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAllUser();

    @Insert
    void insertUser(User user);

    @Insert
    void insertOneUser(DataModelUser dataModelUsers);

    @Insert
    void insertListUser(List<DataModelUser> dataModelUsers);

    @Query("SELECT * FROM user")
    List<DataModelUser> getAllOneUser();



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllUser(List<User> listUser);
}
