package kr.co.fpj.bbsservice;

import java.util.ArrayList;
import java.util.List;

import kr.co.fpj.bbsvo.duovo;

public interface duoservice {

	ArrayList<duovo> boardList();

	int write(duovo vo);

	List<duovo> getboard(duovo vo);

	int updateCnt(duovo vo);

}
