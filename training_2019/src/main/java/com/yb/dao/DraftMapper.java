package com.yb.dao;

import com.yb.entity.Count;
import com.yb.entity.Draft;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jue-PC
 */
@Repository
public interface DraftMapper {

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
