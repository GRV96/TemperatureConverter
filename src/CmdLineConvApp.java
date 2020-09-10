import conversion.ConversionController;
import conversion.ConversionData;

public final class CmdLineConvApp {

	private CmdLineConvApp() {} // Prevents instantiation.

	private static ConversionData getConvDataFromCmdLine(String[] args) {
		if(args.length < 3) {
			return null;
		}
		// Returns null if args are invalid.
		return ConversionData.createInstance(args[0], args[1], args[2]);
	}

	public static void main(String[] args) {
		ConversionData convData = getConvDataFromCmdLine(args);
		if(convData == null) {
			System.err.println("Incorrect arguments");
		}
		else {
			ConversionController convController = new ConversionController();
			double outputTemp = convController.convert(convData);
			System.out.println(outputTemp);
		}
	}
}
