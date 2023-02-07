package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaSearchCarsPage extends CarvanaBasePage {

    public CarvanaSearchCarsPage(){
        super();
    }

    @FindBy(id = "header-facets-wrapper")
    public List<WebElement> filterOptions;

    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchInput;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = "div[class='result-tile']")
    public List<WebElement> searchResultTiles;

    @FindBy(css = "div[class='result-tile'] picture")
    public List<WebElement> tileImages;

    @FindBy(css = "svg[data-test='FavoriteIcon']")   //("div[class='favorite-vehicle'] svg")
    public List<WebElement> favoriteVehicles;

    @FindBy(css = "div[class='tk-frame middle-frame']")
    public List<WebElement> tileBody;

    @FindBy(css = "div[data-qa='inventory-type-experiment']")
    public List<WebElement> inventoryType;

    @FindBy(css = "div[class='year-make']")
    public List<WebElement> makeAndModel;

    @FindBy(css = "div[data-test='TrimMileage']")
    public List<WebElement> trimMileage;

    @FindBy(css = "div[data-testid='price']")
    public List<WebElement> price;

    @FindBy(css = "div[data-test='MonthlyPayment'] span")
    public List<WebElement> monthlyPayment;

    @FindBy(css = "div[class='down-payment']")
    public List<WebElement> downPayment;

    @FindBy(css = "div[data-qa='get-it-by']")
    public List<WebElement> deliveryChip;



}
