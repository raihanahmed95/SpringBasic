package raihan.bs23.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import raihan.bs23.model.UserPermission;

/**
 * Created by Raihan on 6/21/2017.
 */
@Repository
public class UserPermissionRepository extends BaseRepository<UserPermission> {
    public UserPermission getRoleById(int id) {
        Criteria criteria = getSession().createCriteria(UserPermission.class)
                .add(Restrictions.eq("user_id", id));

        return (UserPermission) criteria.uniqueResult();
    }
}
