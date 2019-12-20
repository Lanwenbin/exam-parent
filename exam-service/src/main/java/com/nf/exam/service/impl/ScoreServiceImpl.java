package com.nf.exam.service.impl;

import com.nf.exam.dao.ScoreDao;
import com.nf.exam.entity.vo.ScoreVo;
import com.nf.exam.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	private ScoreDao scoreDao;
	@Override
	public List<ScoreVo> findUserExamInfo() {
		System.out.println("scoreDao = " + scoreDao.findUserExamInfo());
		return scoreDao.findUserExamInfo();
	}

}
