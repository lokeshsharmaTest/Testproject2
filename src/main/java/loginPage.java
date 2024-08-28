
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;


public class loginPage {

    private static IOSDriver driver;
    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        //Scenario 1
        successfulPurchaseFlow();
        //Scenario 2
        sortingItemsWithLowestPrice();
        //Scenario 3
        adding3ItemsInCartFlow();
    }

    public static void login(String username, String password) {
        // Enter UserName
        WebElement el4 = loginPage.driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Username\"`]"));
        el4.sendKeys(username);

        // Enter Password
        WebElement el6 = loginPage.driver.findElement(AppiumBy.className("XCUIElementTypeSecureTextField"));
        el6.sendKeys(password);

        // Click Login
        WebElement el8 = loginPage.driver.findElement(AppiumBy.accessibilityId("Login"));
        el8.click();
    }

    public static void successfulPurchaseFlow() throws InterruptedException, MalformedURLException {

        XCUITestOptions options = new XCUITestOptions()
                .setUdid("00008030-001A30E13A23402E")
                .setAutomationName("XCUITest").setPlatformName("iOS").setPlatformVersion("17.5.1").setDeviceName("Lokesh’s iPhone");
        driver = new IOSDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723/"), options);

        // Navigate to the page and interact with the elements on the guinea-pig page using id.
        driver.activateApp("com.apple.mobilesafari");
        driver.get("https://saucedemo.com");
        driver.context("NATIVE_APP");
        Thread.sleep(5000);

//      Login with User
        login("standard_user", "secret_sauce");

        var start = new Point(280, 136);
        var end = new Point(282, 144);
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

//      Scroll Down to add items in the cart
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        // Click Add the Cart
        var el9 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Add to cart\"`][1]"));
        el9.click();

        //  Scroll up to check check for Items added in the Cart.
        var startUp = new Point(303, 182);
        var endUP = new Point(305, 624);
        var swipeUp = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), startUp.getX(), startUp.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), endUP.getX(), endUP.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipeUp));

        // Click on Cart
        var el10 = driver.findElement(AppiumBy.accessibilityId("1"));
        el10.click();

        // Scroll down for checkout
        swipe = new Sequence(finger, 1);
        start = new Point(486, 339);
        end = new Point(300, 254);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        // Click on Checkout
        var el11 = driver.findElement(AppiumBy.accessibilityId("Checkout"));
        el11.click();

        //Enter Details
        var el12 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"First Name\"`]"));
        el12.sendKeys("Test");
        var el13 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Last Name\"`]"));
        el13.sendKeys("User");
        var el14 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Zip/Postal Code\"`]"));
        el14.sendKeys("12345");
        var el15 = driver.findElement(AppiumBy.accessibilityId("Done"));
        el15.click();
        var el16 = driver.findElement(AppiumBy.accessibilityId("Continue"));
        el16.click();

        // Scroll Down to Click on Finish
        swipe = new Sequence(finger, 1);
        start = new Point(486, 339);
        end = new Point(300, 254);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        // Click on Finish
        var el17 = driver.findElement(AppiumBy.accessibilityId("Finish"));
        el17.click();

        driver.quit();
    }

// End of Scenario  1...........................................................................................

//Case 2:  Login with performance_glitch_user, sort items by the lowest price, and purchase the first item (complete the purchase flow).

    public static void sortingItemsWithLowestPrice() throws InterruptedException, MalformedURLException {

        XCUITestOptions options = new XCUITestOptions()
                .setUdid("00008030-001A30E13A23402E")
                .setAutomationName("XCUITest").setPlatformName("iOS").setPlatformVersion("17.5.1").setDeviceName("Lokesh’s iPhone");
        driver = new IOSDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723/"), options);

//      Navigate to the page and interact with the elements on the guinea-pig page using id.
        driver.activateApp("com.apple.mobilesafari");
        driver.get("https://saucedemo.com");
        driver.context("NATIVE_APP");
        Thread.sleep(5000);

        login("performance_glitch_user", "secret_sauce");

//  Sort Item from Low to High
        var el2 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`value == \"Name (A to Z)\"`]"));
        el2.click();
        Thread.sleep(1000);
        var el3 = driver.findElement(AppiumBy.accessibilityId("Price (low to high)"));
        el3.click();

        var start = new Point(280, 136);
        var end = new Point(282, 144);
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

//      Scroll Down to add items in the cart
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        // Click Add the Cart
        var el9 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Add to cart\"`][1]"));
        el9.click();

//         Click on Cart
        var el10 = driver.findElement(AppiumBy.accessibilityId("1"));
        el10.click();

        // Scroll down for checkout
        swipe = new Sequence(finger, 1);
        start = new Point(486, 339);
        end = new Point(300, 254);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        // Click on Checkout
        var el11 = driver.findElement(AppiumBy.accessibilityId("Checkout"));
        el11.click();

        //Enter Details
        var el12 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"First Name\"`]"));
        el12.sendKeys("Test");
        var el13 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Last Name\"`]"));
        el13.sendKeys("User");
        var el14 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Zip/Postal Code\"`]"));
        el14.sendKeys("12345");
        var el15 = driver.findElement(AppiumBy.accessibilityId("Done"));
        el15.click();
        var el16 = driver.findElement(AppiumBy.accessibilityId("Continue"));
        el16.click();

        // Scroll Down to Click on Finish
        swipe = new Sequence(finger, 1);
        start = new Point(486, 339);
        end = new Point(300, 254);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        // Click on Finish
        var el17 = driver.findElement(AppiumBy.accessibilityId("Finish"));
        el17.click();

        driver.quit();
    }

// End of Scenario  2...........................................................................................

// Scneario 2 - Login with standard_user, sort items by highest price and add the three most expensive items to your cart. Close the Safari instance (terminate) and launch it again. Login with standard_user one more time and verify the three items are still added to your cart.

    public static void adding3ItemsInCartFlow() throws InterruptedException, MalformedURLException {

        XCUITestOptions options = new XCUITestOptions()
                .setUdid("00008030-001A30E13A23402E")
                .setAutomationName("XCUITest").setPlatformName("iOS").setPlatformVersion("17.5.1").setDeviceName("Lokesh’s iPhone");
        driver = new IOSDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723/"), options);

        // Navigate to the page and interact with the elements on the guinea-pig page using id.
        driver.activateApp("com.apple.mobilesafari");
        driver.get("https://saucedemo.com");
        driver.context("NATIVE_APP");
        Thread.sleep(5000);

//      Login with User
        login("standard_user", "secret_sauce");

        var start = new Point(280, 136);
        var end = new Point(282, 144);
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

//      Sort Items High to Low
        var el5 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`value == \"Name (A to Z)\"`]"));
        el5.click();
        Thread.sleep(1000);

        WebElement el19 = driver.findElement(AppiumBy.accessibilityId("Price (high to low)"));
        el19.click();

//      Scroll Down to add items in the cart
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

//       Add Items to the Cart
        var el7 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Add to cart\"`][1]"));
        el7.click();

        var e11 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Add to cart\"`][1]"));
        e11.click();

        var el9 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Add to cart\"`][1]"));
        el9.click();

//      Terminate the Driver and Reopen it
        driver.terminateApp("com.apple.mobilesafari");
        driver.activateApp("com.apple.mobilesafari");

//      Login with User
        login("standard_user", "secret_sauce");

//      Click on Cart
        var el12 = driver.findElement(AppiumBy.className("shopping_cart_badge"));
        el12.click();

    }
}
