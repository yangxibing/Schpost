package com.schpost.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schpost.Dao.EvaluationDAO;
import com.schpost.entity.Evaluation;

@Service
public class EvaluationService {
	@Autowired
	EvaluationDAO edao;
	
	public int addEvaluation(String idOrder, String level, String content) {
		// TODO Auto-generated method stub
		Evaluation e = new Evaluation(Integer.parseInt(idOrder),Integer.parseInt(level),content);
		edao.save(e);
		
		return 1;
	}

}
