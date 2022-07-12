package pages.EE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BooksPage extends BasePage {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    By downloadBookButton = By.xpath("//a[@title='Download The Exodus Effect - EBook']");

    public void downloadEEBook(String fileName){
        click(By.xpath("//a[contains(@href, '"+ fileName +"')]"));
        logger.info("Download button clicked.");
    }

    public void verifyDownloadedBook(String fileName, long fileSize){
        assertFile(fileName, fileSize);
    }
}
