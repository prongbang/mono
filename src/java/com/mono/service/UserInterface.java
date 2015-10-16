
package com.mono.service;

import com.mono.entity.Users;
import java.util.List;
import java.util.Map;

/**
 *
 * @author prongbang
 */
public interface UserInterface {
     
    public List<Map<String, Object>> findUserAccount() throws Exception;
    
    public List<Users> findUsersAccount() throws Exception;
    
}
