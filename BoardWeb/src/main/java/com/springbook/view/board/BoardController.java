package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	// xml기반의 HandlerMapping의 역할.
	// Command 객체가 동작 - 컨트롤러 메소드의 매개변수를 받아서 사용
	@RequestMapping("insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("===> InsertBoardController - 글등록 처리(POST)");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("===> UpdateBoardController - 글수정 처리");
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("===> DeleteBoardController - 글삭제 처리");
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("===> GetBoardListController - 글목록 처리");
		model.addAttribute("boardList", boardDAO.getBoardList(vo)); // Model
		return "getBoardList.jsp";
	}
	
	@RequestMapping("getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("===> GetBoardController - 글상세 처리");
		model.addAttribute("board", boardDAO.getBoard(vo)); // Model
		return "getBoard.jsp";
	}
	
}
