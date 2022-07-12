package pages.RR.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BooksPage extends BasePage {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public void downloadEBook(String fileName){
        click(By.xpath("//*[@data-file='" + fileName + "']"));
        logger.info("Download button clicked.");
    }

    public void verifyDownloadedBook(String fileName, long fileSize){
        assertFile(fileName, fileSize);
    }
}
