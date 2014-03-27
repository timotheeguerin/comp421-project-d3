package main;

public class CallProcedure {
	public static void main(String[] args) {
		int guidemode = 0;
		if (args.length > 0)
		{
			guidemode = Integer.parseInt(args[0]);
		}
		DBProcess.executeProcedure(guidemode);
		System.out.println("Procedure executed with sucess");
	}
}
