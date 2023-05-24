import java.io.IOException;

import test_Class_Pkg.Post_tc1;
import test_Class_Pkg.Post_tc2;
import test_Class_Pkg.Post_tc3;

public class DriverClass {

	public static void main(String[] args) throws IOException
	{
	
		Post_tc1.executor_post();
		Post_tc2.executor_post();
		Post_tc3.executor_post();
	}
}