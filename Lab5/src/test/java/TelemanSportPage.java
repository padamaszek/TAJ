import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

import java.util.concurrent.TimeUnit;

/**
 * Created by Hunter on 2015-04-08.
 */
public class TelemanSportPage extends WebDriverPage {
    public TelemanSportPage(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void openSport() {
        get("http://www.teleman.pl/sport");
        manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
