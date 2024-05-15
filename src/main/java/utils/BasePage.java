package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BasePage {
    //declaram un web driver
    public static WebDriver driver;

    //Adnotarea @BeforeMethod are grija sa execute metoda imediat urmatoare
    //inaintea fiecarei metode de test(inaintea fiecarei metode adnotate cu @Test)
    @BeforeMethod(alwaysRun = true)
    public void setup() {
        //Instantiem clasa ChromeOptions (exista o astfel de clasa corespondenta pentru fiecare browser)
        ChromeOptions options = new ChromeOptions();
        //Utilizand instanta clasei ChromeOptions setam diversi parametrii precum modul incognito
        options.addArguments("--incognito");

        //Creem o noua instanta de ChromeDriver iar intre paranteze dam ca si argument instanta de
        //ChromeOptions ca driver-ul nostru sa ia in considerare setarile facute de noi(ex: incognito mode)
        driver = new ChromeDriver(options);

        //Setam rezolutia la care porneste browserul nostru
        driver.manage().window().setSize(new Dimension(1920, 1080));

        //Setam timpul pentru implicitWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Putem adauga navigarea catre url aici daca testam o singura aplicatie
        //In cazul nostru neavand o aplicatie de test suficient de complexa
        //Vom naviga catre url din fiecare clasa de test in parte
        // driver.get("URL");

        TestListeners.driver = driver;
    }

    //Adnotarea @AfterMethod are grija sa execute metoda imediat urmatoare
    //dupa fiecare metoda de test(dupa fiecare metoda adnotata cu @Test)
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        //Inchidem browserul dupa executia testului
        driver.quit();
    }
}
