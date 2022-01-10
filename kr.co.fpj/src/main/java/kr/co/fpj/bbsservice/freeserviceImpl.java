package kr.co.fpj.bbsservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.fpj.bbsdao.freedao;
import kr.co.fpj.bbsvo.freevo;

@Service
public class freeserviceImpl implements freeservice {
	@Autowired
	freedao dao;
	
	@Override
	public ArrayList<freevo> boardList(){
		ArrayList<freevo> boardList = dao.getboardlist();
		return boardList;
	}
	@Override
	public int write(freevo vo){
		return dao.insertBoard(vo);
	}
	@Override
	public List<freevo> getboard(freevo vo){
		List<freevo> board = dao.getboard(vo);
		return board;
	}
	@Override
	public int updateCnt(freevo vo) {
		return dao.updateCnt(vo);
	}
	
	
}
