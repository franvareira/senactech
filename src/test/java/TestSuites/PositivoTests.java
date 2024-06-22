package TestSuites;

import TestCases.RealizarCompraComSucessoCSVTest;
import TestCases.RealizarCompraComSucessoTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({RealizarCompraComSucessoCSVTest.class, RealizarCompraComSucessoTest.class})
public class PositivoTests {
}
