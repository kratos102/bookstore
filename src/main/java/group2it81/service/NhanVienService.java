package group2it81.service;

import java.util.Collections;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Criterion;

import org.hibernate.Session;

import group2it81.configs.HibernateUtils;
import group2it81.pojo.NhanVien;
import group2it81.pojo.User;
import group2it81.pojo.Role;

import org.hibernate.query.Query;

public class NhanVienService {
    public List<NhanVien> searchNhanVien(String keyWord){
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            Criteria criteria = session.createCriteria(NhanVien.class);

            String p = String.format("%%%s%%", keyWord);

           Criterion p1 = Restrictions.like("ho", p);
           Criterion p2 = Restrictions.like("ten",p);
           Criterion p3 = Restrictions.like("queQuan", p);
           Criterion p4 = Restrictions.like("sdt",p);

           criteria.add(Restrictions.or(p1,p2,p3,p4));

           List<NhanVien> result = Collections.checkedList(criteria.list(), NhanVien.class);
            
           return result;
        }
    }

    public void addNhanVien(NhanVien nhanVien) {
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            Role role = session.get(Role.class,3);
            session.getTransaction().begin();
            nhanVien.setRole(role);
            session.save(nhanVien);
            session.getTransaction().commit();
        }
    }

    public List<Role> searchRole() {
        String hql = "FROM Role role WHERE role.roleName = 'Quan Ly'";
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            Query<Role> query = session.createQuery(hql);
            return query.list();
        }
    }
}
