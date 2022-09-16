import java.sql.SQLException;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {

    public static void main(String[] args) throws SQLException {
        CreateTable.CreateTable();
        post("/short", (req, res) -> UrlService.getShortUrl(req.body()));
        get("/:key", (req, res) -> {
            res.redirect(UrlService.getOriginalUrl(req.params(":key")));
            return null;
        });
    }
}
