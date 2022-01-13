package kr.co.fpj.bbsservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.fpj.bbsdao.sidebardao;
import kr.co.fpj.bbsvo.sidebarvo;

@Service
public class sidebarimpl implements sidebar {
	@Autowired
	sidebardao dao;
	
	@Override
	public ArrayList<sidebarvo> boardList(){
		ArrayList<sidebarvo> boardList = dao.getboardlist();
		return boardList;
	}
	@Override
	public ArrayList<sidebarvo> searchboard(sidebarvo vo){
		ArrayList<sidebarvo> boardList = dao.Searchboardlist(vo);
		return boardList;
	}
}
