package com.buss.shoppingcart.controller;

import com.buss.common.entity.DictType;
import com.buss.common.service.SysServiceI;
import com.buss.common.service.impl.SysServiceImpl;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.jweb.core.bean.Autocomplete;
import org.jweb.core.bean.DBTable;
import org.jweb.core.bean.PageMode;
import org.jweb.core.query.annotation.QueryStrategy;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

/**
 * Created by HongXinGuoJi-yzg on 2016/12/13.
 */
public class MyTimer extends TimerTask{



    @Override
    public void run() {

        QueryAndUpdateProduct queryAndUpdateProduct = new QueryAndUpdateProduct(new SysServiceI() {
            @Override
            public List<DictType> findDict(String dictGroupCode) {
                return null;
            }

            @Override
            public List<DBTable> getAllDbTableName() {
                return null;
            }

            @Override
            public Integer getAllDbTableSize() {
                return null;
            }

            @Override
            public Object save(Object entity) {
                return null;
            }

            @Override
            public <T> void saveOrUpdate(T entity) {

            }

            @Override
            public <T> void delete(T entity) {

            }

            @Override
            public <T> void batchSave(List<T> entitys) {

            }

            @Override
            public <T> T get(Class<T> class1, Serializable id) {
                return null;
            }

            @Override
            public <T> T getEntity(Class entityName, Serializable id) {
                return null;
            }

            @Override
            public <T> T findUniqueByProperty(Class<T> entityClass, String propertyName, Object value) {
                return null;
            }

            @Override
            public <T> List<T> findByProperty(Class<T> entityClass, String propertyName, Object value) {
                return null;
            }

            @Override
            public <T> List<T> loadAll(Class<T> entityClass) {
                return null;
            }

            @Override
            public <T> void deleteEntityById(Class entityName, Serializable id) {

            }

            @Override
            public <T> void deleteAllEntitie(Collection<T> entities) {

            }

            @Override
            public <T> void updateEntitie(T pojo) {

            }

            @Override
            public <T> List<T> findByQueryString(String hql) {
                return null;
            }

            @Override
            public int updateBySqlString(String sql) {
                return 0;
            }

            @Override
            public <T> List<T> findListbySql(String query) {
                return null;
            }

            @Override
            public <T> List<T> findByPropertyisOrder(Class<T> entityClass, String propertyName, Object value, boolean isAsc) {
                return null;
            }

            @Override
            public <T> List<T> getList(Class clas) {
                return null;
            }

            @Override
            public <T> T singleResult(String hql) {
                return null;
            }

            @Override
            public Session getSession() {
                return null;
            }

            @Override
            public List findByExample(String entityName, Object exampleEntity) {
                return null;
            }

            @Override
            public <T> List<T> getListByCriteriaQuery(CriteriaQuery cq, Boolean ispage) {
                return null;
            }

            @Override
            public <T> List<T> getAutoList(Autocomplete autocomplete) {
                return null;
            }

            @Override
            public Integer executeSql(String sql, List<Object> param) {
                return null;
            }

            @Override
            public Integer executeSql(String sql, Object... param) {
                return null;
            }

            @Override
            public Integer executeSql(String sql, Map<String, Object> param) {
                return null;
            }

            @Override
            public Object executeSqlReturnKey(String sql, Map<String, Object> param) {
                return null;
            }

            @Override
            public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
                return null;
            }

            @Override
            public Map<String, Object> findOneForJdbc(String sql, Object... objs) {
                return null;
            }

            @Override
            public List<Map<String, Object>> findForJdbc(String sql, int page, int rows) {
                return null;
            }

            @Override
            public <T> List<T> findObjForJdbc(String sql, int page, int rows, Class<T> clazz) {
                return null;
            }

            @Override
            public List<Map<String, Object>> findForJdbcParam(String sql, int page, int rows, Object... objs) {
                return null;
            }

            @Override
            public Long getCountForJdbc(String sql) {
                return null;
            }

            @Override
            public Long getCountForJdbcParam(String sql, Object[] objs) {
                return null;
            }

            @Override
            public <T> List<T> findHql(String hql, Object... param) {
                return null;
            }

            @Override
            public <T> List<T> pageList(DetachedCriteria dc, int firstResult, int maxResult) {
                return null;
            }

            @Override
            public <T> List<T> findByDetached(DetachedCriteria dc) {
                return null;
            }

            @Override
            public <T> PageMode<T> list4page(CriteriaQuery cq, int pageSize, int pageNo) {
                return null;
            }

            @Override
            public <T> List<T> list(CriteriaQuery cq) {
                return null;
            }
        });
        System.out.println("已运行!");
    }
}
