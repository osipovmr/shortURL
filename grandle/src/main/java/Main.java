import java.sql.SQLException;

import static spark.Spark.post;

public class Main {

    public static void main(String[] args) throws SQLException {
        CreateTable.CreateTable();
        post("/add", (req, res) -> UrlService.getShortUrl(req.body()));



    }
}
