using OpenQA.Selenium.Appium.Windows;


namespace Video_Frames.Views
{
    public partial class VideoView
    {
        public WindowsElement BrowseButton => _driver.FindElementByAccessibilityId("BrowseBtn");
        public WindowsElement PathTextbox => _driver.FindElementByAccessibilityId("PathTxt");
        public WindowsElement WidthTextbox => _driver.FindElementByAccessibilityId("WidthOptionTxt");
        public WindowsElement HeightTextbox => _driver.FindElementByAccessibilityId("HeightOptionTxt");
        public WindowsElement FPSTextbox => _driver.FindElementByAccessibilityId("FPSOptionTxt");
        public WindowsElement ClassTextbox => _driver.FindElementByAccessibilityId("VTypeTxt");
        public WindowsElement ConfidencetTextbox => _driver.FindElementByAccessibilityId("VConfidenceTxt");
        public WindowsElement StartTimeTextbox => _driver.FindElementByAccessibilityId("StartTimeTxt");
        public WindowsElement EndTimeTextbox => _driver.FindElementByAccessibilityId("EndTimeTxt");
        public WindowsElement CaptureTimeTextbox => _driver.FindElementByAccessibilityId("FakeTimeTxt");
        public WindowsElement GenerateButton => _driver.FindElementByAccessibilityId("VGenerateBtn");
        public WindowsElement FileNameTextbox => _driver.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"Window\"][@Name=\"VidNow\"]/Window[@ClassName=\"#32770\"][@Name=\"Open\"]/ComboBox[@ClassName=\"ComboBox\"][@Name=\"File name:\"]/Edit[@ClassName=\"Edit\"][@Name=\"File name:\"]");
        public WindowsElement OpenButton => _driver.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"Window\"][@Name=\"VidNow\"]/Window[@ClassName=\"#32770\"][@Name=\"Open\"]/Button[@ClassName=\"Button\"][@Name=\"Open\"]");
        public WindowsElement UseGPUCheckbox => _driver.FindElementByXPath("/ Pane[@ClassName =\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"Window\"][@Name=\"VidNow\"]/CheckBox[@ClassName=\"CheckBox\"][@Name=\"Use GPU\"]/Text[@ClassName=\"TextBlock\"][@Name=\"Use GPU\"]");
        public WindowsElement FramesRadiobox => _driver.FindElementByName("Frames");
        public WindowsElement FramesWithDetectionsRadiobox => _driver.FindElementByName("Frames with Detections");
        public WindowsElement VideoWithDetectionsRadiobox => _driver.FindElementByName("Video with Detections");
        public WindowsElement QuickAccess => _driver.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"CabinetWClass\"][@Name=\"File Explorer\"]/Pane[@ClassName=\"ReBarWindow32\"]/Pane[@ClassName=\"Address Band Root\"]/ProgressBar[@ClassName=\"msctls_progress32\"]/Pane[@ClassName=\"Breadcrumb Parent\"]/ToolBar[@ClassName=\"ToolbarWindow32\"][@Name=\"Address: Quick access\"]");
        public WindowsElement QuickAccessAddress => _driver.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"CabinetWClass\"][@Name=\"File Explorer\"]/Pane[@ClassName=\"ReBarWindow32\"]/Pane[@ClassName=\"Address Band Root\"]/ProgressBar[@ClassName=\"msctls_progress32\"]/ComboBox[@ClassName=\"ComboBox\"][@Name=\"Address\"]/Edit[@ClassName=\"Edit\"][@Name=\"Address\"]");
        public WindowsElement QuickAccessGo => _driver.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"CabinetWClass\"][@Name=\"File Explorer\"]/Pane[@ClassName=\"ReBarWindow32\"]/Pane[@ClassName=\"Address Band Root\"]/ProgressBar[@ClassName=\"msctls_progress32\"]/ToolBar[@ClassName=\"ToolbarWindow32\"][@Name=\"Address band toolbar\"]/Button[@Name=\"Go to &quot;using System;&quot;\"]");
        public WindowsElement TotalItems => _driver.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"CabinetWClass\"][@Name=\"1119  12-17-2019 4-27-54 PM\"]/Pane[@ClassName=\"ShellTabWindowClass\"][@Name=\"1119  12-17-2019 4-27-54 PM\"]/Pane[@ClassName=\"DUIViewWndClassName\"]/StatusBar[@Name=\"Status bar\"][@AutomationId=\"StatusBarModuleInner\"]/Group[@Name=\"Property Field\"][@AutomationId=\"System.StatusBarViewItemCount\"]/Text[@Name=\"32 items\"][@AutomationId=\"PropertyValue\"]");
        public WindowsElement VideoGenerationStatusBar => _driver.FindElementByAccessibilityId("Status");
        public WindowsElement VideoUseGPU => _driver.FindElementByXPath("/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@ClassName=\"Window\"][@Name=\"VidNow\"]/CheckBox[@ClassName=\"CheckBox\"][@Name=\"Use GPU\"]");
    }
}
