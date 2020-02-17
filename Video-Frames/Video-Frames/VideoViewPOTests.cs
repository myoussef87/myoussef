using System;
using System.Text;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.Windows;
using OpenQA.Selenium.Remote;
using Video_Frames.Views;
using System.Configuration;
using System.Threading;
using System.Diagnostics;

namespace Video_Frames
{

    [TestFixture]
    public class VideoViewPOTests
    {
        private WindowsDriver<WindowsElement> _driver;
        private VideoView _VideoView;

        [SetUp]
        public void TestInit()
        {
            Process.Start("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe");
            var appiumOptions = new AppiumOptions();
            appiumOptions.AddAdditionalCapability("app", "Root");
            appiumOptions.AddAdditionalCapability("app", "Z:\\APTC-Developers\\APTCE-Ahmed Rabi\\New Release\\Release\\VidNow.exe");
            appiumOptions.AddAdditionalCapability("deviceName", "WindowsPC");
            _driver = new WindowsDriver<WindowsElement>(new Uri("http://127.0.0.1:4723"), appiumOptions);
            _driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(5);
            _VideoView = new VideoView(_driver);
        }
        [TearDown]
        public void TestCleanup()
        {
            if (_driver != null)
            {
                _driver.Quit();
                _driver = null;
            }
        }

        [Test]
        public void BasicVideoGeneration()
        {
            _VideoView.PerformVideoGeneration("00:00:01","00:00:03");
        }
        
                
        //[Test]
        //[TestCase("00:00:01", "00:00:02","32 Items")]
        //[TestCase("00:00:01", "00:00:02","32 Items")]
        //[TestCase("00:00:01", "00:00:02","32 Items")]
        //public void Templatized(string input1, string input2, string expectedResult)
        //{
        //    _VideoView.PerformVideoGeneration(input1, input1);
        //    _VideoView.AssertResult(expectedResult);
        //}
        //        [TestCase("00:00:01", "00:00:02", String.Empty)]
        [Test]
        public void ValidationForStartTime()
        {
            _VideoView.ValidationForStartTime("00:00:01");
        }
    }
}
