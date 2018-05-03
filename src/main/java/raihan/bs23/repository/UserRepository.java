package raihan.bs23.repository;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Repository;
import raihan.bs23.model.UserEntity;

/**
 * Created by Raihan on 6/21/2017.
 */

@Repository
public class UserRepository extends BaseRepository<UserEntity> {
    public UserEntity getUserByUsername(String username) {
        Criteria criteria = getSession().createCriteria(UserEntity.class)
                .add(Restrictions.eq("username", username).ignoreCase());

        return (UserEntity) criteria.uniqueResult();
    }

    public UserEntity getUser(int id){
        Criteria criteria = getSession().createCriteria(UserEntity.class)
                .add(Restrictions.eq("id", id));
        return (UserEntity) criteria.uniqueResult();
    }
}
