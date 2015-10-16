package com.mono.service;

import java.util.List;

/**
 *
 * @author prongbang
 * @param <T>
 * @param <PK>
 */
public interface BaseInterface<T, PK> {

    public List<T> findAll() throws Exception;

    public T findByPK(PK pk) throws Exception;

    public PK findLastPK() throws Exception;

    public int insert(T o) throws Exception;

    public int update(T o) throws Exception;

    public int delete(T o) throws Exception;

}
