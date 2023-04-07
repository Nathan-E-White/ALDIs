package login;

import org.openqa.selenium.*;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.HashMap;

import javax.xml.xpath.XPathConstants;

public class Login implements ILogin {

    // https://www.baeldung.com/java-xpath
    private File file;

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private ThreadLocal<HashMap<String, Object>> vars = new ThreadLocal<HashMap<String, Object>>();
    private ThreadLocal<JavascriptExecutor> js = new ThreadLocal<JavascriptExecutor>();

    private ThreadLocal<XPath> xmlRoot;
    private ThreadLocal<XPath> p1;
    private ThreadLocal<XPath> p2;

    private WebElement usrNode;
    private WebElement pwdNode;
    private WebElement btnLogin;
    private WebElement btnSubmit;

    private void findUsernameNode(){
        this.usrNode = this.driver.get().findElement(By.name("email"));
    }

    private void findPasswordNode(){
        this.pwdNode = this.driver.get().findElement(By.name("password"));
    }

    private void findLoginButton(){

    }

    private void findSubmitButton(){

    }

    public Login () throws XPathExpressionException, NullPointerException {

        xmlRoot.set(XPathFactory.newInstance().newXPath());
        xmlRoot.set((XPath) xmlRoot.get().compile("(//a[contains(text(),'Log In')])[2]").evaluate(xmlRoot,
                XPathConstants.STRING));

        this.driver = new ThreadLocal<WebDriver>();
        this.vars.set(new HashMap<String, Object>());
        this.js.set((JavascriptExecutor) this.driver);

    }

    public void main (String[] args) {

        this.driver.get().get("https://shop.aldi.us/");
        this.driver.get().manage().window().setSize(new Dimension(606, 809));
        this.driver.get().findElement(By.xpath(xmlRoot.get().toString())).click();

        this.findUsernameNode();
        this.findPasswordNode();

        this.usrNode.click();
        this.usrNode.clear();
        this.usrNode.sendKeys("nwhitemizzou@gmail.com");

        this.pwdNode.click();
        this.pwdNode.clear();
        this.pwdNode.sendKeys("4ZTLn.xP24SXpUz");
    }
}
