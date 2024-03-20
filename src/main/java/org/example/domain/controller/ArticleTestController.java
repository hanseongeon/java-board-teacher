package org.example.domain.controller;

import org.example.base.CommonUtil;
import org.example.domain.model.Article;
import org.example.domain.view.ArticleTestView;
import org.example.domain.view.ArticleView;
import org.example.domain.model.ArticleFileRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleTestController {
    CommonUtil commonUtil = new CommonUtil();
    ArticleTestView articleView = new ArticleTestView();
    ArticleFileRepository articleFileRepository = new ArticleFileRepository();

    Scanner scan = commonUtil.getScanner();
    int WRONG_VALUE = -1;

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


}
