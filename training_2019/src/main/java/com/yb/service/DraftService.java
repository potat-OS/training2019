package com.yb.service;

import com.yb.entity.Count;
import com.yb.entity.Draft;

import java.util.List;

/**
 * @author Jue-PC
 */
public interface DraftService {
    /**
     * @param draft
     */
    void insert(Draft draft);

    /**
     * query all
     */
    List<Draft> queryAll();

    /**
     * @param id
     */
    Draft query(int id);

    /**
     * @param id
     */
    void updateState(int id);

    /**
     * @return list
     */
    List<Count> count();

    /**
     * @return list
     */
    List<Draft> queryNotRead();
}
