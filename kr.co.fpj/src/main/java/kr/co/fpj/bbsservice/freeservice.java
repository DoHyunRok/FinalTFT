package kr.co.fpj.bbsservice;

import java.util.ArrayList;
import java.util.List;

import kr.co.fpj.bbsvo.freevo;

public interface freeservice {

	ArrayList<freevo> boardList();
	int write(freevo vo);
	List getboard(freevo vo);
	int updateCnt(freevo vo);

}
