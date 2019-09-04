package com.yb;

import com.yb.dao.DraftMapper;
import com.yb.dao.StuMapper;
import com.yb.entity.Count;
import com.yb.entity.Draft;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.yb.config.SpringMybatisConfig.class})
public class tests {
    @Resource
    DraftMapper draftMapper;

    @Resource
    StuMapper stuMapper;

    @Test
    public void test() {
        List<Count> list = draftMapper.count();
        System.out.println("!!!!!!!!!!!!!!"+list);
    }
}
