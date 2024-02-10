package tests;

import entities.news;
import services.newsService;

public class mainClass {
    public static void main(String[] args) {
        news news1 = new news("War", "Jazzera", "Gaza");
        news news2 = new news("Peace", "Jazzera", "USA");
        news news3 = new news("Revolution", "Jazzera", "Tunisia");
        newsService ns = new newsService();
        ns.addnews(news1);
        ns.addnews(news2);
        ns.addnews(news3);

    }



}
