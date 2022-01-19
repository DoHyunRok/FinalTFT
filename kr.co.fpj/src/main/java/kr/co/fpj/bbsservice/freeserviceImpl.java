package kr.co.fpj.bbsservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.fpj.bbsdao.freedao;
import kr.co.fpj.bbsvo.PageVO;
import kr.co.fpj.bbsvo.freevo;

@Service
public class freeserviceImpl implements freeservice {
	@Autowired
	freedao dao;
	
	@Override
	public ArrayList<freevo> boardList(PageVO pvo){
		ArrayList<freevo> boardList = dao.getboardlist(pvo);
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
	@Override
	public ArrayList<freevo> searchTitle(String bs){
		System.out.println(":::제목검색 SeIMPL:::");
		return dao.searchTitle(bs);
	}
	@Override
	public ArrayList<freevo> searchContent(String bs){
		System.out.println(":::내용검색 IMpL:::");
		return dao.searchContent(bs);
	}
	@Override
	public ArrayList<freevo> nextpage(int cpage){
		return dao.nextpage(cpage);
	}
	@Override
	public ArrayList<freevo> cntsort(){
		return dao.cntsort();
	}
	@Override
	public ArrayList<freevo> cntboardlist(PageVO pvo){
		return dao.getcntboardlist(pvo);
	}
	@Override
	public ArrayList<freevo> commentcntboardlist(PageVO pvo){
		return dao.getcommentboardlist(pvo);
	}
	@Override
	public ArrayList<freevo> regboardlist(PageVO pvo){
		return dao.getregboardlist(pvo);
	}
}
