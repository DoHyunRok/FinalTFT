package kr.co.fpj.bbsservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.fpj.bbsdao.duodao;
import kr.co.fpj.bbsvo.duovo;
import kr.co.fpj.bbsvo.freevo;

@Service
public class duoserviceImpl implements duoservice {
	@Autowired
	duodao dao;
	
	@Override
	public ArrayList<duovo> boardList(){
		ArrayList<duovo> boardList = dao.getboardlist();
		return boardList;
	}
	@Override
	public int write(duovo vo){
		return dao.insertBoard(vo);
	}
	@Override
	public List getboard(duovo vo){
		List board = dao.getboard(vo);
		return board;
	}
	@Override
	public int updateCnt(duovo vo) {
		return dao.updateCnt(vo);
	}
}
