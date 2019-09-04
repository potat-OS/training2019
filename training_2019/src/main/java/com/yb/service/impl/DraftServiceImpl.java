package com.yb.service.impl;

import com.yb.dao.DraftMapper;
import com.yb.entity.Count;
import com.yb.entity.Draft;
import com.yb.service.DraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jue-PC
 */
@Service
public class DraftServiceImpl implements DraftService {

    private final
    DraftMapper draftMapper;

    @Autowired
    public DraftServiceImpl(DraftMapper draftMapper) {this.draftMapper = draftMapper;}

    @Override
    public void insert(Draft draft) {
        draftMapper.insert(draft);
    }

    @Override
    public List<Draft> queryAll() {
        return draftMapper.queryAll();
    }

    @Override
    public Draft query(int id) {
        return draftMapper.query(id);
    }

    @Override
    public void updateState(int id) {
        draftMapper.updateState(id);
    }

    @Override
    public List<Count> count() {
        return draftMapper.count();
    }

    @Override
    public List<Draft> queryNotRead() {
        return draftMapper.queryNotRead();
    }
}
