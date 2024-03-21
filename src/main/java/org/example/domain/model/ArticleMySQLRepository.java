package org.example.domain.model;

import org.example.base.CommonUtil;

import java.sql.*;
import java.util.ArrayList;
public class ArticleMySQLRepository implements Repository{
    CommonUtil commonUtil = new CommonUtil();
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/t2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    @Override
    public void makeTestData() {

    }

    @Override
    public ArrayList<Article> findArticleByKeyword(String keyword) {
        return null;
    }

    @Override
    public Article findArticleById(int id) {
        return null;
    }

    @Override
    public void deleteArticle(Article article) {

    }

    @Override
    public void updateArticle(Article article, String newTitle, String newBody) {

    }

    @Override
    public ArrayList<Article> findAll() {
        return null;
    }

    @Override
    public Article saveArticle(String title, String body) {

        // article 테이블에 게시물 저장
        try {
            // 데이터베이스에 연결
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // 게시물 객체 생성
            Article article = new Article(title, body, 0, commonUtil.getCurrentDateTime());

            // SQL 문 생성
            String sql = "INSERT INTO article (title, body, hit, regDate) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // 게시물 객체의 필드 값을 SQL 문에 설정
            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setString(2, article.getBody());
            preparedStatement.setInt(3, article.getHit());
            preparedStatement.setString(4, article.getRegDate());

            // SQL 문 실행
            preparedStatement.executeUpdate();

            // 리소스 해제
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
