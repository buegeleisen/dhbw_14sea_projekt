package filereader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by migue on 19.10.2016.
 */
public class ERPFileReaderTest {
    @Before
    public void setUp() throws Exception {
        ERPFileReader reader=new ERPFileReader("C:\\Users\\migue\\Desktop\\ObservedPath","C:\\Users\\migue\\Desktop\\ProcessedPath");

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void run() throws Exception {

    }

}