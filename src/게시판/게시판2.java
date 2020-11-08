package 게시판;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;//날짜
import java.text.SimpleDateFormat;

public class 게시판2 {
    
	static ArrayList<Article> articleList = new ArrayList<>();
	 
	 static Date today = new Date();
	 static SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd");
	 
	//게시물 있는지 없는지 판독기
	public static int getArticleIndexById(int aid) {
		int index = -1; // -1 없다.
		for (int i = 0; i < articleList.size(); i++) {
			Article article = articleList.get(i);
			if (aid == article.getId()) {

				index = i;
			}

		}
		return index;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// 스캐너

		int id = 4;
        //요구사항7 테스트 데이터 등록
		Article a1 = new Article(1, "제목1", "내용1","익명");
		Article a2 = new Article(2, "제목2", "내용2","익명");
		Article a3 = new Article(3, "제목3", "내용3","익명");
		articleList.add(a1);
		articleList.add(a2);
		articleList.add(a3);
      
		
		// 무한반복
		while (true) {

			System.out.print("명령을 입력해주세요 :");
			String cmd = sc.nextLine();

			// 프로그램 종료
			if (cmd.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			// 게시물 제목 및 내용 등록
			if (cmd.equals("add")) {

				System.out.print("게시물 제목을 입력해주세요:");
				String ti = sc.nextLine();

				System.out.print("게시물 내용을 입력해주세요:");
				String bo = sc.nextLine();
				String m = "익명";
				System.out.println("게시물이 등록되었습니다.");

				Article article1 = new Article(id, ti, bo, m );
				articleList.add(article1);
				id++;

			}

			// add로 저장한거 출력
			if (cmd.equals("list")) {

				for (int i = 0; i < articleList.size(); i++) {
					Article a = articleList.get(i);
					System.out.println("번호 : " + a.getId());
					System.out.println("제목 :" + a.getTitle());
					System.out.println("작성자 : "+a.getMan());
					System.out.println("등록날짜 : "+date.format(today));
					System.out.println("====================");

				}
			}
			
			
            //요구사항5 게시물 수정 기능
			if (cmd.equals("update")) {
				System.out.print("수정할 게시물 번호:");
				String aid = sc.nextLine();
				int targetId = Integer.parseInt(aid);
				int index = getArticleIndexById(targetId);

				if (index == -1) {
					System.out.println("없는 게시물입니다.");
				} else {
					System.out.print("제목:");
					String title = sc.nextLine();

					System.out.print("내용:");
					String body = sc.nextLine();
					String m = "익명";
					Article article2 = new Article(targetId, title, body,m);
					articleList.set(index, article2);
				}
			}//요구사항5 게시물 수정 기능

			
			//요구사항6 게시물 삭제 기능
			if (cmd.equals("delete")) {
				System.out.print("삭제할 게시물 번호:");
				String aid = sc.nextLine();
				int targetId = Integer.parseInt(aid);
				int index = getArticleIndexById(targetId);

				if (index == -1) {
					System.out.println("없는 게시물입니다.");
				} else {
					articleList.remove(index);
					System.out.println("삭제가 완료되었습니다.");

				}

			}//요구사항6 게시물 삭제 기능
			
			
			//요구사항8 게시물 상세보기
			if (cmd.equals("read")) {
				System.out.print("보고싶은 게시물 번호:");
				String aid = sc.nextLine();
				int targetId = Integer.parseInt(aid);
				int index = getArticleIndexById(targetId);

				if (index == -1) {
					System.out.println("게시물이 존재하지 않습니다.");
				} else {

					Article article = articleList.get(index);
					System.out.println("====" + article.getId() + "번 게시물====");
					System.out.println("번호:" + article.getId());
					System.out.println("제목:" + article.getTitle());
					System.out.println("내용:" + article.getBody());
					System.out.println("========================");

				}
			}//요구사항8 게시물 상세보기

			
			
			
		} // 무한 반복
	}// main
}// class
