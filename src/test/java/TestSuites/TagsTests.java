package TestSuites;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("TestCases")
@IncludeTags({"positivo","regressao"})
//@ExcludeTags("regressao")
public class TagsTests {
}
