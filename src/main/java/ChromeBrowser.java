
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeBrowser {

    public static void main(String[] args) throws InterruptedException {

        //Scenario 1
        successfulPurchaseFlow();
        //Scenario 2
        adding3ItemsInCartFlow();
        //Scenario 3
        sortingItemsWithLowestPrice();

    }

    public static void successfulPurchaseFlow() throws InterruptedException {
        // Setting Path for driver
        System.setProperty("webdriver.chromedriver", "/usr/local/bin/chromedriver");

        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://saucedemo.com/");

        // Input Field
        WebElement usernameField = driver.findElement(By.id("user-name"));

        // Enter UserName
        usernameField.sendKeys("standard_user");
        Thread.sleep(1000);

        // Find the password input field
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter the password
        passwordField.sendKeys("secret_sauce");
        Thread.sleep(1000);

        // Find the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Click the login button
        loginButton.click();

        // Wait for the page to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Add Items to the CART
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        Thread.sleep(2000);

        //Click on Cart ICON
        WebElement clickOnCartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        clickOnCartIcon.click();
        Thread.sleep(2000);

        WebElement clickCheckOut = driver.findElement(By.id("checkout"));
        clickCheckOut.click();
        Thread.sleep(2000);

        // Enter the shipping details
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("Jhon");
        Thread.sleep(1000);

        WebElement secondNameField = driver.findElement(By.id("last-name"));
        secondNameField.sendKeys("Cena");
        Thread.sleep(1000);

        WebElement zipCodeField = driver.findElement(By.id("postal-code"));
        zipCodeField.sendKeys("2345");
        Thread.sleep(1000);

        WebElement clickContinue = driver.findElement(By.id("continue"));
        clickContinue.click();
        Thread.sleep(1000);

        WebElement clickFinish = driver.findElement(By.id("finish"));
        clickFinish.click();
        Thread.sleep(2000);

        // Close the browser window
        driver.quit();
    }


//////Scenario 2  -

//Case 1: Login with standard_user, sort items by highest price and add the three most expensive items to your cart. Close the Safari instance (terminate) and launch it again. Login with standard_user one more time and verify the three items are still added to your cart.

    public static void adding3ItemsInCartFlow() throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chromedriver", "/usr/local/bin/chromedriver");

        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://saucedemo.com/");

        // Input Field
        WebElement usernameField = driver.findElement(By.id("user-name"));

        // Enter UserName
        usernameField.sendKeys("standard_user");
        Thread.sleep(1000);

        // Find the password input field
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter the password
        passwordField.sendKeys("secret_sauce");
        Thread.sleep(1000);

        // Find the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Click the login button
        loginButton.click();

        // Wait for the page to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement filterDropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        filterDropdown.click();
        Thread.sleep(1000);

        // Select Price (High To Low)
        WebElement priceHighToLowOption = driver.findElement(By.xpath("//select[@class='product_sort_container']//option[text()='Price (high to low)']"));
        priceHighToLowOption.click();

        //Add Item 1 to Card
        WebElement addItem1 = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        addItem1.click();
        Thread.sleep(1000);

        WebElement addItem2 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addItem2.click();
        Thread.sleep(1000);

        WebElement addItem3 = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        addItem3.click();
        Thread.sleep(1000);

        //Exit the Browser
        driver.quit();
        //ReOpen The Browser
        driver = new ChromeDriver();
        driver.get("https://saucedemo.com/");
        usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        Thread.sleep(1000);
        passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        Thread.sleep(1000);
        loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

    }

    //Case 2:  Login with performance_glitch_user, sort items by the lowest price, and purchase the first item (complete the purchase flow).

    public static void sortingItemsWithLowestPrice() throws InterruptedException {
        System.setProperty("webdriver.chromedriver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com/");
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("performance_glitch_user");
        Thread.sleep(1000);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Wait for the page to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Click on Filter
        WebElement filterDropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        filterDropdown.click();
        Thread.sleep(1000);

        // Select Price (High To Low)
        WebElement priceHighToLowOption = driver.findElement(By.xpath("//select[@class='product_sort_container']//option[text()='Price (low to high)']"));
        priceHighToLowOption.click();

        //Select the lowest Prodcut
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        addToCartButton.click();
        Thread.sleep(2000);

        //Click on Cart ICON
        WebElement clickOnCartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        clickOnCartIcon.click();
        Thread.sleep(2000);

        WebElement clickCheckOut = driver.findElement(By.id("checkout"));
        clickCheckOut.click();
        Thread.sleep(2000);

        // Enter the shipping details
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("Jhon");
        Thread.sleep(1000);

        WebElement secondNameField = driver.findElement(By.id("last-name"));
        secondNameField.sendKeys("Cena");
        Thread.sleep(1000);

        WebElement zipCodeField = driver.findElement(By.id("postal-code"));
        zipCodeField.sendKeys("2345");
        Thread.sleep(1000);

        WebElement clickContinue = driver.findElement(By.id("continue"));
        clickContinue.click();
        Thread.sleep(1000);

        WebElement clickFinish = driver.findElement(By.id("finish"));
        clickFinish.click();
        Thread.sleep(2000);

        driver.quit();
    }
}