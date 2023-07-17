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
//@RestContreoller불가능:page요청하는 메서드가있기때문에

//default:foward방식임(request와response가 깨지지않음>client에게노출x)<request
//redirect:client에게 재호출을 요청함:client에게노출o(request와response가깨짐)<response
//get방식으로 요청해야만됨(아마도 url에 붙어있으니까  response/request깨지는 것과 무관하니까)
public class BoardController {
	@Autowired
	BoardService boardservice;
	
	@GetMapping("boardList")
	public String getboardList(Model m) {
		m.addAttribute("boardList",boardservice.searchAll());
		return "board/boardList";//이게 foward방식이란말이지~
	}
	
	@GetMapping("boardInfo")
	public String getboardInfo(int bno, Model m) {
		BoardVO vo=new BoardVO();
		vo.setBno(bno);
		//<이렇게 받으려면 requestparam써야함(아닌데?실제론 되는 거 확인함
		
//		커맨드 객체로 받을 때에는
		//field명과 같은 것이 쿼리스트링내에 존재하면 되기 때문에 vo로 받아도 됨
		
		
		//location.href='boardInfo?bno=${list.bno}방식으로하려고 내가따로입력함
		BoardVO find=boardservice.search(vo);
		m.addAttribute("boardInfo",find);
		return "board/boardInfo";
	}
	//requestparam은 필수요건으로 요청할 수 있기 때문에 얘를 쓰는 게 더 좋은 상황일걸?
	//public String boardInfo(@RequestParam int bno,Model m)
	//BoardVO vo=new BoardVO();
	//vo.setbno(bno)해야함
	//command객체는 좀 더 많은 양의 data를 받아올 수 있음
	
	@GetMapping("boardInsert")
	public String insertBoardForm() {
		return "board/boardInsert";
	}
	@PostMapping("boardInsert")
	public String insertBoard(BoardVO vo) {
		int result=boardservice.insert(vo);
		return "redirect:boardList";
		////////여기서 리다이렉트하는이유:위치정보(uri의글자)와화면을일치시키기위해서
	}
	
	//수정-페이지:uri:boardUpdate,return-board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO vo,Model m) {
		BoardVO find=boardservice.search(vo);
		m.addAttribute("boardInfo",find);
		return"board/boardUpdate";
	}
//return이 수정대상, 성공여부이므로 String으로 두면안됨
	//RequestBody없어서 json으로 못보냄
	@PostMapping("boardUpdate")
	@ResponseBody//data반환하기때문에필요햄
	public Map<String,Object> updateBoard(BoardVO vo,RedirectAttributes rtt,Model m) {
		boolean result=false;
		int boardNO=boardservice.update(vo);
		if(boardNO>-1) {
			result=true;
		}
		Map<String,Object>map=new HashMap<>();
		map.put("result", result);
		map.put("boardInfo", vo);
		
		
//나의~~~~~~~시도		(return값을주의깊게보지않앗우)
//		int result=boardservice.update(vo);
//		String msg="";
//		if(result>0) {
//			msg="success";
//		}else {
//			msg="fail";
//		}
		
		
//		rtt.addFlashAttribute("message",msg);
		//redirectattribute는 재요청되는request에 정보를 복사하기때문에 정보가 유지됨
		//session을 임시저장소로 쓰며 그 정보를 request로 paste
		//(session에있던정보는사라짐>사용자가새로고침하면정보일관성이유지되지않음)
		
		BoardVO find=boardservice.search(vo);
		m.addAttribute("boardInfo",find);
		return map;
	}
	
	@GetMapping("boardDelete")
	public String deleteBoard(@RequestParam(name="bno",defaultValue="0") int bno) {
		//공백에 대한 처리때문에 defaultvalue를 0으로 둠??????????????????????????????
		
		//((@RequestParam int boardNO)<이것도 됨
		boardservice.delete(bno);
		return "redirect:boardList";
	}

}
