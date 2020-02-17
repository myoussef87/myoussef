using Microsoft.VisualStudio.TestTools.UnitTesting;


namespace Video_Frames.Views
{
    public partial class VideoView
    {
        public void AssertResult(string expectedReslt)
        {
            Assert.AreEqual(expectedReslt, GetTotalItems());
        }


        public void AssertFrameRate(string expectedFramerate , string expectedFrameWidth, string expectedFrameHeight)
        {
            Assert.AreEqual(expectedFramerate, FrameRate);
            Assert.AreEqual(expectedFrameWidth, FrameWidth);
            Assert.AreEqual(expectedFrameHeight, FrameHeight);
        }
        public void AssertValidationMessage(string expectedText, string StatusBar)
        {
            Assert.AreEqual(expectedText, StatusBar);      
        }
    }
}
