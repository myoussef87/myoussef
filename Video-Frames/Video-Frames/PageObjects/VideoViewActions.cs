using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium.Appium.Windows;
using NUnit.Framework;
using OpenQA.Selenium;
using System.Linq;
using System.Threading;
using OpenQA.Selenium.Support.UI;
using System.Configuration;
using OpenQA.Selenium.Support.PageObjects;
using OpenQA.Selenium.Appium;
using Microsoft.WindowsAPICodePack.Shell;
using Microsoft.WindowsAPICodePack.Shell.PropertySystem;


namespace Video_Frames.Views
{
    public partial class VideoView
    {
        private WindowsDriver<WindowsElement> _driver;
        string filePath = @"Z:\APTC-ML\APTCE-Muhammad Motawe\VideoSynopsis\Output-Video-With-Detections\1123 256 x 256.mp4";
        string FrameRate;
        string FrameWidth;
        string FrameHeight;
        private string GetTotalItems() => TotalItems.GetAttribute("Name");
        private string GetFrameRate() => FrameRate;
        public VideoView(WindowsDriver<WindowsElement> driver) => _driver = driver;
        
        public void PerformVideoGeneration(string StartTime,string EndTime)
        {
            VideoUseGPU.Click();
            BrowseButton.Click();
            FileNameTextbox.SendKeys("Z:\\APTC-ML\\APTCE-Muhammad Motawe\\VideoSynopsis\\1123.mp4");
            OpenButton.Click();
            StartTimeTextbox.SendKeys(StartTime);
            EndTimeTextbox.SendKeys(EndTime);
            GenerateButton.Click();
            _driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(10);
            Thread.Sleep(TimeSpan.FromSeconds(5));
            //WaitForStatusBar(VideoGenerationStatusBar, 20);
            //GetElementByAutomationID("ClassName", 10000);
            //WaitForElement("ClassName","StatusBar", 10);

            var appiumOptions = new AppiumOptions();
            var WinExplorer = ConfigurationManager.AppSettings["WinExplorer"];
            appiumOptions.AddAdditionalCapability("app", WinExplorer);
            _driver = new WindowsDriver<WindowsElement>(new Uri("http://127.0.0.1:4723"), appiumOptions);
            Thread.Sleep(TimeSpan.FromSeconds(5));
            QuickAccess.Click();
            QuickAccessAddress.SendKeys("Z:\\APTC-ML\\APTCE-Muhammad Motawe\\VideoSynopsis\\Output-Video-With-Detections\\");
            _driver.Keyboard.PressKey(Keys.Enter);
            var file = ShellFile.FromFilePath(filePath);

            // Read:

            FrameRate = file.Properties.System.Video.FrameRate.Value.ToString();
            FrameWidth = file.Properties.System.Video.FrameWidth.Value.ToString();
            FrameHeight = file.Properties.System.Video.FrameHeight.Value.ToString();
            //Console.WriteLine(FrameRate);
            AssertFrameRate("10000", "256", "256");

        }

        public void ValidationForStartTime(string EndTime)
        {
            BrowseButton.Click();
            FileNameTextbox.SendKeys("Z:\\APTC-ML\\APTCE-Muhammad Motawe\\VideoSynopsis\\1123.mp4");
            OpenButton.Click();
            EndTimeTextbox.SendKeys(EndTime);
            GenerateButton.Click();
            AssertValidationMessage("Please enter a valid Start Time ", VideoGenerationStatusBar.GetAttribute("Name"));
        }
            //public void WaitForElement(string IDType, string elementName, int time)
            //{
            //    var wait = new DefaultWait<WindowsDriver<WindowsElement>>(_driver)
            //    {
            //        Timeout = TimeSpan.FromSeconds(time),
            //        PollingInterval = TimeSpan.FromSeconds(0.5)
            //        //Message = $"Element with automationId \"{automationId}\" not found."
            //    };

            //    wait.IgnoreExceptionTypes(typeof(InvalidOperationException));

            //    wait.Until(_driver =>
            //    {
            //        int elementCount = 0;
            //        switch (IDType)
            //        {
            //            case "id":
            //                elementCount = _driver.FindElementsByAccessibilityId(elementName).Count;
            //                break;
            //            case "xpath":
            //                elementCount = _driver.FindElementsByXPath(elementName).Count;
            //                break;
            //            case "ClassName":
            //                elementCount = _driver.FindElementsByClassName(elementName).Count;
            //                break;
            //        }
            //        return elementCount > 0;
            //    });
            //}
            //public void WaitForStatusBar(WindowsElement elementName, int time)
            //{
            //    var wait = new DefaultWait<WindowsDriver<WindowsElement>>(_driver)
            //    {
            //        Timeout = TimeSpan.FromSeconds(time),
            //        PollingInterval = TimeSpan.FromSeconds(0.5)
            //    };

            //    wait.IgnoreExceptionTypes(typeof(InvalidOperationException));

            //    wait.Until(_driver =>
            //    {
            //        //_driver.SwitchTo().Window(_driver.WindowHandles[0]);
            //        return elementName.ToString().StartsWith("The Video Was Created Successfully");
            //    });
            //}

            //public WindowsElement GetElementByAutomationID(string automationId, int timeOut = 10000)
            //{
            //    WindowsElement element = null;

            //    var wait = new DefaultWait<WindowsDriver<WindowsElement>>(_driver)
            //    {
            //        //Timeout = TimeSpan.FromMilliseconds(timeOut),
            //        Message = $"Element with automationId \"{automationId}\" not found."
            //    };

            //    wait.IgnoreExceptionTypes(typeof(WebDriverException));

            //    try
            //    {
            //        wait.Until(_driver =>
            //        {
            //            element = _driver.FindElementByAccessibilityId(automationId);
            //            return element != null;
            //        });
            //    }
            //    catch (WebDriverTimeoutException ex)
            //    {
            //        //LogSearchError(ex, automationId);
            //        NUnit.Framework.Assert.Fail(ex.Message);
            //    }

            //    return element;
            //}
        }
}
