package lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Variant4Test {
    @Test(dataProvider = "intTaskProvider")
    public void intTaskTest(int a,int b, int res)
    {
        assertEquals(new Variant4().intTask(a, b),res);
    }
    @DataProvider
    public Object[][] intTaskProvider()
    {
        return new Object[][] {{4,2,2},{6,2,3}};
    }
    @Test(dataProvider = "booleanTaskProvider")
    public void booleanTaskTest(int a, int b, boolean res)
    {
        assertEquals(new Variant4().booleanTask(a,b),res);
    }
    @DataProvider
    public Object[][] booleanTaskProvider()
    {
        return new Object[][]{{4,3,true}, {10,10,false}};
    }
    @Test(dataProvider = "ifTaskProvider")
    public void ifTaskTest(int a, int b, int c, int res)
    {
        assertEquals(new Variant4().ifTask(a,b,c),res);
    }
    @DataProvider
    public Object[][] ifTaskProvider()
    {
        return new Object[][]{{1,2,3,3},{2,3,-1,2}};
    }
    @Test(dataProvider = "caseTaskProvider")
    public void caseTaskTest(int n, int res)
    {
        assertEquals(new Variant4().caseTask(n),res);
    }
    @DataProvider
    public Object[][] caseTaskProvider()
    {
        return new Object[][]{{1,31},{4,30},{2,28}};
    }
    @Test(dataProvider = "forTaskProvider")
    public void forTaskTest(double n, double res[])
    {
        assertEquals(new Variant4().forTask(n),res);
    }
    @DataProvider
    public Object[][]forTaskProvider()
    {
        return new Object[][]{{1,new double[]{1,2,3,4,5,6,7,8,9,10}}};
    }
    @Test(dataProvider = "whileTaskProvider")
    public void whileTaskTest(int n, boolean res)
    {
        assertEquals(new Variant4().whileTask(n),res);
    }
    @DataProvider
    public Object[][] whileTaskProvider()
    {
        return new Object[][]{{9,true},{8,false},{18,false},{27,true}};
    }
    @Test(dataProvider = "arrayTaskProvider")
    public void arrayTaskProvider (int n, int d, int a, int res[])
    {
        assertEquals(new Variant4().arrayTask(n,d,a),res);
    }
    @DataProvider
    public Object[][] arrayTaskProvider()
    {
        return new Object[][]{{3,2,3,new int[]{6,12,24}}};
    }
    @Test(dataProvider = "matrixTaskProvider")
    public void matrixTaskTest(int m, int arr[], int res[][])
    {
        assertEquals(new Variant4().matrixTask(m,arr),res);
    }
    @DataProvider
    public Object[][] matrixTaskProvider ()
    {
        return new Object[][]{{3,new int[]{1,2,3}, new int[][]{{1,2,3},{1,2,3},{1,2,3}}}};
    }
}
