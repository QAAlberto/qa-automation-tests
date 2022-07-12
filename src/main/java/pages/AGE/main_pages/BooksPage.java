package pages.AGE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BooksPage extends BasePage {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public BooksPage downloadEEBook(String fileName){
        click(By.xpath("//button[@data-file='" + fileName + "']"));
        logger.info("Download button clicked.");
        return this;
    }

    public void verifyDownloadedBook(String fileName, long fileSize){
        assertFile(fileName, fileSize);
    }
}
