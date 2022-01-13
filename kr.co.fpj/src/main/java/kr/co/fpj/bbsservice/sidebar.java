package kr.co.fpj.bbsservice;

import java.util.ArrayList;

import kr.co.fpj.bbsvo.sidebarvo;

public interface sidebar {

	ArrayList<sidebarvo> boardList();

	ArrayList<sidebarvo> searchboard(sidebarvo vo);

}
