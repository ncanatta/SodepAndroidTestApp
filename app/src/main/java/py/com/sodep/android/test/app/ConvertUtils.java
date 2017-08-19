package py.com.sodep.android.test.app;

import java.math.BigDecimal;

/**
 * Created by nelson on 8/19/17.
 */

public class ConvertUtils {

    private static final BigDecimal USS_GS_EQUIVALENT = new BigDecimal("5700");

    // converts to celsius
    public static BigDecimal convertGsToUss(BigDecimal amount) {
        return amount.divide(USS_GS_EQUIVALENT);
    }

    // converts to fahrenheit
    public static BigDecimal convertUssToGs(BigDecimal amount) {
        return amount.multiply(USS_GS_EQUIVALENT);
    }
}
