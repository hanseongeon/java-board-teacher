package org.example.domain.controller;

import org.example.base.CommonUtil;
import org.example.domain.model.Article;
import org.example.domain.view.ArticleTestView;
import org.example.domain.view.ArticleView;
import org.example.domain.model.ArticleFileRepository;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SplittableRandom;

public class ArticleTestController {
    CommonUtil commonUtil = new CommonUtil();
    ArticleTestView articleView = new ArticleTestView();
    ArticleFileRepository articleFileRepository = new ArticleFileRepository();

    Scanner scan = commonUtil.getScanner();
    int WRONG_VALUE = -1;

    public Article findArticleById(String id) {
        int index = Integer.parseInt(id);
        return articleFileRepository.findById(index);

    }
    public void add() {

        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();

        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();

        articleFileRepository.saveArticle(title, body);
        System.out.println("게시물이 등록되었습니다.");

    }

    public void list() {
        ArrayList<Article> articleList = articleFileRepository.findAll();
        articleView.printArticleList(articleList); // 전체 출력 -> 전체 저장소 넘기기
    }
    public void delete() {
        System.out.print("삭제할 게시물 번호를 입력해주세요 : ");

        Article a1 = findArticleById(scan.nextLine());

        if (a1 == null) {
            System.out.println("없는 게시물입니다.");
            return;
        }

        articleFileRepository.deleteArticle(a1);
        System.out.printf("%d번 게시물이 삭제되었습니다.\n", a1.getId());
    }


}
