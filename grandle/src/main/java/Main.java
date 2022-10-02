import static spark.Spark.get;
import static spark.Spark.post;

public class Main {

    public static void main(String[] args) {

        post("/short", (req, res) -> UrlService.save(req.body()));
        get("/:key", (req, res) -> {
            res.redirect(UrlService.getOriginalUrl(req.params(":key")));
            return null;
        });
    }
}
