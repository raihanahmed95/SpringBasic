package raihan.bs23.service;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raihan.bs23.enums.UserRole;
import raihan.bs23.encryptor.TextEncryptor;
import raihan.bs23.model.BaseResponse;
import raihan.bs23.model.UserEntity;
import raihan.bs23.model.UserPermission;
import raihan.bs23.repository.UserPermissionRepository;
import raihan.bs23.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raihan on 6/21/2017.
 */
@Service
@Transactional
public class RegistrationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPermissionRepository userPermissionRepository;

    @Autowired
    TextEncryptor textEncryptor;

    public BaseResponse doRegistration(UserEntity user) {
        UserEntity userEntity = new UserEntity();

        BaseResponse response = new BaseResponse();

        List<String> errors = new ArrayList<String>();

        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(textEncryptor.encrypt(user.getPassword()));

        try {
            userRepository.create(userEntity);
            this.insertUserRole(userEntity.getUsername(), UserRole.ROLE_USER.getCode());
            response.setResponseCode(100);
        } catch (HibernateException hbex) {

            hbex.printStackTrace();
            response.setResponseCode(101);
            errors.add(hbex.getMessage());

        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseCode(101);
            errors.add(ex.getMessage());
        }

        response.setErrors(errors);

        return response;
    }

    public void insertUserRole(String username, int roleId) {
        UserEntity userEntity = userRepository.getUserByUsername(username);

        UserPermission userPermissionEntity = new UserPermission();

        userPermissionEntity.setUser_id(userEntity.getId());

        userPermissionEntity.setUser_role_id(roleId);

        userPermissionRepository.create(userPermissionEntity);

    }

    public List<UserEntity> getAllUser() {
        List<UserEntity> userEntities = userRepository.getAll();
        List<UserEntity> users = new ArrayList<UserEntity>();

        for (UserEntity userEntity : userEntities) {
            UserEntity user = new UserEntity();
            user.setUsername(userEntity.getUsername());

            users.add(user);
        }

        return users;
    }

    public UserEntity getRegisteredUser(String userName) {

        UserEntity userEntity = userRepository.getUserByUsername(userName);

        UserEntity user = new UserEntity();
        user.setUsername(userEntity.getUsername());
        return user;
    }
    public boolean isInfoUsernameUnique(String username) {
        UserEntity userEntity = userRepository.getUserByUsername(username);
        return ( userEntity == null );
    }
}
