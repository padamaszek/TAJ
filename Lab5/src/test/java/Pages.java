import org.jbehave.web.selenium.WebDriverProvider;

public class Pages {

    private WebDriverProvider driverProvider;

    //Pages
    private TelemanPage home;
    private TelemanSportPage sport;
    // ...

    public Pages(WebDriverProvider driverProvider) {
        super();
        this.driverProvider = driverProvider;
    }

    public TelemanPage home() {
        if (home == null) {
            home = new TelemanPage(driverProvider);
        }
        return home;
    }

    public TelemanSportPage sport(){
        if (sport == null) {
            sport = new TelemanSportPage(driverProvider);
        }
        return sport;
    }
}
