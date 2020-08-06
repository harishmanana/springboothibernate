package com.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.spring.model.Login;
 
@Repository("loginDao")
public class LoginDaoImpl extends AbstractDao implements LoginDao{
 
    public void saveLogin(Login loginDetails) {
        persist(loginDetails);
    }
 
    @SuppressWarnings("unchecked")
    public List<Login> findAllLogins() {
        Criteria criteria = getSession().createCriteria(Login.class);
        return (List<Login>) criteria.list();
    }
 
    public void deleteLoginByUsername(String username) {
        Query query = getSession().createSQLQuery("delete from Login where username = :user");
        query.setString("user", username);
        query.executeUpdate();
    }
 
     
    public Login findByUsername(String username){
        Criteria criteria = getSession().createCriteria(Login.class);
        criteria.add(Restrictions.eq("username",username));
        return (Login) criteria.uniqueResult();
    }
     
    public void updateLogin(Login loginDetails){
        getSession().update(loginDetails);
    }
}