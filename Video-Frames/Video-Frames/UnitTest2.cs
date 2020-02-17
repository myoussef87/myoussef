using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium.Appium.Windows;
using NUnit.Framework;
using OpenQA.Selenium;
using System.Threading;
using System.Configuration;
using OpenQA.Selenium.Support.PageObjects;
using System.Diagnostics;


namespace Video_Frames
{
    [TestClass]
    public class UnitTest2
    {
        [FindsBy(How = How.XPath, Using = "//*[@id='search-field-input' or @id='search-input']")]
        public IWindow SearchField { get; set; }
        private readonly WindowsDriver<WindowsElement> _driver;
        public WindowsElement ZeroButton => _driver.FindElementByName("Zero");
        public static void Main(string[] args)
        {
            TestMethod1();
        }
        //private WindowsDriver<WindowsElement> driver;
        /*  [SetUp]
          public void TestInit()
          {
              var appCapabilities = new OpenQA.Selenium.Appium.AppiumOptions();
              appCapabilities.AddAdditionalCapability("app", @"Microsoft.MicrosoftStickyNotes_8wekyb3d8bbwe!App");
              //appCapabilities.AddAdditionalCapability("deviceName", "WindowsPC");
              driver = new WindowsDriver<WindowsElement>(new Uri("http://127.0.0.1:4723"), appCapabilities);
              driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(5);
          }
          [Test]
          public void Test01()
          {
              driver.FindElement(By.Id("ContentElement")).Click();
              driver.FindElement(By.Id("NoteMenuButton")).Click();
              driver.FindElement(By.Name("All notes")).Click();
          }
          [TearDown]
          public void TestCleanup()
          {
              driver.Quit();
          }

               */

 


        [Test]

