package com.tecsup.castell.dao.hibernate;

import com.tecsup.castell.dao.ArchivoPruebaDAO;
import com.tecsup.castell.model.ArchivoPrueba;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ArchivoPruebaDAOH extends BaseHibernateDAO implements ArchivoPruebaDAO {

    @Override
    public List<ArchivoPrueba> all() {
        Criteria criteria = this.getSession().createCriteria(ArchivoPrueba.class);
        return criteria.list();
    }

    @Override
    public ArchivoPrueba find(Long id) {
        Criteria criteria = this.getSession().createCriteria(ArchivoPrueba.class);
        criteria.add(Restrictions.eq("id", id));
        return (ArchivoPrueba) criteria.uniqueResult();
    }

    @Override
    public void save(ArchivoPrueba t) {
        this.getSession().save(t);
    }

    @Override
    public void update(ArchivoPrueba t) {
        this.getSession().merge(t);
    }

    @Override
    public void delete(ArchivoPrueba t) {
        this.getSession().delete(t);
    }
}
