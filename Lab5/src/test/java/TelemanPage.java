/**
 * Created by Hunter on 2015-04-08.
 */
import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

import java.util.concurrent.TimeUnit;

public class TelemanPage extends WebDriverPage {

    public TelemanPage(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void openHome() {
        get("http://www.teleman.pl");
        manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


}
