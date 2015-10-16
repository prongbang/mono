
package com.mono.dao;

import com.mono.entity.Users;
import java.util.List;
import java.util.Map;

/**
 *
 * @author prongbang
 */
public interface UserDao {
    
    public List<Map<String, Object>> findUserAccount() throws Exception;
    
    public List<Users> findUsersAccount() throws Exception;
    
}
