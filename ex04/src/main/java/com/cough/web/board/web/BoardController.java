package com.cough.web.board.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cough.web.board.service.BoardService;
import com.cough.web.board.service.BoardVO;

@Controller
//@RestContreoller�Ұ���:page��û�ϴ� �޼��尡�ֱ⶧����

//default:foward�����(request��response�� ����������>client���Գ���x)<request
//redirect:client���� ��ȣ���� ��û��:client���Գ���o(request��response������)<response
//get������� ��û�ؾ߸���(�Ƹ��� url�� �پ������ϱ�  response/request������ �Ͱ� �����ϴϱ�)
public class BoardController {
	@Autowired
	BoardService boardservice;
	
	@GetMapping("boardList")
	public String getboardList(Model m) {
		m.addAttribute("boardList",boardservice.searchAll());
		return "board/boardList";//�̰� foward����̶�������~
	}
	
	@GetMapping("boardInfo")
	public String getboardInfo(int bno, Model m) {
		BoardVO vo=new BoardVO();
		vo.setBno(bno);
		//<�̷��� �������� requestparam�����(�ƴѵ�?������ �Ǵ� �� Ȯ����
		
//		Ŀ�ǵ� ��ü�� ���� ������
		//field��� ���� ���� ������Ʈ������ �����ϸ� �Ǳ� ������ vo�� �޾Ƶ� ��
		
		
		//location.href='boardInfo?bno=${list.bno}��������Ϸ��� ���������Է���
		BoardVO find=boardservice.search(vo);
		m.addAttribute("boardInfo",find);
		return "board/boardInfo";
	}
	//requestparam�� �ʼ�������� ��û�� �� �ֱ� ������ �긦 ���� �� �� ���� ��Ȳ�ϰ�?
	//public String boardInfo(@RequestParam int bno,Model m)
	//BoardVO vo=new BoardVO();
	//vo.setbno(bno)�ؾ���
	//command��ü�� �� �� ���� ���� data�� �޾ƿ� �� ����
	
	@GetMapping("boardInsert")
	public String insertBoardForm() {
		return "board/boardInsert";
	}
	@PostMapping("boardInsert")
	public String insertBoard(BoardVO vo) {
		int result=boardservice.insert(vo);
		return "redirect:boardList";
		////////���⼭ �����̷�Ʈ�ϴ�����:��ġ����(uri�Ǳ���)��ȭ������ġ��Ű�����ؼ�
	}
	
	//����-������:uri:boardUpdate,return-board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO vo,Model m) {
		BoardVO find=boardservice.search(vo);
		m.addAttribute("boardInfo",find);
		return"board/boardUpdate";
	}
//return�� �������, ���������̹Ƿ� String���� �θ�ȵ�
	//RequestBody��� json���� ������
	@PostMapping("boardUpdate")
	@ResponseBody//data��ȯ�ϱ⶧�����ʿ���
	public Map<String,Object> updateBoard(BoardVO vo,RedirectAttributes rtt,Model m) {
		boolean result=false;
		int boardNO=boardservice.update(vo);
		if(boardNO>-1) {
			result=true;
		}
		Map<String,Object>map=new HashMap<>();
		map.put("result", result);
		map.put("boardInfo", vo);
		
		
//����~~~~~~~�õ�		(return�������Ǳ�Ժ����ʾѿ�)
//		int result=boardservice.update(vo);
//		String msg="";
//		if(result>0) {
//			msg="success";
//		}else {
//			msg="fail";
//		}
		
		
//		rtt.addFlashAttribute("message",msg);
		//redirectattribute�� ���û�Ǵ�request�� ������ �����ϱ⶧���� ������ ������
		//session�� �ӽ�����ҷ� ���� �� ������ request�� paste
		//(session���ִ������»����>����ڰ����ΰ�ħ�ϸ������ϰ�����������������)
		
		BoardVO find=boardservice.search(vo);
		m.addAttribute("boardInfo",find);
		return map;
	}
	
	@GetMapping("boardDelete")
	public String deleteBoard(@RequestParam(name="bno",defaultValue="0") int bno) {
		//���鿡 ���� ó�������� defaultvalue�� 0���� ��??????????????????????????????
		
		//((@RequestParam int boardNO)<�̰͵� ��
		boardservice.delete(bno);
		return "redirect:boardList";
	}

}
