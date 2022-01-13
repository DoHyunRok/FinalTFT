package kr.co.fpj.bbsservice;

import java.util.ArrayList;
import java.util.List;

import kr.co.fpj.bbsvo.freevo;

public interface freeservice {

	ArrayList<freevo> boardList();
	int write(freevo vo);
	List<freevo> getboard(freevo vo);
	int updateCnt(freevo vo);
	ArrayList<freevo> psort(freevo vo);

}
