import java.sql.SQLException;
import java.util.Date;


import static spark.Spark.post;


public class Main {

    public static void main(String[] args) throws SQLException {
        CreateTable.CreateTable();
        TableOperations tableOperations = new TableOperations();
        post("/add", (req, res) -> {
            TableOperations.add(req.body(), RandomString.getShortUrlRandom());
            return null;
        });
        post("/get", (req, res) -> TableOperations.getShortUrl(req.body()));
        post("/che", (req, res) -> TableOperations.check(req.body()));


    }
}
