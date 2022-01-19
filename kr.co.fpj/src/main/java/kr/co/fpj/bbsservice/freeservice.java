package kr.co.fpj.bbsservice;

import java.util.ArrayList;
import java.util.List;

import kr.co.fpj.bbsvo.PageVO;
import kr.co.fpj.bbsvo.freevo;

public interface freeservice {

	int write(freevo vo);
	List<freevo> getboard(freevo vo);
	int updateCnt(freevo vo);
	ArrayList<freevo> searchTitle(String bs);
	ArrayList<freevo> searchContent(String bs);
	ArrayList<freevo> boardList(PageVO pvo);
	ArrayList<freevo> nextpage(int cpage);
	ArrayList<freevo> cntsort();
	ArrayList<freevo> cntboardlist(PageVO pvo);
	ArrayList<freevo> commentcntboardlist(PageVO pvo);
	ArrayList<freevo> regboardlist(PageVO pvo);

}
