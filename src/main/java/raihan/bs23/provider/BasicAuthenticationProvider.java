package raihan.bs23.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import raihan.bs23.encryptor.TextEncryptor;
import raihan.bs23.enums.UserRole;
import raihan.bs23.model.UserEntity;
import raihan.bs23.model.UserPermission;
import raihan.bs23.repository.UserPermissionRepository;
import raihan.bs23.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raihan on 6/23/2017.
 */
@Component
@Transactional
public class BasicAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TextEncryptor textEncryptor;

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
        if(authentication.getName() != null && authentication.getCredentials() != null) {
            try {
                UserEntity userEntity = userRepository.getUserByUsername(authentication.getName());

                if(userEntity != null && textEncryptor.isEqual(userEntity.getPassword() , authentication.getCredentials().toString())){
                    UserPermission userPermission = userPermissionRepository.getRoleById(userEntity.getId());
                    AUTHORITIES.add(new SimpleGrantedAuthority(UserRole.getNameByValue(userPermission.getUser_role_id())));
                    return new UsernamePasswordAuthenticationToken(userEntity,"", AUTHORITIES);
                }else{
                    throw  new UserStatusException("User credential does not match");
                }
            }catch (Exception e){
                e.printStackTrace();
                throw new UserStatusException("Invalid Attempt");
            }
        }else{
            throw new UserStatusException("Invalid Attemp");
        }
    }

    public boolean supports(Class<?> authentication){
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    class UserStatusException extends AccountStatusException{
        public UserStatusException(String msg){super(msg);}
    }

}