        public static void TestMethod1()
        {

        // Use the session to control the app
        // Appium.WebDriver.4.1.1
            var VideoFramesApp = ConfigurationManager.AppSettings["VideoFramesApp"];
            var WinappDriverHost = ConfigurationManager.AppSettings["WinappDriverHost"];
            var appiumOptions = new OpenQA.Selenium.Appium.AppiumOptions();
            appiumOptions.AddAdditionalCapability("app", VideoFramesApp);
            var Task1 = new WindowsDriver<WindowsElement>(new Uri(WinappDriverHost), appiumOptions);
            var WinExplorer = ConfigurationManager.AppSettings["WinExplorer"];
            var VideoBrowse = ConfigurationManager.AppSettings["Video.Browse.Name"];
            var VideoFilePath = ConfigurationManager.AppSettings["Video.File.Path"];
            var VideoFileXPath = ConfigurationManager.AppSettings["Video.File.XPath"];
            // Use the session to control the app
          
            Task1.FindElementByName(VideoBrowse).Click();
            Task1.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"Window\"][@Name=\"Frames Extractor and Combiner\"]/Window[@ClassName=\"#32770\"][@Name=\"Open\"]/ComboBox[@ClassName=\"ComboBox\"][@Name=\"File name:\"]/Edit[@ClassName=\"Edit\"][@Name=\"File name:\"]").SendKeys(VideoFilePath);
            Task1.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"Window\"][@Name=\"Frames Extractor and Combiner\"]/Window[@ClassName=\"#32770\"][@Name=\"Open\"]/Button[@ClassName=\"Button\"][@Name=\"Open\"]").Click();
            Task1.FindElementByAccessibilityId("PlayBtn").Click();
            Task1.FindElementByAccessibilityId("Time1").SendKeys("00:00:01");
            Task1.FindElementByAccessibilityId("Time2").SendKeys("00:00:02");
            Task1.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"Window\"][@Name=\"Frames Extractor and Combiner\"]/Button[@Name=\"Extract Frames\"][@AutomationId=\"ExtractFramesBtn\"]").Click();
            Thread.Sleep(TimeSpan.FromSeconds(5));
            Task1.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"#32770\"]/Button[@ClassName=\"Button\"][@Name=\"OK\"]").Click();
            appiumOptions.AddAdditionalCapability("app", WinExplorer);
            Task1 = new WindowsDriver<WindowsElement>(new Uri(WinappDriverHost), appiumOptions);
            Task1.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"CabinetWClass\"][@Name=\"File Explorer\"]/Pane[@ClassName=\"ReBarWindow32\"]/Pane[@ClassName=\"Address Band Root\"]/ProgressBar[@ClassName=\"msctls_progress32\"]/Pane[@ClassName=\"Breadcrumb Parent\"]/ToolBar[@ClassName=\"ToolbarWindow32\"][@Name=\"Address: Quick access\"]").Click();
            Thread.Sleep(TimeSpan.FromSeconds(5));
            Task1.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"CabinetWClass\"][@Name=\"File Explorer\"]/Pane[@ClassName=\"ReBarWindow32\"]/Pane[@ClassName=\"Address Band Root\"]/ProgressBar[@ClassName=\"msctls_progress32\"]/ComboBox[@ClassName=\"ComboBox\"][@Name=\"Address\"]/Edit[@ClassName=\"Edit\"][@Name=\"Address\"]").SendKeys("Z:\\APTC-ML\\APTCE-Muhammad Motawe\\VideoSynopsis\\");
            
            Task1.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"CabinetWClass\"][@Name=\"File Explorer\"]/Pane[@ClassName=\"ReBarWindow32\"]/Pane[@ClassName=\"Address Band Root\"]/ProgressBar[@ClassName=\"msctls_progress32\"]/ToolBar[@ClassName=\"ToolbarWindow32\"][@Name=\"Address band toolbar\"]/Button").Click();
            Task1.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"CabinetWClass\"][@Name=\"VideoSynopsis\"]/Pane[@ClassName=\"ShellTabWindowClass\"][@Name=\"VideoSynopsis\"]/Pane[@ClassName=\"DUIViewWndClassName\"]/Pane[@Name=\"Shell Folder View\"][@AutomationId=\"listview\"]/List[@ClassName=\"UIItemsView\"][@Name=\"Items View\"]/ListItem[@ClassName=\"UIItem\"][@Name=\"1119  12-17-2019 4-27-54 PM\"]/Edit[@Name=\"Name\"][@AutomationId=\"System.ItemNameDisplay\"]").Click();
            Task1.Keyboard.PressKey(Keys.Enter);
            string text;
            text = Task1.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"CabinetWClass\"][@Name=\"1119  12-17-2019 4-27-54 PM\"]/Pane[@ClassName=\"ShellTabWindowClass\"][@Name=\"1119  12-17-2019 4-27-54 PM\"]/Pane[@ClassName=\"DUIViewWndClassName\"]/StatusBar[@Name=\"Status bar\"][@AutomationId=\"StatusBarModuleInner\"]/Group[@Name=\"Property Field\"][@AutomationId=\"System.StatusBarViewItemCount\"]/Text[@Name=\"32 items\"][@AutomationId=\"PropertyValue\"]").GetAttribute("Name");
            Console.WriteLine(text);
            Microsoft.VisualStudio.TestTools.UnitTesting.Assert.AreEqual("32 items",text );
         
        }
        [Test]

        public static void TestMethod21()
        {

            // Use the session to control the app
            // Appium.WebDriver.4.1.1

            //DesiredCapabilities appCapabilities = new DesiredCapabilities();
            //appCapabilities.SetCapability("app", "Root");
            //WindowsDriver<WindowsElement>  DesktopSession = new WindowsDriver<WindowsElement>(new Uri("http://127.0.0.1:4723"), appCapabilities);

            //// Use the session to control the desktop
            //DesktopSession.Keyboard.PressKey(OpenQA.Selenium.Keys.Command + "a" + OpenQA.Selenium.Keys.Command);
            Process.Start("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe");
            
            var appiumOptions = new OpenQA.Selenium.Appium.AppiumOptions();
            appiumOptions.AddAdditionalCapability("app", "Z:\\APTC-Developers\\APTCE-Ahmed Rabi\\New Release\\Release\\VidNow.exe");
            //appiumOptions.AddAdditionalCapability("app", "Root");
            var Task1 = new WindowsDriver<WindowsElement>(new Uri("http://127.0.0.1:4723"), appiumOptions);
            Task1.Keyboard.PressKey(OpenQA.Selenium.Keys.Command + "a" + OpenQA.Selenium.Keys.Command);
            var WinExplorer = ConfigurationManager.AppSettings["WinExplorer"];
            var VideoBrowse = ConfigurationManager.AppSettings["Video.Browse.Name"];
            var VideoFilePath = ConfigurationManager.AppSettings["Video.File.Path"];
            var VideoFileXPath = ConfigurationManager.AppSettings["Video.File.XPath"];
            // Use the session to control the app
            Task1.FindElementByAccessibilityId("BrowseBtn").Click();
            Task1.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"Window\"][@Name=\"VidNow\"]/Window[@ClassName=\"#32770\"][@Name=\"Open\"]/ComboBox[@ClassName=\"ComboBox\"][@Name=\"File name:\"]/Edit[@ClassName=\"Edit\"][@Name=\"File name:\"]").SendKeys("Z:\\APTC-ML\\APTCE-Muhammad Motawe\\VideoSynopsis\\1123.mp4");
            Task1.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"Window\"][@Name=\"VidNow\"]/Window[@ClassName=\"#32770\"][@Name=\"Open\"]/Button[@ClassName=\"Button\"][@Name=\"Open\"]").Click();
            Task1.FindElementByAccessibilityId("StartTimeTxt").SendKeys("00:00:01");
            Task1.FindElementByAccessibilityId("EndTimeTxt").SendKeys("00:00:02");
            Task1.FindElementByAccessibilityId("VGenerateBtn").Click();
            
            Task1.FindElementByAccessibilityId("EndTimeTxt").SendKeys("00:00:03");
            Thread.Sleep(TimeSpan.FromSeconds(5));

        }
    }

}