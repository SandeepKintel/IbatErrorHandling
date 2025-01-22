package IbatAttemptToRecovery.IbatErrorHandling;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IbatTemplates 
{
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Editor')]")
	WebElement Editor;
	
	@FindBy(xpath="//div[contains(text(),'Templates')]")
	WebElement TemplateText;
	
	@FindBy(xpath="//h3[contains(text(),'Contact us')]")
	WebElement ContactUsField;
	
	@FindBy(xpath="//footer[@aria-label='Block: Footer']")
	WebElement Footer;
	
	@FindBy(xpath="//button[@class=\"components-button components-toolbar-button\"]")
	WebElement EditFooter;
	
	@FindBy(xpath="//iframe[@class='edit-site-visual-editor__editor-canvas']")
	WebElement IframeLocator;
	
	@FindBy(xpath="//button[@class='components-button components-flex-item editor-entities-saved-states__save-button css-13y8vek e19lxcc00 is-primary']")
	WebElement SaveButtonTemplate;
	
	
	
	public void ClickEditor()
	{
		Editor.click();
	}
	
	public void ClickTemplate()
	{
		TemplateText.click();
	}
	
	public void ClickFooter()
	{
		Footer.click();
	}
	
	public void EnableContactField(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.doubleClick(ContactUsField).perform();
	}
	
	public void ClickContactUsField()
	{
		ContactUsField.sendKeys("_" + Keys.BACK_SPACE);
	}
	
	public void ClickTempSaveButton()
	{
		SaveButtonTemplate.click();
	}
	
	public IbatTemplates(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
