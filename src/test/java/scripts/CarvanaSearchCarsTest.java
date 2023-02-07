package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaBasePage;
import pages.CarvanaSearchCarsPage;
import utilities.DataTest;
import utilities.Waiter;
import utilities.WindowHandler;

public class CarvanaSearchCarsTest extends CarvanaBase {

    @BeforeMethod
    public void setPage(){
        carvanaBasePage = new CarvanaBasePage();
        carvanaSearchCarsPage = new CarvanaSearchCarsPage();
        Waiter.pause(2);
        carvanaBasePage.searchCarsOption.click();
        WindowHandler.switchToChildWindow();
        Assert.assertEquals(driver.getCurrentUrl(), DataTest.searchCarsPageUrl);
    }

    /**
     * Test Case 5:
     * Test name = Validate the search filter options and search button
     * Test priority = 5
     * Given user is on "https://www.carvana.com/"
     * When user clicks on "SEARCH CARS" link
     * Then user should be routed to "https://www.carvana.com/cars"
     * And user should see filter options
     * |PAYMENT & PRICE     	|
     * |MAKE & MODEL	    	|
     * |BODY TYPE		|
     * |YEAR & MILEAGE     	|
     * |FEATURES	    	|
     * |MORE FILTERS		|
     */

    @Test(priority = 1, description = "Validate the search filter options and search button")
    public void validateSearchOptionsAndSearchButton(){

        String[] filterOptions = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        for (int i = 0; i < carvanaSearchCarsPage.filterOptions.size(); i++) {
            Assert.assertTrue(carvanaSearchCarsPage.filterOptions.get(i).isDisplayed());
            Assert.assertEquals(carvanaSearchCarsPage.filterOptions.get(i).getText(), filterOptions[i]);

        }


    }
    /**Test Case 6:
     Test name = Validate the search result tiles
     Test priority = 6
     Given user is on "https://www.carvana.com/"
     When user clicks on "SEARCH CARS" link
     Then user should be routed to "https://www.carvana.com/cars"
     When user enters "mercedes-benz" to the search input box
     And user clicks on "GO" button in the search input box
     Then user should see "mercedes-benz" in the url
     And validate each result tile

     VALIDATION OF EACH TILE INCLUDES BELOW
     Make sure each result tile is displayed with below information
     1. an image
     2. add to favorite button
     3. tile body
     ALSO VALIDATE EACH TILE BODY:
     Make sure each tile body has below information
     1. Inventory type - text should be displayed and should not be null or empty
     2. Year-Make-Model information - text should be displayed and should not be null or empty
     3. Trim-Mileage information - text should be displayed and should not be null or empty
     4. Price - Make sure that each price is more than zero
     5. Monthly Payment information - text should be displayed and should not be null or empty
     6. Down Payment information - text should be displayed and should not be null or empty
     7. Delivery chip must be displayed, and text is not null or empty
     */

    @Test(priority = 2, description = "Validate the search result tiles")
    public void validateSearchResultTiles(){
        carvanaSearchCarsPage.searchInput.sendKeys(DataTest.searchInputData);
        carvanaSearchCarsPage.searchInput.click();
        carvanaSearchCarsPage.goButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(DataTest.searchInputData));


        for (int i = 0; i < carvanaSearchCarsPage.searchResultTiles.size(); i++) {
            Assert.assertTrue(carvanaSearchCarsPage.tileImages.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.favoriteVehicles.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.tileBody.get(i).isDisplayed());

            Assert.assertTrue(carvanaSearchCarsPage.inventoryType.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.inventoryType.get(i).getText().isEmpty());

            Assert.assertTrue(carvanaSearchCarsPage.makeAndModel.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.makeAndModel.get(i).getText().isEmpty());

            Assert.assertTrue(carvanaSearchCarsPage.trimMileage.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.trimMileage.get(i).getText().isEmpty());

            Assert.assertTrue(carvanaSearchCarsPage.price.get(i).isDisplayed());
            int price = Integer.parseInt(carvanaSearchCarsPage.price.get(i).getText().replaceAll("[^0-9]", ""));
            Assert.assertTrue(price > 0);

            Assert.assertTrue(carvanaSearchCarsPage.monthlyPayment.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.monthlyPayment.get(i).getText().isEmpty());

            Assert.assertTrue(carvanaSearchCarsPage.downPayment.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.downPayment.get(i).getText().isEmpty());

            Assert.assertTrue(carvanaSearchCarsPage.deliveryChip.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.deliveryChip.get(i).getText().isEmpty());
            }

        }


    }




