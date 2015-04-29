
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Hunter on 2015-04-22.
 */
public class TelemanTests {

    private static WebDriver driver;
    WebElement element;

    @BeforeClass
    public static void driverSetup() {
        // ChromeDrirver, FireforxDriver, ...
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hunter\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void homePage(){
        driver.get("http://www.teleman.pl");
        assertEquals("Program TV",driver.getTitle());
    }

    @Test
    public void register() throws InterruptedException {

        driver.get("http://www.teleman.pl/");
        driver.findElement(By.cssSelector("a[href*='/account']")).click();

        driver.findElement(By.cssSelector("a[href*='/accounts/signup']")).click();

        driver.findElement(By.id("id_username")).sendKeys("test");
        driver.findElement(By.id("id_email")).sendKeys("test@mail.com");
        driver.findElement(By.id("id_password")).sendKeys("password123");
        driver.findElement(By.xpath(".//*[@id='signupForm']/div[2]/input")).click();
        assertEquals("Użytkownik z taką nazwą jest już zarejestrowany.", driver.findElement(By.className("errorlist")).getText());
    }

    @Test
    public void login(){
        driver.get("http://www.teleman.pl/");
        driver.findElement(By.cssSelector("a[href*='/account']")).click();
        driver.findElement(By.id("id_username")).sendKeys("kekeke");
        driver.findElement(By.id("id_password")).sendKeys("password123");
        driver.findElement(By.xpath(".//*[@id='signupForm']/div[2]/input")).click();
        assertEquals("Nieprawidłowa nazwa użytkownika, email lub hasło. Pamietaj, że wielkość liter w haśle jest ważna.",driver.findElement(By.className("errorlist")).getText());
    }

    @Test
    public void search() throws IOException {
        driver.get("http://www.teleman.pl/");
        driver.findElement(By.xpath("//*[@id=\"search-form\"]/input[1]")).sendKeys("Liga Mistrzow");
        driver.findElement(By.xpath("//*[@id=\"search-form\"]/input[1]")).submit();
        driver.findElement(By.cssSelector("a[href*='/tv/Pilka-Nozna-Liga-Mistrzow-1305579")).click();
        assertEquals("rewanżowy mecz ćwierćfinałowy: Real Madryt - Atletico Madryt",driver.findElement(By.id("showMainInfo")).getText());
        assertEquals("CANAL+ Sport", driver.findElement(By.cssSelector("a[href*='/program-tv/stacje/CanalPlus-Sport#prog9974185")).getText());
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\Users\\Hunter\\Desktop\\screenshot.png"));
    }
    @Test
    public void loginAndCheck(){
        driver.get("http://www.morele.net/");
        driver.findElement(By.className("profile")).click();
        driver.findElement(By.name("email")).sendKeys("Ursus707@gmail.com");
        driver.findElement(By.name("password")).sendKeys("patryk1");
        driver.findElement(By.name("submitLogin")).click();
        driver.findElement(By.className("profile")).click();
        assertEquals("Patryk", driver.findElement(By.id("firstname")).getAttribute("value"));
        assertEquals("Adamaszek", driver.findElement(By.id("lastname")).getAttribute("value"));
        assertEquals("691766007", driver.findElement(By.id("phone")).getAttribute("value"));
        driver.findElement(By.className("logout")).click();
    }

    @Test
    public void addToCart(){
        driver.get("http://www.morele.net/");
        driver.findElement(By.className("profile")).click();
        driver.findElement(By.name("email")).sendKeys("Ursus707@gmail.com");
        driver.findElement(By.name("password")).sendKeys("patryk1");
        driver.findElement(By.name("submitLogin")).click();
        driver.findElement(By.className("department")).click();
        driver.findElement(By.cssSelector("a[href*='/komputer-morele-harcot-asus-gaming-kit-690856/")).click();

        driver.findElement(By.xpath(".//*[@id='right']/div/div[2]/p[4]/a/img")).click();

        driver.findElement(By.cssSelector("a[href*='/koszyk")).click();
        assertEquals("Komputer Morele Harcot Asus Gaming Kit", driver.findElement(By.xpath(".//*[@id='overflow']/form[2]/table/tbody/tr[1]/td[3]/a")).getText());
        driver.findElement(By.className("delete")).click();
        driver.findElement(By.className("logout")).click();
    }


    /*@AfterClass
    public static void cleanp() {
        driver.quit();
    }*/
}
